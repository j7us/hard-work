package org.example.createReturnAfterDesign.repository;

import org.example.createReturnAfterDesign.dto.ReturnCreatingInfo;

public interface ReturnRepository {
    void saveReturn(ReturnCreatingInfo returnCreatingInfo);
}
