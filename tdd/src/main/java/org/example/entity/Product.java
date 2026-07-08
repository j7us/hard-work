package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Product {

    @Id
    UUID id;

    @Column
    String name;

    @Column
    LocalDateTime createdAt;

    @Column
    Boolean issued;

    @Column
    Integer orderedAmount;

    @Column
    Integer amount;

    public Product() {
    }

    public Product(UUID id, String name, LocalDateTime createdAt, Boolean issued, Integer orderedAmount, Integer amount) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.issued = issued;
        this.orderedAmount = orderedAmount;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Boolean getIssued() {
        return issued;
    }

    public void setIssued(Boolean issued) {
        this.issued = issued;
    }

    public Integer getOrderedAmount() {
        return orderedAmount;
    }

    public void setOrderedAmount(Integer orderedAmount) {
        this.orderedAmount = orderedAmount;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
