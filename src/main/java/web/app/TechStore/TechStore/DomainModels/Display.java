package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Display {
    private long displayId;
    private Integer screenSize;
    private String screenResolution;
    private Integer ppi;
    private String screenPanelType;
    private Integer numberOfColors;
    private String screenFormat;
    private String trueTone;
    private String brightness;
    private String screenProtection;
    private String dolbyVision;

    public Display(Integer screenSize, String screenResolution, Integer ppi, String screenPanelType,
                   Integer numberOfColors, String screenFormat, String trueTone, String brightness,
                   String screenProtection, String dolbyVision) {
        this.screenSize = screenSize;
        this.screenResolution = screenResolution;
        this.ppi = ppi;
        this.screenPanelType = screenPanelType;
        this.numberOfColors = numberOfColors;
        this.screenFormat = screenFormat;
        this.trueTone = trueTone;
        this.brightness = brightness;
        this.screenProtection = screenProtection;
        this.dolbyVision = dolbyVision;
    }

    public Display() {

    }

    @Id
    @Column(name = "displayID", nullable = false)
    public long getDisplayId() {
        return displayId;
    }

    public void setDisplayId(long displayId) {
        this.displayId = displayId;
    }

    @Basic
    @Column(name = "screen_size", nullable = true)
    public Integer getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(Integer screenSize) {
        this.screenSize = screenSize;
    }

    @Basic
    @Column(name = "screen_resolution", nullable = true, length = 64)
    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    @Basic
    @Column(name = "ppi", nullable = true)
    public Integer getPpi() {
        return ppi;
    }

    public void setPpi(Integer ppi) {
        this.ppi = ppi;
    }

    @Basic
    @Column(name = "screen_panel_type", nullable = true, length = 64)
    public String getScreenPanelType() {
        return screenPanelType;
    }

    public void setScreenPanelType(String screenPanelType) {
        this.screenPanelType = screenPanelType;
    }

    @Basic
    @Column(name = "number_of_colors", nullable = true)
    public Integer getNumberOfColors() {
        return numberOfColors;
    }

    public void setNumberOfColors(Integer numberOfColors) {
        this.numberOfColors = numberOfColors;
    }

    @Basic
    @Column(name = "screen_format", nullable = true, length = 64)
    public String getScreenFormat() {
        return screenFormat;
    }

    public void setScreenFormat(String screenFormat) {
        this.screenFormat = screenFormat;
    }

    @Basic
    @Column(name = "true_tone", nullable = true, length = 64)
    public String getTrueTone() {
        return trueTone;
    }

    public void setTrueTone(String trueTone) {
        this.trueTone = trueTone;
    }

    @Basic
    @Column(name = "brightness", nullable = true, length = 64)
    public String getBrightness() {
        return brightness;
    }

    public void setBrightness(String brightness) {
        this.brightness = brightness;
    }

    @Basic
    @Column(name = "screen_protection", nullable = true, length = 64)
    public String getScreenProtection() {
        return screenProtection;
    }

    public void setScreenProtection(String screenProtection) {
        this.screenProtection = screenProtection;
    }

    @Basic
    @Column(name = "dolby_vision", nullable = true, length = 64)
    public String getDolbyVision() {
        return dolbyVision;
    }

    public void setDolbyVision(String dolbyVision) {
        this.dolbyVision = dolbyVision;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Display display = (Display) o;
        return displayId == display.displayId && Objects.equals(screenSize, display.screenSize) && Objects.equals(screenResolution, display.screenResolution) && Objects.equals(ppi, display.ppi) && Objects.equals(screenPanelType, display.screenPanelType) && Objects.equals(numberOfColors, display.numberOfColors) && Objects.equals(screenFormat, display.screenFormat) && Objects.equals(trueTone, display.trueTone) && Objects.equals(brightness, display.brightness) && Objects.equals(screenProtection, display.screenProtection) && Objects.equals(dolbyVision, display.dolbyVision);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayId, screenSize, screenResolution, ppi, screenPanelType, numberOfColors, screenFormat, trueTone, brightness, screenProtection, dolbyVision);
    }
}
