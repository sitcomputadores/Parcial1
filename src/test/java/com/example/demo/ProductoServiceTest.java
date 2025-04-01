package com.example.demo;import com.example.demo.model.Producto;import com.example.demo.repository.ProductoRepository;import com.example.demo.service.ProductoService;import org.junit.jupiter.api.Test;import org.mockito.InjectMocks;import org.mockito.Mock;import org.mockito.MockitoAnnotations;import java.util.Arrays;import java.util.Optional;import static org.junit.jupiter.api.Assertions.assertEquals;import static org.mockito.Mockito.*;class ProductoServiceTest {    @Mock    private ProductoRepository productoRepository;    @InjectMocks    private ProductoService productoService;    public ProductoServiceTest() {        MockitoAnnotations.openMocks(this);    }    @Test    void listarProductos() {        when(productoRepository.findAll()).thenReturn(Arrays.asList(                new Producto("1", "Producto 1", 100.0),                new Producto("2", "Producto 2", 200.0)        ));        var productos = productoService.listarProductos();        assertEquals(2, productos.size());        verify(productoRepository, times(1)).findAll();    }    @Test    void obtenerProductoPorId() {        when(productoRepository.findById("1")).thenReturn(Optional.of(new Producto("1", "Producto 1", 100.0)));        var producto = productoService.obtenerProductoPorId("1");        assertEquals("Producto 1", producto.getNombre());        verify(productoRepository, times(1)).findById("1");    }    @Test    void crearProducto() {        Producto producto = new Producto("1", "Producto 1", 100.0);        when(productoRepository.save(producto)).thenReturn(producto);        var productoCreado = productoService.crearProducto(producto);        assertEquals("Producto 1", productoCreado.getNombre());        verify(productoRepository, times(1)).save(producto);    }}