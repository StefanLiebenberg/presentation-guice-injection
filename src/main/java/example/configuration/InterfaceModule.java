package example.configuration;


import com.google.inject.AbstractModule;
import example.ModelFormatter;
import example.ModelFormatterImpl;

public class InterfaceModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(ModelFormatter.class).to(ModelFormatterImpl.class);
    }
}




