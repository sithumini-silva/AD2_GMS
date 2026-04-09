package org.example.userservice.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;


@Component
public class UserClient {

    @Autowired
    private WebClient.Builder webClientBuilder;

    // Replace this with a secure method in production
    private static final String AUTH_TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJyb2xlIjoiQURNSU4iLCJzdWIiOiJhZG1pbkBleGFtcGxlLmNvbSIsImlhdCI6MTc1MDc2Njk0OSwiZXhwIjoxNzUxODAzNzQ5fQ._hV6RxXQYiMUifhZdaTVw3QSR0THQYdbGALC7vLTmPMQLp569It-b-KhXyE0UPLPMIDsmUReK3r0c8dVE4Uhiw";


}
