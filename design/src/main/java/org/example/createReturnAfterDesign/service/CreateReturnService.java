package org.example.createReturnAfterDesign.service;

import org.example.createReturnAfterDesign.dto.Order;
import org.example.createReturnAfterDesign.dto.ReturnCreatingInfo;
import org.example.createReturnAfterDesign.dto.ReturnReqV2;

import java.util.UUID;

public class CreateReturnService {
    OrderServiceV2 orderServiceV2;
    ReturnRequestValidator returnRequestValidator;
    ImageService imageService;
    PaymentService paymentService;
    ReturnServiceV2 returnServiceV2;

    public void createReturn(ReturnReqV2 returnReqV2) {
        returnRequestValidator.validateReturnRequest(returnReqV2);
        paymentService.validatePayment(returnReqV2.getPaymentData());

        UUID savedImageId = imageService.getSavedImageId(returnReqV2.getImageId());
        Order returnableOrderByUserId = orderServiceV2.findReturnableOrderByUserId(returnReqV2.getUserId());

        ReturnCreatingInfo returnCreatingInfo = buildReturnInfo(returnReqV2, returnableOrderByUserId, savedImageId);
        returnServiceV2.createReturn(returnCreatingInfo);
    }

    private ReturnCreatingInfo buildReturnInfo(ReturnReqV2 returnReqV2,
                                               Order returnableOrderByUserId,
                                               UUID savedImageId) {
        return new ReturnCreatingInfo(
                returnReqV2.userId,
                returnReqV2.getPaymentData(),
                updateReasonToAutoApproveIfNeeded(returnReqV2.getReturnReason()),
                returnReqV2.getComment(),
                savedImageId,
                returnableOrderByUserId
        );
    }

    private String updateReasonToAutoApproveIfNeeded(String returnReason) {
        if (returnReason.equals("Did not feat")) {
            return  "APPROVE_BY_SYSTEM";
        }

        return returnReason;
    }
}
