package example;


import com.google.inject.Inject;

public class ClockHtmlRenderer {

    private final ModelFormatter modelFormatter;
    
    @Inject
    public ClockHtmlRenderer(ModelFormatter modelFormatter) {
        this.modelFormatter = modelFormatter;
    }


    public String render(ClockModel clockModel) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<span class='clock' id='").append(clockModel.getId()).append("'>");
        htmlBuilder.append(modelFormatter.formatClock(clockModel));
        htmlBuilder.append("</span>");
        return htmlBuilder.toString();
    }

}
