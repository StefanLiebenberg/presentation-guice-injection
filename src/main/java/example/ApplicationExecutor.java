package example;


import com.google.inject.Guice;
import example.configuration.TopModule;

public class ApplicationExecutor {
    public static void main(String[] arguments) {
        Guice.createInjector(new TopModule());
    }
}
