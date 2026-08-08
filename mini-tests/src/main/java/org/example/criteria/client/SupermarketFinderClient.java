package org.example.criteria.client;

import org.example.criteria.dto.Item;

import java.util.List;

public interface SupermarketFinderClient {
    List<Item> findInMarket(List<String> criteria);
}
