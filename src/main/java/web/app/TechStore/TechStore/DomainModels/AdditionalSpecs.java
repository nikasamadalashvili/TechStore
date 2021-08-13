package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "additional_specs", schema = "techstore", catalog = "")
public class AdditionalSpecs {
    private long specsId;
    private String fmRatioSupport;
    private String numberOfSpeakers;
    private String loudspeaker;
    private String microphone;
    private String usbTypeC;
    private String lightningCorrect;
    private String audioJack;
    private String bluetooth;
    private String nfc;
    private String wifiDirect;
    private String ant;
    private String fastCharging;
    private String wirelessCharging;
    private String batteryDescription;
    private String musicPlaybackTime;
    private String typeOfBattery;
    private String waterResistant;
    private String waterResistantDepth;
    private String operatingSystem;
    private String operatingSystemVersion;
    private String upgradable;
    private String color;
    private String dimensions;
    private String weight;
    private String adapter;
    private String cableIncluded;
    private String headphones;
    private String warranty;

    @Id
    @Column(name = "specsID", nullable = false)
    public long getSpecsId() {
        return specsId;
    }

    public void setSpecsId(long specsId) {
        this.specsId = specsId;
    }

    @Basic
    @Column(name = "fm_ratio_support", nullable = true, length = 64)
    public String getFmRatioSupport() {
        return fmRatioSupport;
    }

    public void setFmRatioSupport(String fmRatioSupport) {
        this.fmRatioSupport = fmRatioSupport;
    }

    @Basic
    @Column(name = "number_of_speakers", nullable = true, length = 64)
    public String getNumberOfSpeakers() {
        return numberOfSpeakers;
    }

    public void setNumberOfSpeakers(String numberOfSpeakers) {
        this.numberOfSpeakers = numberOfSpeakers;
    }

    @Basic
    @Column(name = "loudspeaker", nullable = true, length = 64)
    public String getLoudspeaker() {
        return loudspeaker;
    }

    public void setLoudspeaker(String loudspeaker) {
        this.loudspeaker = loudspeaker;
    }

    @Basic
    @Column(name = "microphone", nullable = true, length = 64)
    public String getMicrophone() {
        return microphone;
    }

    public void setMicrophone(String microphone) {
        this.microphone = microphone;
    }

    @Basic
    @Column(name = "usb_type_c", nullable = true, length = 64)
    public String getUsbTypeC() {
        return usbTypeC;
    }

    public void setUsbTypeC(String usbTypeC) {
        this.usbTypeC = usbTypeC;
    }

    @Basic
    @Column(name = "lightning_correct", nullable = true, length = 64)
    public String getLightningCorrect() {
        return lightningCorrect;
    }

    public void setLightningCorrect(String lightningCorrect) {
        this.lightningCorrect = lightningCorrect;
    }

    @Basic
    @Column(name = "audio_jack", nullable = true, length = 64)
    public String getAudioJack() {
        return audioJack;
    }

    public void setAudioJack(String audioJack) {
        this.audioJack = audioJack;
    }

    @Basic
    @Column(name = "bluetooth", nullable = true, length = 64)
    public String getBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(String bluetooth) {
        this.bluetooth = bluetooth;
    }

    @Basic
    @Column(name = "nfc", nullable = true, length = 64)
    public String getNfc() {
        return nfc;
    }

    public void setNfc(String nfc) {
        this.nfc = nfc;
    }

    @Basic
    @Column(name = "wifi_direct", nullable = true, length = 64)
    public String getWifiDirect() {
        return wifiDirect;
    }

    public void setWifiDirect(String wifiDirect) {
        this.wifiDirect = wifiDirect;
    }

    @Basic
    @Column(name = "ant", nullable = true, length = 64)
    public String getAnt() {
        return ant;
    }

    public void setAnt(String ant) {
        this.ant = ant;
    }

    @Basic
    @Column(name = "fast_charging", nullable = true, length = 64)
    public String getFastCharging() {
        return fastCharging;
    }

    public void setFastCharging(String fastCharging) {
        this.fastCharging = fastCharging;
    }

    @Basic
    @Column(name = "wireless_charging", nullable = true, length = 64)
    public String getWirelessCharging() {
        return wirelessCharging;
    }

    public void setWirelessCharging(String wirelessCharging) {
        this.wirelessCharging = wirelessCharging;
    }

    @Basic
    @Column(name = "battery_description", nullable = true, length = 64)
    public String getBatteryDescription() {
        return batteryDescription;
    }

    public void setBatteryDescription(String batteryDescription) {
        this.batteryDescription = batteryDescription;
    }

    @Basic
    @Column(name = "music_playback_time", nullable = true, length = 64)
    public String getMusicPlaybackTime() {
        return musicPlaybackTime;
    }

