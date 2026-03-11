package com.example.tiendaonline.controller;

import com.example.tiendaonline.models.*;
import com.example.tiendaonline.repository.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class restDemoController {

    private final ProductoRepository productoRepository;

    public restDemoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // GET todos
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productoRepository.findAll();
    }

    // GET por id
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Integer id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElse(null);
    }

    // POST
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // PUT
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto productoActualizado) {

        Optional<Producto> productoOptional = productoRepository.findById(id);

        if (productoOptional.isPresent()) {
            Producto producto = productoOptional.get();

            producto.setNombre(productoActualizado.getNombre());
            producto.setDescripcion(productoActualizado.getDescripcion());
            producto.setPrecio(productoActualizado.getPrecio());

            return productoRepository.save(producto);
        }

        return null;
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable Integer id) {

        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return "Producto eliminado correctamente";
        }

        return "Producto no encontrado";
    }
}