package com.example.demo;

import com.example.demo.model.Producto;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class MiControlador {

    private final List<Producto> productos = new ArrayList<>();

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Devuelve 201 CREATED
    public Mono<Producto> crearProducto(@RequestBody Producto producto) {
        productos.add(producto);
        return Mono.just(producto);
    }

    @GetMapping("/{id}")
    public Mono<Producto> obtenerProductoPorId(@PathVariable String id) {
        return Mono.justOrEmpty(productos.stream()
                .filter(producto -> producto.getId().equals(id))
                .findFirst());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // Devuelve 204 NO_CONTENT
    public Mono<Void> eliminarProducto(@PathVariable String id) {
        productos.removeIf(producto -> producto.getId().equals(id));
        return Mono.empty();
    }
}