package web.app.TechStore.TechStore.service.models;

public class FilteredMobileListRequest {
    private String searchBarText;
    //private Boolean isAsus;
    private Double priceFrom;
    private Double priceTo;


    public FilteredMobileListRequest(String searchBarText) {
        this.searchBarText = searchBarText;
    }

    public String getSearchBarText() {
        return searchBarText;
    }
}
