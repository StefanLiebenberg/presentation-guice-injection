package example.configuration;


import com.google.inject.AbstractModule;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import example.ApplicationFactory;

public class FactoryModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().build(ApplicationFactory.class));
    }

}
