package org.example.agregatorBeforeDesign.client;

import java.util.List;

public interface YandexMarketClient {

    List<Long> getAvailableMerchantIds(String address);
}
