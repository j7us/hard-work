package org.example.criteria;

import org.example.criteria.client.SupermarketFinderClient;
import org.example.criteria.dto.Item;
import org.example.criteria.dto.ItemsFilter;
import org.example.criteria.repository.OrderItemsRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class FindItemsByCriteria {
    private final OrderItemsRepository orderItemsRepository;
    private final SupermarketFinderClient supermarketFinderClient;

    public FindItemsByCriteria(OrderItemsRepository orderItemsRepository, SupermarketFinderClient supermarketFinderClient) {
        this.orderItemsRepository = orderItemsRepository;
        this.supermarketFinderClient = supermarketFinderClient;
    }

    public Map<String, Set<Item>> findItems(ItemsFilter itemsFilter) {
        List<String> criteria = itemsFilter.getCriteria();

        List<Item> inMarket = supermarketFinderClient.findInMarket(criteria);
        List<Item> byCriteria = orderItemsRepository.findByCriteria(criteria);

        ArrayList<Item> allItems = new ArrayList<>(inMarket);
        allItems.addAll(byCriteria);

        return allItems.stream()
                .collect(Collectors.groupingBy(
                        Item::getType,
                        Collectors.toSet()
                ));
    }
}
