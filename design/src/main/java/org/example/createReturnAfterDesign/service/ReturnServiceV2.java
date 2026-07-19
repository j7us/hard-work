package org.example.createReturnAfterDesign.service;

import org.example.createReturnAfterDesign.dto.ReturnCreatingInfo;
import org.example.createReturnAfterDesign.repository.ReturnRepository;

public class ReturnServiceV2 {
    ReturnRepository returnRepository;

    public void createReturn(ReturnCreatingInfo returnCreatingInfo) {
        returnRepository.saveReturn(returnCreatingInfo);
    }
}
