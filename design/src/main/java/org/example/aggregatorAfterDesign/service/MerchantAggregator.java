package org.example.aggregatorAfterDesign.service;

import org.example.aggregatorAfterDesign.dto.Merchant;
import org.example.aggregatorAfterDesign.loader.MerchantLoader;

import java.util.ArrayList;
import java.util.List;

public class MerchantAggregator {

    private final List<MerchantLoader> merchantLoaders;

    public MerchantAggregator(List<MerchantLoader> merchantLoaders) {
        this.merchantLoaders = merchantLoaders;
    }

    public List<Merchant> loadAllMerchants(String address) {
        List<Merchant> merchants = new ArrayList<>();

        for (MerchantLoader merchantLoader : merchantLoaders) {
            merchants.addAll(merchantLoader.loadMerchants(address));
        }

        return merchants;
    }
}
