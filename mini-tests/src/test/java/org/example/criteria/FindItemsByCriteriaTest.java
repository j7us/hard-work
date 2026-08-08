package org.example.criteria;

import org.example.criteria.client.SupermarketFinderClient;
import org.example.criteria.dto.Item;
import org.example.criteria.dto.ItemsFilter;
import org.example.criteria.repository.OrderItemsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindItemsByCriteriaTest {

    @Mock
    OrderItemsRepository orderItemsRepository;
    @Mock
    SupermarketFinderClient supermarketFinderClient;

    @InjectMocks
    FindItemsByCriteria findItemsByCriteria;

    @Test
    @DisplayName("Добавлен новый метод поиска, в который теперь передается список")
    void orderItemsRepositoryFindByCriteriaListTest() {
        //WHEN
        findItemsByCriteria.findItems(new ItemsFilter(List.of("tapki", "podushka")));

        //THEN
        Mockito.verify(orderItemsRepository).findByCriteria(ArgumentMatchers.anyList());
    }

    @Test
    @DisplayName("Айтемы теперь группируются по критериям, к которым они принадлежат")
    void itemsGroupedByMapMapTest() {
        //GIVEN
        when(orderItemsRepository.findByCriteria(anyList())).thenReturn(
                List.of(new Item(1L, "tapki"),
                        new Item(2L, "podushka")));

        //WHEN
        Map<String, Set<Item>> items = findItemsByCriteria.findItems(new ItemsFilter(List.of("tapki", "podushka")));

        //THEN
        assertThat(items.keySet()).containsExactly("tapki", "podushka");
    }

    @Test
    @DisplayName("Добавлен дополнительны вызов на получение айтема из маркета")
    void itemsFromMarketTest() {
        //WHEN
        findItemsByCriteria.findItems(new ItemsFilter(List.of("tapki", "podushka")));

        //THEN
        Mockito.verify(supermarketFinderClient).findInMarket(ArgumentMatchers.anyList());
    }

    @Test
    @DisplayName("Айтемы возвращаются только уникальные")
    void groupOnlyUniqueItemsTest() {
        //GIVEN
        when(orderItemsRepository.findByCriteria(anyList())).thenReturn(
                List.of(new Item(1L, "tapki"),
                        new Item(2L, "podushka")));

        when(supermarketFinderClient.findInMarket(anyList())).thenReturn(
                List.of(new Item(1L, "tapki"),
                        new Item(3L, "tapki")));

        //WHEN
        Map<String, Set<Item>> items = findItemsByCriteria.findItems(new ItemsFilter(List.of("tapki", "podushka")));

        //THEN
        assertThat(items.get("tapki").stream().map(Item::getArticul).toList()).containsExactly(1L,3L);
    }
}
