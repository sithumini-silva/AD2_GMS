package org.example.sensortelemetryservice.service.impl;

import org.example.sensortelemetryservice.model.SensorData;
import org.example.sensortelemetryservice.repo.SensorRepo;
import org.example.sensortelemetryservice.service.SensorService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    private final SensorRepo sensorRepo;

    public SensorServiceImpl(SensorRepo sensorRepo) {
        this.sensorRepo = sensorRepo;
    }

    @Override
    public SensorData getLatestSensorData(String deviceId) {
        return sensorRepo.findTopByDeviceIdOrderByCapturedAtDesc(deviceId);
    }

    @Override
    public List<SensorData> getAllSensors() {
        return sensorRepo.findAll();
    }

    @Override
    public SensorData saveSensorData(SensorData data) {
        if (data.getCapturedAt() == null) {
            data.setCapturedAt(LocalDateTime.now());
        }
        return sensorRepo.save(data);
    }

    @Override
    public void deleteByDeviceId(String deviceId) {
        SensorData latest = getLatestSensorData(deviceId);
        if (latest != null) {
            sensorRepo.delete(latest);
        }
    }

    public SensorData updateSensorData(Long id, SensorData newData) {
        SensorData existing = sensorRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor data not found"));

        existing.setDeviceId(newData.getDeviceId());
        existing.setZoneId(newData.getZoneId());
        existing.setTemperature(newData.getTemperature());
        existing.setHumidity(newData.getHumidity());
        existing.setCapturedAt(newData.getCapturedAt());

        return sensorRepo.save(existing);
    }
}