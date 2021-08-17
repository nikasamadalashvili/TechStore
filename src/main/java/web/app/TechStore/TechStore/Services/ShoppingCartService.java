package web.app.TechStore.TechStore.Services;

import web.app.TechStore.TechStore.DomainModels.Products;
import web.app.TechStore.TechStore.DomainModels.ShoppingCartObjects;
import web.app.TechStore.TechStore.DomainModels.Users;
import web.app.TechStore.TechStore.Services.models.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequestScoped
public class ShoppingCartService {

    private EntityManager entityManager;

    public ShoppingCartService() {}

    @Inject
    public ShoppingCartService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public AddShoppingCartObjectResponse addShoppingCardObject(AddShoppingCartObjectRequest request){
        entityManager.getTransaction().begin();
        Products product = entityManager.find(Products.class, request.getProductId());
        Users user = entityManager.find(Users.class, request.getUserId());
        Double productPrice = product.getPrice();
        Integer prod_quantity = request.getProductQuantity();
        if (prod_quantity > product.getAvailableQuantity()){
            entityManager.flush();
            entityManager.getTransaction().commit();
            return new AddShoppingCartObjectResponse(false, -1);
        }
        ShoppingCartObjects shoppingCartObject = new ShoppingCartObjects(user,
                product, productPrice*prod_quantity, prod_quantity);
        product.setReservedQuantity(product.getReservedQuantity() + prod_quantity);
        product.setAvailableQuantity(product.getAvailableQuantity() - prod_quantity);
        entityManager.persist(shoppingCartObject);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return new AddShoppingCartObjectResponse(true,
                shoppingCartObject.getShoppingCardObjID());
    }

    /*returns false if not enough product available*/
    public EditShoppingCartObjectResponse editShoppingCartObject(EditShoppingCartObjectRequest request){
        entityManager.getTransaction().begin();
        ShoppingCartObjects shoppingCartObject =
                entityManager.find(ShoppingCartObjects.class, request.getShoppingCartId());
        Products product = entityManager.find(Products.class, shoppingCartObject.getProductByProductId().getProductId());
        Users user = entityManager.find(Users.class, shoppingCartObject.getUserByUserId().getUserId());
        Integer old_prod_quantity = shoppingCartObject.getTotalQuantityImmutable();
        Integer new_prod_quantity = request.getProductQuantity();
        Integer delta = new_prod_quantity - old_prod_quantity;
        if (product.getAvailableQuantity()-delta < 0){
            entityManager.flush();
            entityManager.getTransaction().commit();
            return new EditShoppingCartObjectResponse(false);
        }
        product.setAvailableQuantity(product.getAvailableQuantity()-delta);
        product.setReservedQuantity(product.getReservedQuantity()+delta);
        Double new_total_price = shoppingCartObject.getTotalCostImmutable();
        if(new_prod_quantity > old_prod_quantity){
            new_total_price = product.getPrice()*new_prod_quantity;
        }else{
            new_total_price =
                    shoppingCartObject.getTotalCostImmutable() / old_prod_quantity * new_prod_quantity;
        }
        shoppingCartObject.setTotalCostImmutable(new_total_price);
        shoppingCartObject.setTotalQuantityImmutable(new_prod_quantity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return new EditShoppingCartObjectResponse(true);
    }

    /*returns false if not enough product available*/
    public DeleteShoppingCartObjectResponse deleteShoppingCartObject(DeleteShoppingCartObjectRequest request){
        entityManager.getTransaction().begin();
        ShoppingCartObjects shoppingCartObject =
                entityManager.find(ShoppingCartObjects.class, request.getShoppingCartId());
        Products product = entityManager.find(Products.class, shoppingCartObject.getProductByProductId().getProductId());
        product.setAvailableQuantity(product.getAvailableQuantity()+shoppingCartObject.getTotalQuantityImmutable());
        product.setReservedQuantity(product.getReservedQuantity()-shoppingCartObject.getTotalQuantityImmutable());
        entityManager.remove(shoppingCartObject);
        entityManager.flush();
        entityManager.getTransaction().commit();

        return new DeleteShoppingCartObjectResponse(true);
    }

    public ShoppingCartObjectsByUserResponse getShoppingCartObjectsByUserId
            (ShoppingCartObjectsByUserRequest request)
    {
        Query query = entityManager.createQuery
                ("select obj from ShoppingCartObjects obj where obj.userByUserId.userId = :givenUserId");
        query.setParameter("givenUserId", request.getUserId());
        List<ShoppingCartObjects> result = query.getResultList();
        Double totalCost = 0.0;
        for (ShoppingCartObjects x: result) {
            totalCost += x.getTotalCostImmutable();
        }

        return new ShoppingCartObjectsByUserResponse(result, totalCost);
    }

    /*takes user id, returns total cost (wrapped in classes)*/
    public BuyCartProductsResponse buyShoppingCartProducts(BuyCartProductsRequest request){
        ShoppingCartObjectsByUserResponse productsAndCost = getShoppingCartObjectsByUserId
                (new ShoppingCartObjectsByUserRequest(request.getUserId()));
        List<ShoppingCartObjects> productList = productsAndCost.getShoppingCartObjects();
        for (ShoppingCartObjects x: productList) {
            Products prod = x.getProductByProductId();
            prod.setReservedQuantity(prod.getReservedQuantity() - x.getTotalQuantityImmutable());
            entityManager.getTransaction().begin();
            entityManager.remove(x);
            entityManager.flush();
            entityManager.getTransaction().commit();
        }
        return new BuyCartProductsResponse(productsAndCost.getTotalCost());
    }



}
