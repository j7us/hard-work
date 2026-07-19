package org.example.agregatorBeforeDesign.dto;

import java.util.List;

public class Merchant {

    public Long id;
    public String name;
    public String agregatorType;
    public List<String> categories;

    public Merchant(Long id, String name, String agregatorType, List<String> categories) {
        this.id = id;
        this.name = name;
        this.agregatorType = agregatorType;
        this.categories = categories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAgregatorType() {
        return agregatorType;
    }

    public void setAgregatorType(String agregatorType) {
        this.agregatorType = agregatorType;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
