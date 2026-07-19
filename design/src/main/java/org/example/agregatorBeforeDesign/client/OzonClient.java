package org.example.agregatorBeforeDesign.client;

import org.example.agregatorBeforeDesign.dto.Merchant;

import java.util.List;

public interface OzonClient {

    List<Merchant> getMerchants(String address);
}
