package example;


public class ClockModel {

    private final String id;

    private final Integer hours, minutes, seconds;

    public ClockModel(String id, Integer hours, Integer minutes, Integer seconds) {
        this.id = id;
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }

    public String getId() {
        return id;
    }

    public Integer getHours() {
        return hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public Integer getSeconds() {
        return seconds;
    }
}
