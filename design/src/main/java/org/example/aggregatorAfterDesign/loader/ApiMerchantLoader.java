package org.example.aggregatorAfterDesign.loader;

import org.example.aggregatorAfterDesign.client.MerchantApiClient;
import org.example.aggregatorAfterDesign.dto.Merchant;

import java.util.ArrayList;
import java.util.List;

public class ApiMerchantLoader implements MerchantLoader {

    private final List<MerchantApiClient> merchantApiClients;

    public ApiMerchantLoader(List<MerchantApiClient> merchantApiClients) {
        this.merchantApiClients = merchantApiClients;
    }

    @Override
    public List<Merchant> loadMerchants(String address) {
        List<Merchant> merchants = new ArrayList<>();

        for (MerchantApiClient merchantApiClient : merchantApiClients) {
            merchants.addAll(merchantApiClient.getAvailableMerchants(address));
        }

        return merchants;
    }
}
