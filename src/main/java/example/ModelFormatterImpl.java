package example;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class ModelFormatterImpl implements ModelFormatter {

    private final GreetingFormatter greetingFormatter;
    private final ClockFormatter clockFormatter;

    @Inject
    public ModelFormatterImpl(GreetingFormatter greetingFormatter, ClockFormatter clockFormatter) {
        this.greetingFormatter = greetingFormatter;
        this.clockFormatter = clockFormatter;
    }

    @Override
    public String formatClock(ClockModel clockModel) {
        return clockFormatter.format(clockModel);
    }

    @Override
    public String formatGreeter(GreeterModel greeterModel) {
        return greetingFormatter.format(greeterModel);
    }
}
