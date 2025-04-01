package com.example.demo;

import com.example.demo.model.Producto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // Configura un servidor embebido
@AutoConfigureWebTestClient // Habilita WebTestClient
class ProductoIntegrationTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void crearProducto() {
        Producto producto = new Producto("1", "Producto 1", 100.0);

        webTestClient.post()
                .uri("/api/productos")
                .bodyValue(producto)
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.nombre").isEqualTo("Producto 1");
    }

    @Test
    void obtenerProductoPorId() {
        Producto producto = new Producto("1", "Producto 1", 100.0);

        // Crear el producto antes de obtenerlo
        webTestClient.post()
                .uri("/api/productos")
                .bodyValue(producto)
                .exchange()
                .expectStatus().isCreated();

        // Obtener el producto
        webTestClient.get()
                .uri("/api/productos/1")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.nombre").isEqualTo("Producto 1");
    }

    @Test
    void eliminarProducto() {
        webTestClient.delete()
                .uri("/api/productos/1")
                .exchange()
                .expectStatus().isNoContent();
    }
}