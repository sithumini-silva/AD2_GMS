package org.example.sensortelemetryservice.service;

import org.example.sensortelemetryservice.model.SensorData;

import java.util.List;

public interface SensorService {
    SensorData getLatestSensorData(String deviceId);
    List<SensorData> getAllSensors();
    SensorData saveSensorData(SensorData data);
    void deleteByDeviceId(String deviceId);
    SensorData updateSensorData(Long id, SensorData newData);
}