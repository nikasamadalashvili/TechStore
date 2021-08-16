package web.app.TechStore.TechStore.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartServiceTest {

    private EntityManager entityManager;

    public ShoppingCartServiceTest(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void addShoppingCardObject() {
    }

    @Test
    void editShoppingCartObject() {
    }

    @Test
    void deleteShoppingCartObject() {
    }
}