package org.example.zonemanagementservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "zones")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double minTemp;
    private Double maxTemp;

    public Zone() {}

    public Zone(String name, Double minTemp, Double maxTemp) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getMinTemp() { return minTemp; }
    public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }

    public Double getMaxTemp() { return maxTemp; }
    public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }
}