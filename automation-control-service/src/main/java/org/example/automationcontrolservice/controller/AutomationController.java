package org.example.automationcontrolservice.controller;

import org.example.automationcontrolservice.model.AutomationLog;
import org.example.automationcontrolservice.service.AutomationService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/automation")
public class AutomationController {

    private final AutomationService automationService;

    public AutomationController(AutomationService automationService) {
        this.automationService = automationService;
    }

    @PostMapping("/process/{deviceId}")
    public Mono<Void> process(@PathVariable String deviceId) {
        return automationService.process(deviceId);
    }

    @GetMapping("/logs")
    public Mono<List<AutomationLog>> getLogs() {
        return automationService.getAllLogs();
    }
}