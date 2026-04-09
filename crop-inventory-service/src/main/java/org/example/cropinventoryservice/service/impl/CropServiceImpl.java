package org.example.cropinventoryservice.service.impl;

import org.example.cropinventoryservice.model.Crop;
import org.example.cropinventoryservice.model.CropStatus;
import org.example.cropinventoryservice.repository.CropRepository;
import org.example.cropinventoryservice.service.CropService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CropServiceImpl implements CropService {

    private final CropRepository repository;

    public CropServiceImpl(CropRepository repository) {
        this.repository = repository;
    }

    @Override
    public Crop createCrop(Crop crop) {
        return repository.save(crop);
    }

    @Override
    public Crop updateCropStatus(Long id, CropStatus status) {
        Crop crop = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop not found with ID: " + id));
        crop.setStatus(status);
        return repository.save(crop);
    }

    @Override
    public List<Crop> getAllCrops() {
        return repository.findAll();
    }

    @Override
    public Crop getCropById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Crop not found with ID: " + id));
    }

    @Override
    public void deleteCrop(Long id) {
        repository.deleteById(id);
    }
}