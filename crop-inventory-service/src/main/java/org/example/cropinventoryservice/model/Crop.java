package org.example.cropinventoryservice.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "crops")
public class Crop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;

    private Long zoneId;

    private LocalDate plantDate;

    @Enumerated(EnumType.STRING)
    private CropStatus status;

    public Crop() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCropName() { return cropName; }
    public void setCropName(String cropName) { this.cropName = cropName; }

    public Long getZoneId() { return zoneId; }
    public void setZoneId(Long zoneId) { this.zoneId = zoneId; }

    public LocalDate getPlantDate() { return plantDate; }
    public void setPlantDate(LocalDate plantDate) { this.plantDate = plantDate; }

    public CropStatus getStatus() { return status; }
    public void setStatus(CropStatus status) { this.status = status; }
}
