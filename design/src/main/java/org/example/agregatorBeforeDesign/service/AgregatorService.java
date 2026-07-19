package org.example.agregatorBeforeDesign.service;

import org.example.agregatorBeforeDesign.client.OzonClient;
import org.example.agregatorBeforeDesign.client.YandexMarketClient;
import org.example.agregatorBeforeDesign.dto.Merchant;
import org.example.agregatorBeforeDesign.repository.MerchantRepository;

import java.util.ArrayList;
import java.util.List;

public class AgregatorService {

    MerchantRepository merchantRepository;
    YandexMarketClient yandexMarketClient;
    OzonClient ozonClient;

    public List<Merchant> findMerchants(List<String> categories, String address) {
        List<Merchant> merchantsFromDatabase = merchantRepository.findAllMerchants();
        List<Merchant> result = new ArrayList<>();

        List<Merchant> yandexMerchants = getMerchantsByAgregator(merchantsFromDatabase, "YANDEX_MARKET");
        yandexMerchants = filterByCategories(yandexMerchants, categories);
        List<Long> availableYandexMerchantIds = yandexMarketClient.getAvailableMerchantIds(address);

        for (Merchant merchant : yandexMerchants) {
            if (availableYandexMerchantIds.contains(merchant.getId())) {
                result.add(merchant);
            }
        }

        List<Merchant> ozonMerchants = ozonClient.getMerchants(address);
        result.addAll(filterByCategories(ozonMerchants, categories));

        List<Merchant> vkusvillMerchants = getMerchantsByAgregator(merchantsFromDatabase, "VKUSVILL");
        result.addAll(filterByCategories(vkusvillMerchants, categories));

        return result;
    }

    private List<Merchant> getMerchantsByAgregator(List<Merchant> merchants, String agregatorType) {
        List<Merchant> result = new ArrayList<>();

        for (Merchant merchant : merchants) {
            if (merchant.getAgregatorType().equals(agregatorType)) {
                result.add(merchant);
            }
        }

        return result;
    }

    private List<Merchant> filterByCategories(List<Merchant> merchants, List<String> categories) {
        List<Merchant> result = new ArrayList<>();

        for (Merchant merchant : merchants) {
            if (hasAnyCategory(merchant, categories)) {
                result.add(merchant);
            }
        }

        return result;
    }

    private boolean hasAnyCategory(Merchant merchant, List<String> categories) {
        for (String category : categories) {
            if (merchant.getCategories().contains(category)) {
                return true;
            }
        }

        return false;
    }
}
