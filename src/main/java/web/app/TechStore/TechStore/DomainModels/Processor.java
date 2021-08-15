package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Processor {
    private long processorId;
    private String manufacturer;
    private String typeOfProcessor;
    private String modelOfProcessor;
    private Integer numberOfCores;
    private String graphicProcessor;
    private String lithography;

    public Processor(String manufacturer, String typeOfProcessor, String modelOfProcessor, Integer numberOfCores,
                     String graphicProcessor, String lithography) {
        this.manufacturer = manufacturer;
        this.typeOfProcessor = typeOfProcessor;
        this.modelOfProcessor = modelOfProcessor;
        this.numberOfCores = numberOfCores;
        this.graphicProcessor = graphicProcessor;
        this.lithography = lithography;
    }

    public Processor() {

    }

    @Id
    @Column(name = "processorID", nullable = false)
    public long getProcessorId() {
        return processorId;
    }

    public void setProcessorId(long processorId) {
        this.processorId = processorId;
    }

    @Basic
    @Column(name = "manufacturer", nullable = true, length = 64)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "type_of_processor", nullable = true, length = 64)
    public String getTypeOfProcessor() {
        return typeOfProcessor;
    }

    public void setTypeOfProcessor(String typeOfProcessor) {
        this.typeOfProcessor = typeOfProcessor;
    }

    @Basic
    @Column(name = "model_of_processor", nullable = true, length = 64)
    public String getModelOfProcessor() {
        return modelOfProcessor;
    }

    public void setModelOfProcessor(String modelOfProcessor) {
        this.modelOfProcessor = modelOfProcessor;
    }

    @Basic
    @Column(name = "number_of_cores", nullable = true)
    public Integer getNumberOfCores() {
        return numberOfCores;
    }

    public void setNumberOfCores(Integer numberOfCores) {
        this.numberOfCores = numberOfCores;
    }

    @Basic
    @Column(name = "graphic_processor", nullable = true, length = 64)
    public String getGraphicProcessor() {
        return graphicProcessor;
    }

    public void setGraphicProcessor(String graphicProcessor) {
        this.graphicProcessor = graphicProcessor;
    }

    @Basic
    @Column(name = "lithography", nullable = true, length = 64)
    public String getLithography() {
        return lithography;
    }

    public void setLithography(String lithography) {
        this.lithography = lithography;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Processor processor = (Processor) o;
        return processorId == processor.processorId && Objects.equals(manufacturer, processor.manufacturer) && Objects.equals(typeOfProcessor, processor.typeOfProcessor) && Objects.equals(modelOfProcessor, processor.modelOfProcessor) && Objects.equals(numberOfCores, processor.numberOfCores) && Objects.equals(graphicProcessor, processor.graphicProcessor) && Objects.equals(lithography, processor.lithography);
    }

    @Override
    public int hashCode() {
        return Objects.hash(processorId, manufacturer, typeOfProcessor, modelOfProcessor, numberOfCores, graphicProcessor, lithography);
    }
}
