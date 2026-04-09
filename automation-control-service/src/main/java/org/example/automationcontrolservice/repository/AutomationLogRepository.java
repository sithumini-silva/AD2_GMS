package org.example.automationcontrolservice.repository;

import org.example.automationcontrolservice.model.AutomationLog;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AutomationLogRepository extends JpaRepository<AutomationLog, Long> {
}