package example;


import com.google.inject.Inject;

public class ClockBuilder {

    private final IdGenerator idGenerator;

    @Inject
    public ClockBuilder(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    private Integer hour = 0, minute = 0, seconds = 0;

    public ClockModel build() {
        return new ClockModel(idGenerator.getNextId(), hour, minute, seconds);
    }

    public ClockBuilder setSeconds(Integer seconds) {
        this.seconds = seconds;
        return this;
    }

    public ClockBuilder setMinutes(Integer minute) {
        this.minute = minute;
        return this;
    }

    public ClockBuilder setHours(Integer hour) {
        this.hour = hour;
        return this;
    }


}
