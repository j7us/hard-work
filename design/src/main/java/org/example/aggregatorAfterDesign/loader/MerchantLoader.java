package org.example.aggregatorAfterDesign.loader;

import org.example.aggregatorAfterDesign.dto.Merchant;

import java.util.List;

public interface MerchantLoader {

    List<Merchant> loadMerchants(String address);
}
