package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SaludoControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void testSaludoEndpoint() {
        String url = "http://localhost:" + port + "/saludo?nombre=Fercho";
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        assertEquals("Hola, Fercho", response.getBody(), "El saludo debe ser correcto");
    }
}
