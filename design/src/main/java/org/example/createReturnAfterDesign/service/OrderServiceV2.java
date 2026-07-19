package org.example.createReturnAfterDesign.service;

import org.example.createReturnAfterDesign.dto.Order;

public interface OrderServiceV2 {

    Order findReturnableOrderByUserId(Long id);
}
