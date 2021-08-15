package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Camera {
    private long cameraId;
    private Integer numberOfCamera;
    private String mainCameraMp;
    private String secondCameraMp;
    private String thirdCameraMp;
    private String forthCameraMp;
    private String videoResolution;
    private String autofocus;
    private String lighting;
    private String aperture;
    private String hdr;
    private String panorama;
    private String selfieCamera;
    private String selfieVideoResolution;
    private String selfieAutofocus;
    private String selfieHdr;

    @Id
    @Column(name = "cameraID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getCameraId() {
        return cameraId;
    }

    public void setCameraId(long cameraId) {
        this.cameraId = cameraId;
    }

    @Basic
    @Column(name = "number_of_camera", nullable = true)
    public Integer getNumberOfCamera() {
        return numberOfCamera;
    }

    public void setNumberOfCamera(Integer numberOfCamera) {
        this.numberOfCamera = numberOfCamera;
    }

    @Basic
    @Column(name = "main_camera_mp", nullable = true, length = 64)
    public String getMainCameraMp() {
        return mainCameraMp;
    }

    public void setMainCameraMp(String mainCameraMp) {
        this.mainCameraMp = mainCameraMp;
    }

    @Basic
    @Column(name = "second_camera_mp", nullable = true, length = 64)
    public String getSecondCameraMp() {
        return secondCameraMp;
    }

    public void setSecondCameraMp(String secondCameraMp) {
        this.secondCameraMp = secondCameraMp;
    }

    @Basic
    @Column(name = "third_camera_mp", nullable = true, length = 64)
    public String getThirdCameraMp() {
        return thirdCameraMp;
    }

    public void setThirdCameraMp(String thirdCameraMp) {
        this.thirdCameraMp = thirdCameraMp;
    }

    @Basic
    @Column(name = "forth_camera_mp", nullable = true, length = 64)
    public String getForthCameraMp() {
        return forthCameraMp;
    }

    public void setForthCameraMp(String forthCameraMp) {
        this.forthCameraMp = forthCameraMp;
    }

    @Basic
    @Column(name = "video_resolution", nullable = true, length = 64)
    public String getVideoResolution() {
        return videoResolution;
    }

    public void setVideoResolution(String videoResolution) {
        this.videoResolution = videoResolution;
    }

    @Basic
    @Column(name = "autofocus", nullable = true, length = 64)
    public String getAutofocus() {
        return autofocus;
    }

    public void setAutofocus(String autofocus) {
        this.autofocus = autofocus;
    }

    @Basic
    @Column(name = "lighting", nullable = true, length = 64)
    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    @Basic
    @Column(name = "aperture", nullable = true, length = 64)
    public String getAperture() {
        return aperture;
    }

    public void setAperture(String aperture) {
        this.aperture = aperture;
    }

    @Basic
    @Column(name = "hdr", nullable = true, length = 64)
    public String getHdr() {
        return hdr;
    }

    public void setHdr(String hdr) {
        this.hdr = hdr;
    }

    @Basic
    @Column(name = "panorama", nullable = true, length = 64)
    public String getPanorama() {
        return panorama;
    }

    public void setPanorama(String panorama) {
        this.panorama = panorama;
    }

    @Basic
    @Column(name = "selfie_camera", nullable = true, length = 64)
    public String getSelfieCamera() {
        return selfieCamera;
    }

    public void setSelfieCamera(String selfieCamera) {
        this.selfieCamera = selfieCamera;
    }

    @Basic
    @Column(name = "selfie_video_resolution", nullable = true, length = 64)
    public String getSelfieVideoResolution() {
        return selfieVideoResolution;
    }

    public void setSelfieVideoResolution(String selfieVideoResolution) {
        this.selfieVideoResolution = selfieVideoResolution;
    }

    @Basic
    @Column(name = "selfie_autofocus", nullable = true, length = 64)
    public String getSelfieAutofocus() {
        return selfieAutofocus;
    }

    public void setSelfieAutofocus(String selfieAutofocus) {
        this.selfieAutofocus = selfieAutofocus;
    }

    @Basic
    @Column(name = "selfie_hdr", nullable = true, length = 64)
    public String getSelfieHdr() {
        return selfieHdr;
    }

    public void setSelfieHdr(String selfieHdr) {
        this.selfieHdr = selfieHdr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return cameraId == camera.cameraId && Objects.equals(numberOfCamera, camera.numberOfCamera) && Objects.equals(mainCameraMp, camera.mainCameraMp) && Objects.equals(secondCameraMp, camera.secondCameraMp) && Objects.equals(thirdCameraMp, camera.thirdCameraMp) && Objects.equals(forthCameraMp, camera.forthCameraMp) && Objects.equals(videoResolution, camera.videoResolution) && Objects.equals(autofocus, camera.autofocus) && Objects.equals(lighting, camera.lighting) && Objects.equals(aperture, camera.aperture) && Objects.equals(hdr, camera.hdr) && Objects.equals(panorama, camera.panorama) && Objects.equals(selfieCamera, camera.selfieCamera) && Objects.equals(selfieVideoResolution, camera.selfieVideoResolution) && Objects.equals(selfieAutofocus, camera.selfieAutofocus) && Objects.equals(selfieHdr, camera.selfieHdr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cameraId, numberOfCamera, mainCameraMp, secondCameraMp, thirdCameraMp, forthCameraMp, videoResolution, autofocus, lighting, aperture, hdr, panorama, selfieCamera, selfieVideoResolution, selfieAutofocus, selfieHdr);
    }
}
