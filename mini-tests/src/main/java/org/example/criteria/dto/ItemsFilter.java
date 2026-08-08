package org.example.criteria.dto;

import java.util.List;

public class ItemsFilter {
    List<String> criteria;

    public ItemsFilter(List<String> criteria) {
        this.criteria = criteria;
    }

    public List<String> getCriteria() {
        return criteria;
    }

    public void setCriteria(List<String> criteria) {
        this.criteria = criteria;
    }
}
