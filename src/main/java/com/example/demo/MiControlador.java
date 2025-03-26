package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MiControlador {

    @GetMapping("/saludo")
    public String saludo() {
        return "¡Hola, mundo!";
    }
}