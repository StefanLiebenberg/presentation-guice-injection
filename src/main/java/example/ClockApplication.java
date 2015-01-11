package example;

import com.google.common.base.Preconditions;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Key;
import com.google.inject.name.Names;
import example.configuration.TopModule;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;


public class ClockApplication {

    private final ApplicationFactory applicationFactory;

    private final GreeterHtmlRenderer greeterHtmlRenderer;

    @Inject
    public ClockApplication(ApplicationFactory applicationFactory, GreeterHtmlRenderer greeterHtmlRenderer) {
        this.applicationFactory = applicationFactory;
        this.greeterHtmlRenderer = greeterHtmlRenderer;
    }

    private boolean initialized = false;

    public void initialize() {
        Preconditions.checkState(!initialized);
        initialized = true;

        get("/html/:name", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                return greeterHtmlRenderer.render(applicationFactory.createGreeter(request.params("name")).get());
            }
        });

        get("/json/:name", "application/json", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                response.type("application/json");
                return applicationFactory.createGreeter(request.params("name")).get();
            }
        }, new JsonTransformer());
    }


    public static void main(String[] args) {
//        Guice.createInjector(new TopModule()).getInstance(ClockApplication.class).initialize();


        Guice.createInjector(new TopModule()).getInstance(Key.get(ClockApplication.class, Names.named("Initialized")));
    }
}
