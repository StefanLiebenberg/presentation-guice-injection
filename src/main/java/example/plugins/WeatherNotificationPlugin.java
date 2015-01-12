package example.plugins;

/**
 * Created by stefan on 1/11/15.
 */
public class WeatherNotificationPlugin implements Plugin {
    @Override
    public String getHtmlContent() {
        return "<em>-2</em> degrees C outside. <em>40</em> inside.";
    }
}
