package org.example.automationcontrolservice.service;

import org.example.automationcontrolservice.model.AutomationLog;
import reactor.core.publisher.Mono;

import java.util.List;
public interface AutomationService {
    Mono<Void> process(String deviceId);

    Mono<List<AutomationLog>> getAllLogs();
}
