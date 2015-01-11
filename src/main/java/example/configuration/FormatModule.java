package example.configuration;


import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class FormatModule extends AbstractModule {

    private final Boolean formatAs24Hour;

    public FormatModule(Boolean formatAs24Hour) {
        this.formatAs24Hour = formatAs24Hour;
    }

    @Override
    protected void configure() {
        bind(Boolean.class).annotatedWith(Names.named("Format24Hour")).toInstance(formatAs24Hour);
    }

}
