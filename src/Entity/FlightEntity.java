package Entity;

import java.time.Duration;
import java.util.Date;

public class FlightEntity {
    private String flight_date;
    private String cosmodrome_name;
    private String rocket_name;
    private int duration;
    private boolean success;

    public FlightEntity(String flight_date, String cosmodrome_name, String rocket_name, int duration, boolean success) {
        this.flight_date = flight_date;
        this.cosmodrome_name = cosmodrome_name;
        this.rocket_name = rocket_name;
        this.duration = duration;
        this.success = success;
    }
    public  FlightEntity() {
    }


    public String getDate() {
        return flight_date;
    }
    public void setDate(String flight_date) {
        this.flight_date   = flight_date;
    }
    public String getCName() {
        return cosmodrome_name;
    }
    public void setCName(String cosmodrome_name) {
        this.cosmodrome_name = cosmodrome_name;
    }
    public String getRName() {
        return rocket_name;
    }
    public void setRName(String rocket_name) {
        this.rocket_name = rocket_name;
    }
    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public boolean getSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Entity.FlightEntity{" +
                "flight_date=" + flight_date +
                ", cosmodrome_name='" + cosmodrome_name + '\'' +
                ", rocket_name=" + rocket_name +
                ", duration=" + duration +
                ", success=" + success +
                '}';
    }
}
