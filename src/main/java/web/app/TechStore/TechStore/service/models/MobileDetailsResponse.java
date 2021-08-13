package web.app.TechStore.TechStore.service.models;

public class MobileDetailsResponse {
    private long productId;
    private String name;
    private String modelName;
    private String brand;
    private String series;
    private String build;

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

    public MobileDetailsResponse(long productId, String name, String modelName) {
        this.productId = productId;
        this.name = name;
        this.modelName = modelName;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
