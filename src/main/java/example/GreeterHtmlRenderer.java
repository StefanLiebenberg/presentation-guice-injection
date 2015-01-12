package example;


import com.google.inject.Inject;
import example.plugins.Plugin;

import javax.annotation.Nullable;
import java.util.Set;

public class GreeterHtmlRenderer {

    private final ModelFormatter modelFormatter;

    private final ClockHtmlRenderer clockHtmlRenderer;

    private final Set<Plugin> pluginList;

    @Inject
    public GreeterHtmlRenderer(ModelFormatter modelFormatter, ClockHtmlRenderer clockHtmlRenderer, @Nullable Set<Plugin> pluginList) {
        this.modelFormatter = modelFormatter;
        this.clockHtmlRenderer = clockHtmlRenderer;
        this.pluginList = pluginList;
    }

    public String render(GreeterModel greeterModel) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<div class='greeting' id='").append(greeterModel.getId()).append("'>");
        htmlBuilder.append("<small><b>[").append(clockHtmlRenderer.render(greeterModel.getClockModel())).append("]</b></small>:&nbsp;");
        htmlBuilder.append("<span>").append(modelFormatter.formatGreeter(greeterModel)).append("</span>");

        if (!pluginList.isEmpty()) {
            htmlBuilder.append("<ul>");
            for (Plugin plugin : pluginList) {
                htmlBuilder.append("<li>").append(plugin.getHtmlContent()).append("</li>");
            }
            htmlBuilder.append("</ul>");
        }
        htmlBuilder.append("</div>");
        return htmlBuilder.toString();
    }
}
