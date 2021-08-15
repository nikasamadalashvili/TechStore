package web.app.TechStore.TechStore.service.models;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public class FilteredMobileListResponse {
    private List<ProductDto> filteredProducts;

    public FilteredMobileListResponse(List<ProductDto> filteredProducts) {
        this.filteredProducts = filteredProducts;
    }

    public List<ProductDto> getFilteredProducts() {
        return filteredProducts;
    }

    //missing price and photo
    public static class ProductDto {
        private long productId;
        private String name;
        private Double price;
        private String imageName;

        public ProductDto(long productId, String name, Double price, String imageName) {
            this.productId = productId;
            this.name = name;
            this.price = price;
            this.imageName = imageName;
        }

        public long getProductId() {
            return productId;
        }

        public String getName() {
            return name;
        }

        public Double getPrice() {
            return price;
        }

        public String getImageName() {
            return imageName;
        }
    }
}
