package org.example.createReturnBeforeDesign.dto;

import java.util.UUID;

public class ReturnReqV1 {

    public Long userId;
    public String paymentData;
    public String returnReason;
    public String comment;
    public UUID imageId;

    public ReturnReqV1(Long userId, String paymentData, String returnReason, String comment, UUID imageId) {
        this.userId = userId;
        this.paymentData = paymentData;
        this.returnReason = returnReason;
        this.comment = comment;
        this.imageId = imageId;
    }

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }

    public String getReturnReason() {
        return returnReason;
    }

    public void setReturnReason(String returnReason) {
        this.returnReason = returnReason;
    }
}
