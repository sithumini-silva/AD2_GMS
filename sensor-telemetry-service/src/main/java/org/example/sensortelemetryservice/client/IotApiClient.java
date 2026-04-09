package org.example.sensortelemetryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@FeignClient(name = "iot-external-api", url = "http://104.211.95.241:8080/api")
public interface IotApiClient {

    @PostMapping("/auth/login")
    Map<String, String> login(@RequestBody Map<String, String> credentials);

    @GetMapping("/devices")
    List<Map<String, Object>> getDevices(@RequestHeader("Authorization") String token);

    @GetMapping("/devices/telemetry/{deviceId}")
    Map<String, Object> getTelemetry(@PathVariable("deviceId") String deviceId, @RequestHeader("Authorization") String token);
}
