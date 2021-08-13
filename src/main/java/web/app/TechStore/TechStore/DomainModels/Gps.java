package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Gps {
    private long gpsId;
    private String aGps;
    private String galileo;
    private String bds;
    private String glonass;

    @Id
    @Column(name = "gpsID", nullable = false)
    public long getGpsId() {
        return gpsId;
    }

    public void setGpsId(long gpsId) {
        this.gpsId = gpsId;
    }

    @Basic
    @Column(name = "a_gps", nullable = true, length = 64)
    public String getaGps() {
        return aGps;
    }

    public void setaGps(String aGps) {
        this.aGps = aGps;
    }

    @Basic
    @Column(name = "galileo", nullable = true, length = 64)
    public String getGalileo() {
        return galileo;
    }

    public void setGalileo(String galileo) {
        this.galileo = galileo;
    }

    @Basic
    @Column(name = "bds", nullable = true, length = 64)
    public String getBds() {
        return bds;
    }

    public void setBds(String bds) {
        this.bds = bds;
    }

    @Basic
    @Column(name = "glonass", nullable = true, length = 64)
    public String getGlonass() {
        return glonass;
    }

    public void setGlonass(String glonass) {
        this.glonass = glonass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gps gps = (Gps) o;
        return gpsId == gps.gpsId && Objects.equals(aGps, gps.aGps) && Objects.equals(galileo, gps.galileo) && Objects.equals(bds, gps.bds) && Objects.equals(glonass, gps.glonass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gpsId, aGps, galileo, bds, glonass);
    }
}
