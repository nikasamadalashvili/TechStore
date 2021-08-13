package web.app.TechStore.TechStore.service.models;

public class FilteredMobileListRequest {
    private String name;
    private Boolean isAsus;
    private Double from;
    private Double to;

    public FilteredMobileListRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
