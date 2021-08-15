package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "general_info", schema = "techstore", catalog = "")
public class GeneralInfo {
    private long generalId;
    private String twoG;
    private String threeG;
    private String lte;
    private String lteA;
    private String fiveG;
    private String dualSim;
    private String dualStandby;
    private String simType;

    public GeneralInfo(String twoG, String threeG, String lte, String lteA, String fiveG, String dualSim,
                       String dualStandby, String simType) {
        this.twoG = twoG;
        this.threeG = threeG;
        this.lte = lte;
        this.lteA = lteA;
        this.fiveG = fiveG;
        this.dualSim = dualSim;
        this.dualStandby = dualStandby;
        this.simType = simType;
    }

    public GeneralInfo() {

    }

    @Id
    @Column(name = "generalID", nullable = false)
    public long getGeneralId() {
        return generalId;
    }

    public void setGeneralId(long generalId) {
        this.generalId = generalId;
    }

    @Basic
    @Column(name = "two_g", nullable = true, length = 64)
    public String getTwoG() {
        return twoG;
    }

    public void setTwoG(String twoG) {
        this.twoG = twoG;
    }

    @Basic
    @Column(name = "three_g", nullable = true, length = 64)
    public String getThreeG() {
        return threeG;
    }

    public void setThreeG(String threeG) {
        this.threeG = threeG;
    }

    @Basic
    @Column(name = "lte", nullable = true, length = 64)
    public String getLte() {
        return lte;
    }

    public void setLte(String lte) {
        this.lte = lte;
    }

    @Basic
    @Column(name = "lte_a", nullable = true, length = 64)
    public String getLteA() {
        return lteA;
    }

    public void setLteA(String lteA) {
        this.lteA = lteA;
    }

    @Basic
    @Column(name = "five_g", nullable = true, length = 64)
    public String getFiveG() {
        return fiveG;
    }

    public void setFiveG(String fiveG) {
        this.fiveG = fiveG;
    }

    @Basic
    @Column(name = "dual_sim", nullable = true, length = 64)
    public String getDualSim() {
        return dualSim;
    }

    public void setDualSim(String dualSim) {
        this.dualSim = dualSim;
    }

    @Basic
    @Column(name = "dual_standby", nullable = true, length = 64)
    public String getDualStandby() {
        return dualStandby;
    }

    public void setDualStandby(String dualStandby) {
        this.dualStandby = dualStandby;
    }

    @Basic
    @Column(name = "sim_type", nullable = true, length = 64)
    public String getSimType() {
        return simType;
    }

    public void setSimType(String simType) {
        this.simType = simType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GeneralInfo that = (GeneralInfo) o;
        return generalId == that.generalId && Objects.equals(twoG, that.twoG) && Objects.equals(threeG, that.threeG) && Objects.equals(lte, that.lte) && Objects.equals(lteA, that.lteA) && Objects.equals(fiveG, that.fiveG) && Objects.equals(dualSim, that.dualSim) && Objects.equals(dualStandby, that.dualStandby) && Objects.equals(simType, that.simType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(generalId, twoG, threeG, lte, lteA, fiveG, dualSim, dualStandby, simType);
    }
}
