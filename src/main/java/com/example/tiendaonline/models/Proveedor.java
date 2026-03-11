package com.example.tiendaonline.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "proveedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProveedor;

    private String nombre;
    private String contacto;
    private String telefono;
    private String email;
    private String direccion;

    private LocalDateTime fechaRegistro;

    private String estatus;
}