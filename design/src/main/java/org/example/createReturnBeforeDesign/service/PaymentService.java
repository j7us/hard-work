package org.example.createReturnBeforeDesign.service;

import org.example.createReturnBeforeDesign.client.PaymentCheckerClient;
import org.example.createReturnBeforeDesign.repository.PaymentRepository;

public class PaymentService {
    PaymentCheckerClient paymentCheckerClient;
    PaymentRepository paymentRepository;

    public boolean validatePayment(String paymentData) {
        String cardNumber = paymentCheckerClient.allowedCardNumber();

        return paymentData.startsWith(cardNumber);
    }

    public void savePayment(String paymentData) {
        paymentRepository.savePayment(paymentData);
    }
}
