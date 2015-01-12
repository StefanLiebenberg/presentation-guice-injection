package example.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import example.plugins.EmailNotificationsPlugin;
import example.plugins.Plugin;
import example.plugins.TodoListPlugin;
import example.plugins.WeatherNotificationPlugin;


public class PluginsModule extends AbstractModule {
    @Override
    protected void configure() {
        Multibinder<Plugin> setBinder = Multibinder.newSetBinder(binder(), Plugin.class);
        setBinder.addBinding().to(EmailNotificationsPlugin.class);
        setBinder.addBinding().to(WeatherNotificationPlugin.class);
        setBinder.addBinding().to(TodoListPlugin.class);

    }
}
