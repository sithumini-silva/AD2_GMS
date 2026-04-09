package org.example.cropinventoryservice.controller;

import org.example.cropinventoryservice.model.Crop;
import org.example.cropinventoryservice.model.CropStatus;
import org.example.cropinventoryservice.service.CropService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/crops")
public class CropController {

    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    // Create Crop
    @PostMapping
    public Crop createCrop(@RequestBody Crop crop) {
        return cropService.createCrop(crop);
    }

    // Update Crop Status (JSON body)
    @PutMapping("/{id}/status")
    public Crop updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String statusStr = body.get("status");
        CropStatus status = CropStatus.valueOf(statusStr);
        return cropService.updateCropStatus(id, status);
    }

    // Get all Crops
    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    // Get Crop by ID
    @GetMapping("/{id}")
    public Crop getCropById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    // Delete Crop by ID
    @DeleteMapping("/{id}")
    public void deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
    }
}