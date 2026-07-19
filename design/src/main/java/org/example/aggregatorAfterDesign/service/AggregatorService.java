package org.example.aggregatorAfterDesign.service;

import org.example.aggregatorAfterDesign.dto.Merchant;

import java.util.List;

public class AggregatorService {

    private final MerchantAggregator merchantAggregator;

    public AggregatorService(MerchantAggregator merchantAggregator) {
        this.merchantAggregator = merchantAggregator;
    }

    public List<Merchant> findMerchants(List<String> categories, String address) {
        return merchantAggregator.loadAllMerchants(address).stream()
                .filter(merchant -> hasAnyCategory(merchant, categories))
                .toList();
    }

    private boolean hasAnyCategory(Merchant merchant, List<String> categories) {
        return categories.stream().anyMatch(merchant.getCategories()::contains);
    }
}
