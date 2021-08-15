package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Products {
    private long productId;
    private String name;
    private String modelName;
    private String brand;
    private String series;
    private String build;
    private GeneralInfo generalInfoByGeneralId;
    private Display displayByDisplayId;
    private Camera cameraByCameraId;
    private Processor processorByProcessorId;
    private Memory memoryByMemoryId;
    private Sensors sensorsBySensorsId;
    private Gps gpsByGpsId;
    private AdditionalSpecs additionalSpecsBySpecsId;

    public Products(String name, String modelName, String brand, String series, String build,
                    GeneralInfo generalInfoByGeneralId, Display displayByDisplayId, Camera cameraByCameraId,
                    Processor processorByProcessorId, Memory memoryByMemoryId, Sensors sensorsBySensorsId,
                    Gps gpsByGpsId, AdditionalSpecs additionalSpecsBySpecsId) {
        this.name = name;
        this.modelName = modelName;
        this.brand = brand;
        this.series = series;
        this.build = build;
        this.generalInfoByGeneralId = generalInfoByGeneralId;
        this.displayByDisplayId = displayByDisplayId;
        this.cameraByCameraId = cameraByCameraId;
        this.processorByProcessorId = processorByProcessorId;
        this.memoryByMemoryId = memoryByMemoryId;
        this.sensorsBySensorsId = sensorsBySensorsId;
        this.gpsByGpsId = gpsByGpsId;
        this.additionalSpecsBySpecsId = additionalSpecsBySpecsId;
    }

    public Products() {

    }


    @Id
    @Column(name = "productID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 64)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "model_name", nullable = true, length = 64)
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Basic
    @Column(name = "brand", nullable = true, length = 64)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "series", nullable = true, length = 64)
    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    @Basic
    @Column(name = "build", nullable = true, length = 64)
    public String getBuild() {
        return build;
    }

    public void setBuild(String build) {
        this.build = build;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return productId == products.productId && Objects.equals(name, products.name) && Objects.equals(modelName, products.modelName) && Objects.equals(brand, products.brand) && Objects.equals(series, products.series) && Objects.equals(build, products.build);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, modelName, brand, series, build);
    }

    @ManyToOne
    @JoinColumn(name = "generalID", referencedColumnName = "generalID")
    public GeneralInfo getGeneralInfoByGeneralId() {
        return generalInfoByGeneralId;
    }

    public void setGeneralInfoByGeneralId(GeneralInfo generalInfoByGeneralId) {
        this.generalInfoByGeneralId = generalInfoByGeneralId;
    }

    @ManyToOne
    @JoinColumn(name = "displayID", referencedColumnName = "displayID")
    public Display getDisplayByDisplayId() {
        return displayByDisplayId;
    }

    public void setDisplayByDisplayId(Display displayByDisplayId) {
        this.displayByDisplayId = displayByDisplayId;
    }

    @ManyToOne
    @JoinColumn(name = "cameraID", referencedColumnName = "cameraID")
    public Camera getCameraByCameraId() {
        return cameraByCameraId;
    }

    public void setCameraByCameraId(Camera cameraByCameraId) {
        this.cameraByCameraId = cameraByCameraId;
    }

    @ManyToOne
    @JoinColumn(name = "processorID", referencedColumnName = "processorID")
    public Processor getProcessorByProcessorId() {
        return processorByProcessorId;
    }

    public void setProcessorByProcessorId(Processor processorByProcessorId) {
        this.processorByProcessorId = processorByProcessorId;
    }

    @ManyToOne
    @JoinColumn(name = "memoryID", referencedColumnName = "memoryID")
    public Memory getMemoryByMemoryId() {
        return memoryByMemoryId;
    }

    public void setMemoryByMemoryId(Memory memoryByMemoryId) {
        this.memoryByMemoryId = memoryByMemoryId;
    }

    @ManyToOne
    @JoinColumn(name = "sensorsID", referencedColumnName = "sensorsID")
    public Sensors getSensorsBySensorsId() {
        return sensorsBySensorsId;
    }

    public void setSensorsBySensorsId(Sensors sensorsBySensorsId) {
        this.sensorsBySensorsId = sensorsBySensorsId;
    }

    @ManyToOne
    @JoinColumn(name = "gpsID", referencedColumnName = "gpsID")
    public Gps getGpsByGpsId() {
        return gpsByGpsId;
    }

    public void setGpsByGpsId(Gps gpsByGpsId) {
        this.gpsByGpsId = gpsByGpsId;
    }

    @ManyToOne
    @JoinColumn(name = "specsID", referencedColumnName = "specsID")
    public AdditionalSpecs getAdditionalSpecsBySpecsId() {
        return additionalSpecsBySpecsId;
    }

    public void setAdditionalSpecsBySpecsId(AdditionalSpecs additionalSpecsBySpecsId) {
        this.additionalSpecsBySpecsId = additionalSpecsBySpecsId;
    }

}
