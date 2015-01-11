package example;


import com.google.inject.ProvidedBy;

@ProvidedBy(GreeterProvider.class)
public class GreeterModel {
    private final String id, name;
    private final ClockModel clockModel;

    public GreeterModel(String id, String name, ClockModel clockModel) {
        this.id = id;
        this.name = name;
        this.clockModel = clockModel;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ClockModel getClockModel() {
        return clockModel;
    }
}
