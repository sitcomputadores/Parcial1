package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraServiceTest {
    @Test
    void testSumar() {
        CalculadoraService calculadora = new CalculadoraService();
        int resultado = calculadora.sumar(5, 3);
        assertEquals(8, resultado, "La suma debe ser 8");
    }

    @Test
    void testSumarNegativos() {
        CalculadoraService calculadora = new CalculadoraService();
        int resultado = calculadora.sumar(-2, -3);
        assertEquals(-5, resultado, "La suma de -2 y -3 debe ser -5");
    }
    
}




