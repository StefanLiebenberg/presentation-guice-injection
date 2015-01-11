package example;

import com.google.inject.Singleton;

@Singleton
public class GreetingFormatter {
    public String format(GreeterModel greeterModel) {
        return "Hi, " + greeterModel.getName();
    }
}
