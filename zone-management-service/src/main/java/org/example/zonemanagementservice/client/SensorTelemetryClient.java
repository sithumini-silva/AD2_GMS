package org.example.zonemanagementservice.client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;

@Component
public class SensorTelemetryClient {

    @Value("${user.service.url}")
    private String userServiceUrl;

    @Value("${iot.api.base-url}")
    private String iotBaseUrl;

    private final WebClient.Builder webClientBuilder;

    public SensorTelemetryClient(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String getJwtToken(String username, String password) {
        Map<String,String> credentials = Map.of("username", username,"password", password);
        Map response = webClientBuilder.build()
                .post()
                .uri(userServiceUrl + "/auth/authenticate")
                .bodyValue(credentials)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
        return (String) response.get("accessToken");
    }

    public Map registerDevice(Map payload, String jwtToken) {
        return webClientBuilder.build()
                .post()
                .uri(iotBaseUrl + "/devices")
                .header("Authorization", "Bearer " + jwtToken)
                .bodyValue(payload)
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}