package example.configuration;

import com.google.inject.AbstractModule;
import example.Application;


public class TopModule extends AbstractModule {


    @Override
    protected void configure() {
        install(new FormatModule(true));
        install(new DateModule());
        install(new FactoryModule());
        install(new InterfaceModule());

        bind(Application.class).asEagerSingleton();
    }
}
