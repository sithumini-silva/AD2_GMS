package org.example.sensortelemetryservice.repo;

import org.example.sensortelemetryservice.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepo extends JpaRepository<SensorData, Long> {
    SensorData findTopByDeviceIdOrderByCapturedAtDesc(String deviceId);
}