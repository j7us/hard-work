package org.example.service;

import org.example.entity.Product;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProductStatusCalculator {
    private static final Integer MAX_DAY_FOR_UPDATED = 7;

    public String calculateCurrentStatus(Product product) {
        if (isDelayed(product)) {
            return "DELAYED";
        }

        if (isIssued(product)) {
            return "ISSUED";
        }

        int awaitingAmount = calculateAwaitingAmount(product);

        return awaitingAmount != product.getOrderedAmount() ? "HALF_ORDERED" : "AWAITING";
    }

    private boolean isDelayed(Product product) {
        return !product.getIssued() && !product.getCreatedAt().plusDays(MAX_DAY_FOR_UPDATED).isAfter(LocalDateTime.now());
    }

    private boolean isIssued(Product product) {
        return product.getIssued();
    }

    private int calculateAwaitingAmount(Product product) {
        return product.getOrderedAmount() - product.getAmount();
    }
}
