package example;


import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import java.util.Date;

@Singleton
@SuppressWarnings("deprecation")
public class ClockConverter {

    private final Provider<ClockBuilder> clockBuilderProvider;

    @Inject
    public ClockConverter(Provider<ClockBuilder> clockBuilderProvider) {
        this.clockBuilderProvider = clockBuilderProvider;
    }

    public ClockModel create(Date date) {
        ClockBuilder builder = clockBuilderProvider.get();
        builder.setHours(date.getHours());
        builder.setMinutes(date.getMinutes());
        builder.setSeconds(date.getSeconds());
        return builder.build();
    }

}
