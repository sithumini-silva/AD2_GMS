package org.example.automationcontrolservice.dto;

public class AutomationDTO {
    private Long id;

    private String action;
    private String zoneName;

    public AutomationDTO() {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public String getZoneName() { return zoneName; }
    public void setZoneName(String zoneName) { this.zoneName = zoneName; }
}
