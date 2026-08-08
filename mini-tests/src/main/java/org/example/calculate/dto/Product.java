package org.example.calculate.dto;

public class Product {
    private Long id;
    private Long shopId;

    public Product(Long id, Long shopId) {
        this.id = id;
        this.shopId = shopId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
