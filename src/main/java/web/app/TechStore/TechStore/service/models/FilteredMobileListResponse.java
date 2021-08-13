package web.app.TechStore.TechStore.service.models;

import java.util.List;

public class FilteredMobileListResponse {
    private List<ProductDto> filteredProducts;

    public FilteredMobileListResponse(List<ProductDto> filteredProducts) {
        this.filteredProducts = filteredProducts;
    }

    public List<ProductDto> getFilteredProducts() {
        return filteredProducts;
    }


    public static class ProductDto {
        private long productId;
        private String name;

        public ProductDto(long productId, String name) {
            this.productId = productId;
            this.name = name;
        }

        public long getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }
    }
}
