package org.example.cropinventoryservice.service;

import org.example.cropinventoryservice.model.Crop;
import org.example.cropinventoryservice.model.CropStatus;

import java.util.List;

public interface CropService {
    Crop createCrop(Crop crop);
    Crop updateCropStatus(Long id, CropStatus status);
    List<Crop> getAllCrops();
    Crop getCropById(Long id);
    void deleteCrop(Long id);
}