package web.app.TechStore.TechStore.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import web.app.TechStore.TechStore.service.models.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MobileServiceTest {
    public MobileService mobileService;
    public long newProductId;
    public void Init(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tech-store");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        mobileService = new MobileService(entityManager);
    }
    private void addItem(){
        Init();
        AddProductResponse responseResu = mobileService.addProduct(new AddProductRequest("a", "a", "a",
                "a", null, 123, 19,50.0, "kkkkkkk",18, "a", null, "a", 5, null,
                "a","a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a",
                "a","a","a", "a","a","a",
                "a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a","a",
                "a","a","a", "a","a","a","a","a","a",
                "a","a","a","a","a",
                "a","a",5, "a","a", 5,
                "a","a","a","a","a","a",
                "a","a","a","a","a","a","a",
                "a","a","a","a","a","a"));
        newProductId = responseResu.getProductId();
    }

    @Test
    void getFilteredMobileList() {
        addItem();
        List<String> brands = new ArrayList<String>();
        brands.add(0, "a");
        List<Integer> cameras = new ArrayList<Integer>();
        cameras.add(0, 5);
        List<Integer> screenSize = new ArrayList<Integer>();
        screenSize.add(0, 18);
        List<String> empty = new ArrayList<String>();
        FilteredMobileListRequest filter = new FilteredMobileListRequest("a",brands,empty,
                screenSize,empty,empty,
                empty,empty,
                cameras,empty,empty,
                empty,cameras,empty,
                empty,empty,empty,empty,
                empty,empty, 25.0 ,100.0);
        FilteredMobileListResponse found = mobileService.getFilteredMobileList(filter);
    }

    @Test
    void addProduct() {
        addItem();
        MobileDetailsRequest mobileId = new MobileDetailsRequest(newProductId);
        MobileDetailsResponse mobileDetails = mobileService.getMobileDetails(mobileId);
        assertTrue(mobileDetails.getName().equals("" + 'a'));
        assertEquals(mobileDetails.getPrice(), 50.0);
    }


    @Test
    void editProduct() {
        addItem();
        EditProductRequest editRequest = new EditProductRequest(newProductId, "b", "a", "a",
                "a", null, 123, 19,50.0, "kkkkkkk",9, "a", null, "a", 5, null,
                "a","a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a",
                "a","a","a", "a","a","a",
                "a","a","a","a","a","a",
                "a","a","a","a","a","a","a","a","a",
                "a","a","a", "a","a","a","a","a","a",
                "a","a","a","a","a",
                "a","a",5, "a","a", 5,
                "a","a","a","a","a","a",
                "a","a","a","a","a","a","a",
                "a","a","a","a","a","a");
        EditProductResponse resp = mobileService.editProduct(editRequest);
        assertTrue(editRequest.getName().equals("b"));
        MobileDetailsRequest mobileId = new MobileDetailsRequest(newProductId);
        MobileDetailsResponse mobileDetails = mobileService.getMobileDetails(mobileId);
        assertTrue(mobileDetails.getName().equals("" + 'b'));
        assertEquals(mobileDetails.getPrice(), 50.0);
    }

    @Test
    void deleteProduct() {
        addItem();
        DeleteProductRequest DeleteRequest = new DeleteProductRequest(newProductId);
        DeleteProductResponse deleteResponse = mobileService.deleteProduct(DeleteRequest);
    }
}