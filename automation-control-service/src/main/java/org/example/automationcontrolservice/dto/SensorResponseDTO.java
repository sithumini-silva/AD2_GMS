package org.example.automationcontrolservice.dto;

public class SensorResponseDTO {
    private Long id;
    private String deviceId;
    private String zoneId;
    private double temperature;
    private double humidity;
    private String capturedAt;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getZoneId() { return zoneId; }
    public void setZoneId(String zoneId) { this.zoneId = zoneId; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public double getHumidity() { return humidity; }
    public void setHumidity(double humidity) { this.humidity = humidity; }


//    private String deviceId;
//    private String zoneId;
//    private Value value;
//    private String capturedAt;
//
//    public static class Value {
//        private double temperature;
//        private double humidity;
//
//        public double getTemperature() { return temperature; }
//        public void setTemperature(double temperature) { this.temperature = temperature; }
//
//        public double getHumidity() { return humidity; }
//        public void setHumidity(double humidity) { this.humidity = humidity; }
//    }
//
//    public String getDeviceId() { return deviceId; }
//    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }
//
//    public String getZoneId() { return zoneId; }
//    public void setZoneId(String zoneId) { this.zoneId = zoneId; }
//
//    public Value getValue() { return value; }
//    public void setValue(Value value) { this.value = value; }
//
//    public String getCapturedAt() { return capturedAt; }
//    public void setCapturedAt(String capturedAt) { this.capturedAt = capturedAt; }

}
