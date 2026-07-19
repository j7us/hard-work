package org.example.createReturnAfterDesign.service;

import org.example.createReturnAfterDesign.client.ImageStorage;

import java.util.UUID;

public class ImageService {
    ImageStorage imageStorage;

    public UUID getSavedImageId(UUID imageId) {
        imageStorage.sendToStore(imageId);
        return imageId;
    }
}
