package example.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;
import example.ClockConverter;
import example.ClockModel;

import java.time.Instant;
import java.util.Date;


public class DateModule extends AbstractModule {
    @Override
    protected void configure() {
    }

    @Provides
    @Named("Now")
    public Date getNow() {
        return Date.from(Instant.now());
    }

    @Provides
    @Named("Now")
    public ClockModel getNowModel(ClockConverter clockConverter, @Named("Now") Date nowDate) {
        return clockConverter.create(nowDate);
    }

}
