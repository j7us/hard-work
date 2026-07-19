package org.example.aggregatorAfterDesign.dto;

import java.util.List;

public class Merchant {

    private Long id;
    private String name;
    private String aggregatorType;
    private List<String> categories;

    public Merchant(Long id, String name, String aggregatorType, List<String> categories) {
        this.id = id;
        this.name = name;
        this.aggregatorType = aggregatorType;
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

    public String getAggregatorType() {
        return aggregatorType;
    }

    public void setAggregatorType(String aggregatorType) {
        this.aggregatorType = aggregatorType;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}
