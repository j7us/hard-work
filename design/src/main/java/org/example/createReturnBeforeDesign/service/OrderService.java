package org.example.createReturnBeforeDesign.service;

import org.example.createReturnBeforeDesign.dto.OrderV1;

public interface OrderService {

    OrderV1 findOrderByUserId(Long id);
}
