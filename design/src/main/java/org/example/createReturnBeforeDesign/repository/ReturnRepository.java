package org.example.createReturnBeforeDesign.repository;

import org.example.createReturnBeforeDesign.dto.OrderV1;
import org.example.createReturnBeforeDesign.dto.ReturnReqV1;

public interface ReturnRepository {
    void saveReturn(ReturnReqV1 ret, String reason, OrderV1 orderV1ByUserId);
}
