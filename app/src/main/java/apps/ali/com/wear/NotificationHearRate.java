package apps.ali.com.wear;

/**
 * Created by Zohaib on 4/18/2018.
 */

public class NotificationHearRate {

    private String heartRate;

    public NotificationHearRate()
    {

    }
    public NotificationHearRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }
}
