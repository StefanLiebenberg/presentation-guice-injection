package example;


import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import java.util.Iterator;
import java.util.List;

public class ClockFormatter {

    private final Boolean formatAs24Hour;

    @Inject
    public ClockFormatter(@Named("Format24Hour") Boolean formatAs24Hour) {
        this.formatAs24Hour = formatAs24Hour;
    }

    public String format(ClockModel clock) {
        StringBuilder strBuilder = new StringBuilder();

        if (formatAs24Hour) {
            appendNumbersWithLeadingZero(strBuilder, ImmutableList.of(clock.getHours(), clock.getMinutes(), clock.getSeconds()));
        } else {
            Integer hour = clock.getHours();
            Boolean pm = hour > 12;
            appendNumbersWithLeadingZero(strBuilder, ImmutableList.of(hour % 12, clock.getMinutes(), clock.getSeconds()));
            strBuilder.append(" ").append(pm ? "PM" : "AM");
        }

        return strBuilder.toString();

    }

    private void appendNumbersWithLeadingZero(StringBuilder stringBuilder, List<Integer> numbers) {
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            appendNumberWithLeadingZero(stringBuilder, iterator.next());
            if (iterator.hasNext()) {
                stringBuilder.append(":");
            }
        }
    }

    private void appendNumberWithLeadingZero(StringBuilder stringBuilder, Integer number) {
        if (number < 10) {
            stringBuilder.append("0");
        }
        stringBuilder.append(number.toString());
    }
}
