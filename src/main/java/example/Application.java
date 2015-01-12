package example;

import com.google.common.base.Preconditions;
import com.google.inject.Inject;
import com.google.inject.ProvidedBy;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.get;


@ProvidedBy(ApplicationProvider.class)
public class Application {

    private final ApplicationFactory applicationFactory;

    private final GreeterHtmlRenderer greeterHtmlRenderer;

    @Inject
    public Application(ApplicationFactory applicationFactory, GreeterHtmlRenderer greeterHtmlRenderer) {
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
                return getHtml(request.params("name"));
            }
        });
        
        get("/json/:name", "application/json", new Route() {
            @Override
            public Object handle(Request request, Response response) throws Exception {
                response.type("application/json");
                return getModel(request.params("name"));
            }

        }, new JsonTransformer());
    }

    private GreeterModel getModel(String name) {
        return applicationFactory.createGreeter(name).get();
    }

    private String getHtml(String name) {
        return greeterHtmlRenderer.render(getModel(name));
    }

}
