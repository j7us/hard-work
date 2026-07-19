package org.example.aggregatorAfterDesign.repository;

import org.example.aggregatorAfterDesign.dto.Merchant;

import java.util.List;

public interface MerchantRepository {

    List<Merchant> findAllAvailableMerchants();
}
