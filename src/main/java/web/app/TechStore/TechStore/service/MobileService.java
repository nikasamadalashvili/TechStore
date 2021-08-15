package web.app.TechStore.TechStore.service;



import web.app.TechStore.TechStore.DomainModels.Products;
import web.app.TechStore.TechStore.service.models.FilteredMobileListRequest;
import web.app.TechStore.TechStore.service.models.FilteredMobileListResponse;
import web.app.TechStore.TechStore.service.models.MobileDetailsRequest;
import web.app.TechStore.TechStore.service.models.MobileDetailsResponse;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class MobileService {
    private EntityManager entityManager;

    public MobileService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MobileDetailsResponse getMobileDetails(MobileDetailsRequest request) {
        Products product = entityManager.find(Products.class,request.getId());
        return new MobileDetailsResponse(product.getProductId(),product.getName(),product.getModelName());
    }


    public FilteredMobileListResponse getFilteredMobileList(FilteredMobileListRequest request) {
        Query query = entityManager.createQuery("select p from Products p where (:name is null or p.name = :name)");
        query.setParameter("name", request.getName());
        List<Products> resultList = (List<Products>) query.getResultList();

        ArrayList<FilteredMobileListResponse.ProductDto> productDtos = new ArrayList<>();

        resultList.forEach(products -> {
            productDtos.add(new FilteredMobileListResponse.ProductDto(products.getProductId(), products.getName()));
        });

        return new FilteredMobileListResponse(productDtos);
    }


}
