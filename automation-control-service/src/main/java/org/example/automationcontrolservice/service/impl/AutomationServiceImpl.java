package org.example.automationcontrolservice.service.impl;

import org.example.automationcontrolservice.dto.SensorResponseDTO;
import org.example.automationcontrolservice.model.AutomationLog;
import org.example.automationcontrolservice.repository.AutomationLogRepository;
import org.example.automationcontrolservice.service.AutomationService;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AutomationServiceImpl implements AutomationService {

    private final WebClient webClient;
    private final AutomationLogRepository repository;

    public AutomationServiceImpl(WebClient webClient, AutomationLogRepository repository) {
        this.webClient = webClient;
        this.repository = repository;
    }

    // 🔥 GET SENSOR DATA FROM SENSOR SERVICE
    private Mono<SensorResponseDTO> getSensorData(String deviceId) {
        return webClient.get()
                .uri("/sensors/device/" + deviceId)
                .retrieve()
                .bodyToMono(SensorResponseDTO.class);
    }

    @Override
    public Mono<Void> process(String deviceId) {

        return getSensorData(deviceId)
                .flatMap(data -> {

                    if (data == null) {
                        return Mono.error(new RuntimeException("No sensor data found"));
                    }

                    double temp = data.getTemperature();

                    AutomationLog log = new AutomationLog();
                    log.setZoneName(data.getZoneId());

                    // 🔥 RULE ENGINE
                    if (temp > 30) {
                        log.setAction("TURN_ON_COOLING_SYSTEM");
                    } else {
                        log.setAction("NO_ACTION");
                    }

                    return Mono.fromRunnable(() -> repository.save(log));
                });
    }

    @Override
    public Mono<List<AutomationLog>> getAllLogs() {
        return Mono.just(repository.findAll());
    }
}

//package org.example.automationcontrolservice.service.impl;
//
//import org.example.automationcontrolservice.dto.SensorResponseDTO;
//import org.example.automationcontrolservice.model.AutomationLog;
//import org.example.automationcontrolservice.repository.AutomationLogRepository;
//import org.example.automationcontrolservice.service.AuthService;
//import org.example.automationcontrolservice.service.AutomationService;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//import reactor.core.publisher.Mono;
//
//import java.util.List;
//
//@Service
//public class AutomationServiceImpl implements AutomationService {
//
//    private final WebClient webClient;
//    private final AutomationLogRepository repository;
//    private final AuthService authService;
//
//    public AutomationServiceImpl(WebClient webClient,
//                                 AutomationLogRepository repository,
//                                 AuthService authService) {
//        this.webClient = webClient;
//        this.repository = repository;
//        this.authService = authService;
//    }
//
//    // 🔥 CALL EXTERNAL IOT API
//    private Mono<SensorResponseDTO> getSensorData(String deviceId) {
//
//        return authService.getAccessToken()
//                .flatMap(token ->
//                        webClient.get()
//                                .uri("/devices/telemetry/" + deviceId)
//                                .header("Authorization", "Bearer " + token)
//                                .retrieve()
//                                .bodyToMono(SensorResponseDTO.class)
//                );
//    }
//
//    @Override
//    public Mono<Void> process(String deviceId) {
//
//        return getSensorData(deviceId)
//                .flatMap(data -> {
//
//                    double temp = data.getValue().getTemperature();
//
//                    AutomationLog log = new AutomationLog();
//                    log.setZoneName(data.getZoneId());
//
//                    // 🔥 RULE ENGINE
//                    if (temp > 30) {
//                        log.setAction("TURN_ON_COOLING_SYSTEM");
//                    } else {
//                        log.setAction("NO_ACTION");
//                    }
//
//                    return Mono.fromCallable(() -> repository.save(log)).then();
//                });
//    }
//
//    @Override
//    public Mono<List<AutomationLog>> getAllLogs() {
//        return Mono.fromCallable(() -> repository.findAll());
//    }
