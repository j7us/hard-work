package org.example.createReturnBeforeDesign.service;

import org.example.createReturnBeforeDesign.client.ImageStorage;
import org.example.createReturnBeforeDesign.dto.OrderV1;
import org.example.createReturnBeforeDesign.dto.ReturnReqV1;
import org.example.createReturnBeforeDesign.repository.ImageRepository;
import org.example.createReturnBeforeDesign.repository.ReturnRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

public class ReturnServiceV1 {
    OrderService orderService;
    ImageRepository imageRepository;
    ReturnRepository returnRepository;
    ImageStorage imageStorage;
    PaymentService paymentService;

    @Transactional
    public void createReturn(ReturnReqV1 returnReqV1) {
        OrderV1 orderV1ByUserId = orderService.findOrderByUserId(returnReqV1.getUserId());

        if(orderV1ByUserId.getStatus().equals("NEW") || orderV1ByUserId.getStatus().equals("RETURN")) {
            throw new RuntimeException("status not Issued");
        }

        String returnReason = returnReqV1.getReturnReason();
        String comment = returnReqV1.getComment();

        validateCommentAndReason(returnReason, comment);
        validatePaymentType(returnReason, returnReqV1.getPaymentData());

        if (returnReason.equals("Did not feat")) {
            returnReason = "APPROVE_BY_SYSTEM";
        }

        imageStorage.sendToStore(returnReqV1.getImageId());
        returnRepository.saveReturn(returnReqV1, returnReason, orderV1ByUserId);
        imageRepository.saveImage(returnReqV1.getImageId());

        if (returnReqV1.getPaymentData() != null && paymentService.validatePayment(returnReqV1.getPaymentData())) {
            paymentService.savePayment(returnReqV1.getPaymentData());
        }
    }

    private void validatePaymentType(String returnReason,
                                     String paymentData) {
        if (returnReason.equals("Bad Item") && paymentData == null) {
            throw new RuntimeException("Missing paymentData");
        }
    }

    private void validateCommentAndReason(String returnReason,
                                          String comment) {
        if (Objects.nonNull(comment) && comment.equals(returnReason)) {
            throw new RuntimeException("comment and reason are equals");
        }
    }
}
