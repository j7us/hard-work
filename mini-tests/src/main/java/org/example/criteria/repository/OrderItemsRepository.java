package org.example.criteria.repository;

import org.example.criteria.dto.Item;

import java.util.List;

public interface OrderItemsRepository {
    List<Item> findByCriteria(List<String> criteria);
    List<Item> findByCriteria(String criteria);
}
