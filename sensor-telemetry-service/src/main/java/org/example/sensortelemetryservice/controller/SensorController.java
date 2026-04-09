package org.example.sensortelemetryservice.controller;

import org.example.sensortelemetryservice.model.SensorData;
import org.example.sensortelemetryservice.service.SensorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping
    public List<SensorData> getAllSensors() {
        return sensorService.getAllSensors();
    }

    @PostMapping
    public SensorData addSensor(@RequestBody SensorData sensor) {
        return sensorService.saveSensorData(sensor);
    }

    @GetMapping("/device/{deviceId}")
    public SensorData getSensorByDevice(@PathVariable String deviceId) {
        return sensorService.getLatestSensorData(deviceId);
    }

    @DeleteMapping("/device/{deviceId}")
    public void deleteSensor(@PathVariable String deviceId) {
        sensorService.deleteByDeviceId(deviceId);
    }

    @PutMapping("/{id}")
    public SensorData updateSensor(@PathVariable Long id, @RequestBody SensorData sensor) {
        return sensorService.updateSensorData(id, sensor);
    }
}