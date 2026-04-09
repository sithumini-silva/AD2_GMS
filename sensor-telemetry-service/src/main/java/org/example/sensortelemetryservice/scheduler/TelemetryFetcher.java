package org.example.sensortelemetryservice.scheduler;

import org.example.sensortelemetryservice.model.SensorData;
import org.example.sensortelemetryservice.service.SensorService;
import org.example.sensortelemetryservice.client.AutomationClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

@Component
public class TelemetryFetcher {

    private final SensorService sensorService;
    private final AutomationClient automationClient;

    public TelemetryFetcher(SensorService sensorService, AutomationClient automationClient) {
        this.sensorService = sensorService;
        this.automationClient = automationClient;
    }

    @Scheduled(fixedRate = 10000) // every 10 seconds
    public void fetchTelemetry() {
        // Simulate fetching from external IoT API
        LocalDateTime now = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
        SensorData data = new SensorData(
                "device-001",
                "zone-A",
                Math.random() * 40, // temperature
                Math.random() * 100, // humidity
                now
        );

        // Save to database
        sensorService.saveSensorData(data);

        // Push to Automation Service
        Map<String, Object> payload = new HashMap<>();
        payload.put("deviceId", data.getDeviceId());
        payload.put("zoneId", data.getZoneId());
        payload.put("temperature", data.getTemperature());
        payload.put("humidity", data.getHumidity());
        payload.put("capturedAt", data.getCapturedAt().toString());

        automationClient.sendTelemetryUpdate(payload);
    }
}