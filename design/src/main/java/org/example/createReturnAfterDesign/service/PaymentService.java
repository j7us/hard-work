package org.example.createReturnAfterDesign.service;

import org.example.createReturnAfterDesign.client.PaymentCheckerClient;
import org.example.createReturnAfterDesign.repository.PaymentRepository;

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
