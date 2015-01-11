package example;

public interface ApplicationFactory {
    
    public GreeterProvider createGreeter(String name);
}
