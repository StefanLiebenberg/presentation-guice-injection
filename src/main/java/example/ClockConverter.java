package example;


import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

import java.util.Date;

@Singleton
public class ClockConverter {

    private final Provider<ClockBuilder> clockBuilderProvider;

    @Inject
    public ClockConverter(Provider<ClockBuilder> clockBuilderProvider) {
        this.clockBuilderProvider = clockBuilderProvider;
    }

    public ClockModel create(Date date) {
        return clockBuilderProvider.get().setHours(date.getHours()).setMinutes(date.getMinutes()).setSeconds(date.getSeconds()).build();
    }

}
