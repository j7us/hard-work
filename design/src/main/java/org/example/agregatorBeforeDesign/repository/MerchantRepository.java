package org.example.agregatorBeforeDesign.repository;

import org.example.agregatorBeforeDesign.dto.Merchant;

import java.util.List;

public interface MerchantRepository {

    List<Merchant> findAllMerchants();
}
