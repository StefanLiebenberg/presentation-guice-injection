package example;


import com.google.inject.Inject;

public class GreeterBuilder {

    private final IdGenerator idGenerator;

    @Inject
    public GreeterBuilder(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    private String name;

    private ClockModel clockModel;

    public GreeterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public GreeterBuilder setClockModel(ClockModel clockModel) {
        this.clockModel = clockModel;
        return this;
    }

    public GreeterModel build() {
        return new GreeterModel(idGenerator.getNextId(), name, clockModel);
    }
}
