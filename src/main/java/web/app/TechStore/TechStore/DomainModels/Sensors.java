package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Sensors {
    private long sensorsId;
    private String fingerprint;
    private String acceleremeter;
    private String compass;
    private String gyroscope;
    private String proximity;

    @Id
    @Column(name = "sensorsID", nullable = false)
    public long getSensorsId() {
        return sensorsId;
    }

    public void setSensorsId(long sensorsId) {
        this.sensorsId = sensorsId;
    }

    @Basic
    @Column(name = "fingerprint", nullable = true, length = 64)
    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }

    @Basic
    @Column(name = "acceleremeter", nullable = true, length = 64)
    public String getAcceleremeter() {
        return acceleremeter;
    }

    public void setAcceleremeter(String acceleremeter) {
        this.acceleremeter = acceleremeter;
    }

    @Basic
    @Column(name = "compass", nullable = true, length = 64)
    public String getCompass() {
        return compass;
    }

    public void setCompass(String compass) {
        this.compass = compass;
    }

    @Basic
    @Column(name = "gyroscope", nullable = true, length = 64)
    public String getGyroscope() {
        return gyroscope;
    }

    public void setGyroscope(String gyroscope) {
        this.gyroscope = gyroscope;
    }

    @Basic
    @Column(name = "proximity", nullable = true, length = 64)
    public String getProximity() {
        return proximity;
    }

    public void setProximity(String proximity) {
        this.proximity = proximity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sensors sensors = (Sensors) o;
        return sensorsId == sensors.sensorsId && Objects.equals(fingerprint, sensors.fingerprint) && Objects.equals(acceleremeter, sensors.acceleremeter) && Objects.equals(compass, sensors.compass) && Objects.equals(gyroscope, sensors.gyroscope) && Objects.equals(proximity, sensors.proximity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorsId, fingerprint, acceleremeter, compass, gyroscope, proximity);
    }
}
