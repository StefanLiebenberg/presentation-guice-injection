package example;

import com.google.inject.Inject;
import com.google.inject.Provider;


public class ApplicationProvider implements Provider<Application> {

    private final ApplicationFactory applicationFactory;

    private final GreeterHtmlRenderer greeterHtmlRenderer;

    @Inject
    public ApplicationProvider(ApplicationFactory applicationFactory, GreeterHtmlRenderer greeterHtmlRenderer) {
        this.applicationFactory = applicationFactory;
        this.greeterHtmlRenderer = greeterHtmlRenderer;
    }

    @Override
    public Application get() {
        Application application = new Application(applicationFactory, greeterHtmlRenderer);
        application.initialize();
        return application;
    }
}
