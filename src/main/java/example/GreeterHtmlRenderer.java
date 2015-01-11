package example;


import com.google.inject.Inject;

public class GreeterHtmlRenderer {

    private final ModelFormatter modelFormatter;

    private final ClockHtmlRenderer clockHtmlRenderer;

    @Inject
    public GreeterHtmlRenderer(ModelFormatter modelFormatter, ClockHtmlRenderer clockHtmlRenderer) {
        this.modelFormatter = modelFormatter;
        this.clockHtmlRenderer = clockHtmlRenderer;
    }

    public String render(GreeterModel greeterModel) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<div class='greeting' id='").append(greeterModel.getId()).append("'>");
        htmlBuilder.append("<small><b>").append(clockHtmlRenderer.render(greeterModel.getClockModel())).append("</b></small>:&nbsp;");
        htmlBuilder.append("<span>").append(modelFormatter.formatGreeter(greeterModel)).append("</span>");
        htmlBuilder.append("</div>");
        return htmlBuilder.toString();
    }
}
