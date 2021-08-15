package web.app.TechStore.TechStore.DomainModels;

import javax.persistence.*;

@Entity
public class ShoppingCartObjects {
    private long shoppingCartObjID;
    private Users userByUserId;
    private Products productByProductId;
    private Double totalCostImmutable;
    private Integer totalQuantityImmutable;


    @Id
    @Column(name = "shoppingCartObjID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getShoppingCardObjID() {
        return shoppingCartObjID;
    }

    public void setShoppingCardObjID(long shoppingCardObjID) {
        this.shoppingCartObjID = shoppingCardObjID;
    }

    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "userID")
    public Users getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(Users userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "productID", referencedColumnName = "productID")
    public Products getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Products productByProductId) {
        this.productByProductId = productByProductId;
    }

    @Basic
    @Column(name = "totalCostImmutable", nullable = false, length = 64)
    public Double getTotalCostImmutable() {
        return totalCostImmutable;
    }

    public void setTotalCostImmutable(Double totalCostImmutable) {
        this.totalCostImmutable = totalCostImmutable;
    }

    @Basic
    @Column(name = "totalQuantityImmutable", nullable = false, length = 64)
    public Integer getTotalQuantityImmutable() {
        return totalQuantityImmutable;
    }

    public void setTotalQuantityImmutable(Integer totalQuantityImmutable) {
        this.totalQuantityImmutable = totalQuantityImmutable;
    }
}