    public void setMusicPlaybackTime(String musicPlaybackTime) {
        this.musicPlaybackTime = musicPlaybackTime;
    }

    @Basic
    @Column(name = "type_of_battery", nullable = true, length = 64)
    public String getTypeOfBattery() {
        return typeOfBattery;
    }

    public void setTypeOfBattery(String typeOfBattery) {
        this.typeOfBattery = typeOfBattery;
    }

    @Basic
    @Column(name = "water_resistant", nullable = true, length = 64)
    public String getWaterResistant() {
        return waterResistant;
    }

    public void setWaterResistant(String waterResistant) {
        this.waterResistant = waterResistant;
    }

    @Basic
    @Column(name = "water_resistant_depth", nullable = true, length = 64)
    public String getWaterResistantDepth() {
        return waterResistantDepth;
    }

    public void setWaterResistantDepth(String waterResistantDepth) {
        this.waterResistantDepth = waterResistantDepth;
    }

    @Basic
    @Column(name = "operating_system", nullable = true, length = 64)
    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    @Basic
    @Column(name = "operating_system_version", nullable = true, length = 64)
    public String getOperatingSystemVersion() {
        return operatingSystemVersion;
    }

    public void setOperatingSystemVersion(String operatingSystemVersion) {
        this.operatingSystemVersion = operatingSystemVersion;
    }

    @Basic
    @Column(name = "upgradable", nullable = true, length = 64)
    public String getUpgradable() {
        return upgradable;
    }

    public void setUpgradable(String upgradable) {
        this.upgradable = upgradable;
    }

    @Basic
    @Column(name = "color", nullable = true, length = 64)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Basic
    @Column(name = "dimensions", nullable = true, length = 64)
    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    @Basic
    @Column(name = "weight", nullable = true, length = 64)
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    @Basic
    @Column(name = "adapter", nullable = true, length = 64)
    public String getAdapter() {
        return adapter;
    }

    public void setAdapter(String adapter) {
        this.adapter = adapter;
    }

    @Basic
    @Column(name = "cable_included", nullable = true, length = 64)
    public String getCableIncluded() {
        return cableIncluded;
    }

    public void setCableIncluded(String cableIncluded) {
        this.cableIncluded = cableIncluded;
    }

    @Basic
    @Column(name = "headphones", nullable = true, length = 64)
    public String getHeadphones() {
        return headphones;
    }

    public void setHeadphones(String headphones) {
        this.headphones = headphones;
    }

    @Basic
    @Column(name = "warranty", nullable = true, length = 64)
    public String getWarranty() {
        return warranty;
    }

    public void setWarranty(String warranty) {
        this.warranty = warranty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdditionalSpecs that = (AdditionalSpecs) o;
        return specsId == that.specsId && Objects.equals(fmRatioSupport, that.fmRatioSupport) && Objects.equals(numberOfSpeakers, that.numberOfSpeakers) && Objects.equals(loudspeaker, that.loudspeaker) && Objects.equals(microphone, that.microphone) && Objects.equals(usbTypeC, that.usbTypeC) && Objects.equals(lightningCorrect, that.lightningCorrect) && Objects.equals(audioJack, that.audioJack) && Objects.equals(bluetooth, that.bluetooth) && Objects.equals(nfc, that.nfc) && Objects.equals(wifiDirect, that.wifiDirect) && Objects.equals(ant, that.ant) && Objects.equals(fastCharging, that.fastCharging) && Objects.equals(wirelessCharging, that.wirelessCharging) && Objects.equals(batteryDescription, that.batteryDescription) && Objects.equals(musicPlaybackTime, that.musicPlaybackTime) && Objects.equals(typeOfBattery, that.typeOfBattery) && Objects.equals(waterResistant, that.waterResistant) && Objects.equals(waterResistantDepth, that.waterResistantDepth) && Objects.equals(operatingSystem, that.operatingSystem) && Objects.equals(operatingSystemVersion, that.operatingSystemVersion) && Objects.equals(upgradable, that.upgradable) && Objects.equals(color, that.color) && Objects.equals(dimensions, that.dimensions) && Objects.equals(weight, that.weight) && Objects.equals(adapter, that.adapter) && Objects.equals(cableIncluded, that.cableIncluded) && Objects.equals(headphones, that.headphones) && Objects.equals(warranty, that.warranty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(specsId, fmRatioSupport, numberOfSpeakers, loudspeaker, microphone, usbTypeC, lightningCorrect, audioJack, bluetooth, nfc, wifiDirect, ant, fastCharging, wirelessCharging, batteryDescription, musicPlaybackTime, typeOfBattery, waterResistant, waterResistantDepth, operatingSystem, operatingSystemVersion, upgradable, color, dimensions, weight, adapter, cableIncluded, headphones, warranty);
    }
}
