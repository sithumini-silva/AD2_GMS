package org.example.automationcontrolservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "automation_logs")
public class AutomationLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private String zoneName;

    public AutomationLog() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }
}

