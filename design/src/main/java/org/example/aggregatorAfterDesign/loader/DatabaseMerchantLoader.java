package org.example.aggregatorAfterDesign.loader;

import org.example.aggregatorAfterDesign.dto.Merchant;
import org.example.aggregatorAfterDesign.repository.MerchantRepository;

import java.util.List;

public class DatabaseMerchantLoader implements MerchantLoader {

    private final MerchantRepository merchantRepository;

    public DatabaseMerchantLoader(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    @Override
    public List<Merchant> loadMerchants(String address) {
        return merchantRepository.findAllAvailableMerchants();
    }
}
