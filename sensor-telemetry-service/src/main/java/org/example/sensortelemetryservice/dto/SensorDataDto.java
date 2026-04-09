package org.example.sensortelemetryservice.dto;

import java.time.Instant;

public class SensorDataDto {
    private String deviceId;
    private String zoneId;
    private double temperature;
    private double humidity;
    private Instant capturedAt;

    public SensorDataDto(String deviceId, String zoneId, double temperature, double humidity, Instant capturedAt) {
        this.deviceId = deviceId;
        this.zoneId = zoneId;
        this.temperature = temperature;
        this.humidity = humidity;
        this.capturedAt = capturedAt;
    }

    public SensorDataDto() {
    }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getZoneId() { return zoneId; }
    public void setZoneId(String zoneId) { this.zoneId = zoneId; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }

    public Instant getCapturedAt() { return capturedAt; }
    public void setCapturedAt(Instant capturedAt) { this.capturedAt = capturedAt; }

}
