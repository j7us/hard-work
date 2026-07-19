package org.example.createReturnAfterDesign.dto;

import java.util.UUID;

public class ReturnCreatingInfo {
    public Long userId;
    public String paymentData;
    public String returnReason;
    public String comment;
    public UUID imageId;
    public Order order;

    public ReturnCreatingInfo(Long userId, String paymentData, String returnReason, String comment, UUID imageId, Order order) {
        this.userId = userId;
        this.paymentData = paymentData;
        this.returnReason = returnReason;
        this.comment = comment;
        this.imageId = imageId;
        this.order = order;
    }
}
