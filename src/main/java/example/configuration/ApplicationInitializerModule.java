package example.configuration;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import example.ClockApplication;

public class ApplicationInitializerModule extends AbstractModule {

    @Override
    protected void configure() {
        
    }

    @Provides
    @Singleton
    @Named("Initialized")
    public ClockApplication initializeApplication(ClockApplication application) {
        application.initialize();
        return application;
    }
}
