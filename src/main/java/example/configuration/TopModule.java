package example.configuration;

import com.google.inject.AbstractModule;


public class TopModule extends AbstractModule {
    @Override
    protected void configure() {
        install(new ApplicationInitializerModule());
        install(new FormatModule(true));
        install(new DateModule());
        install(new FactoryModule());
        install(new InterfaceModule());
    }
}
