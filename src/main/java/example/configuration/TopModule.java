package example.configuration;

import com.google.inject.AbstractModule;
import example.Application;


public class TopModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FormatModule(false));
        install(new DateModule());
        install(new FactoryModule());
        install(new InterfaceModule());
        install(new PluginsModule());
        bind(Application.class).asEagerSingleton();
    }
}
