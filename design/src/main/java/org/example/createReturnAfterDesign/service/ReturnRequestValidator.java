package org.example.createReturnAfterDesign.service;

import org.example.createReturnAfterDesign.dto.ReturnReqV2;

import java.util.Objects;

public class ReturnRequestValidator {

    public void validateReturnRequest(ReturnReqV2 returnReqV2) {
        validateCommentAndReason(returnReqV2.getReturnReason(), returnReqV2.getComment());
    }

    private void validateCommentAndReason(String returnReason,
                                          String comment) {
        if (Objects.nonNull(comment) && comment.equals(returnReason)) {
            throw new RuntimeException("comment and reason are equals");
        }
    }
}
