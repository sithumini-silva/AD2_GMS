package org.example.zonemanagementservice.dto;

public class ZoneDTO {
    private String name;
    private Double minTemp;
    private Double maxTemp;

    public ZoneDTO() {}

    public ZoneDTO(String name, Double minTemp, Double maxTemp) {
        this.name = name;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getMinTemp() { return minTemp; }
    public void setMinTemp(Double minTemp) { this.minTemp = minTemp; }

    public Double getMaxTemp() { return maxTemp; }
    public void setMaxTemp(Double maxTemp) { this.maxTemp = maxTemp; }
}