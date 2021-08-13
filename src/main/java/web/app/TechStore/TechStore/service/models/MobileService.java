package web.app.TechStore.TechStore.service.models;

import web.app.TechStore.TechStore.DomainModels.Products;

import javax.persistence.EntityManager;

public class MobileService {
    private EntityManager entityManager;

    public MobileService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public MobileDetailsResponse getMobileDetails(MobileDetailsRequest request) {
        Products product = entityManager.find(Products.class,request.getId());
        return new MobileDetailsResponse(product.getProductId(),product.getName(),product.getModelName());
    }
}
