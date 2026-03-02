package com.example.tiendaonline.controller;

import com.example.tiendaonline.model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class restDemoController {

    private List<Producto> productos = new ArrayList<>();

    // Constructor para llenar la lista
    public restDemoController() {
        productos.add(new Producto(1, "Laptop", 15000));
        productos.add(new Producto(2, "Mouse", 300));
        productos.add(new Producto(3, "Teclado", 800));
    }

    // GET todos
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productos;
    }

    // GET por id
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable int id) {
        return productos.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // POST
    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        productos.add(producto);
        return producto;
    }

    // PUT
    @PutMapping("/{id}")
    public Producto actualizarProducto(@PathVariable int id, @RequestBody Producto productoActualizado) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                producto.setNombre(productoActualizado.getNombre());
                producto.setPrecio(productoActualizado.getPrecio());
                return producto;
            }
        }
        return null;
    }
}
