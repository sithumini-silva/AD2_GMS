package org.example.sensortelemetryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "automation-service")
public interface AutomationClient {

    @PostMapping("/api/automation/process")
    void sendTelemetryUpdate(@RequestBody Map<String, Object> telemetryData);
}