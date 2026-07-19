package org.example.aggregatorAfterDesign.client;

import org.example.aggregatorAfterDesign.dto.Merchant;

import java.util.List;

public interface MerchantApiClient {

    List<Merchant> getAvailableMerchants(String address);
}
