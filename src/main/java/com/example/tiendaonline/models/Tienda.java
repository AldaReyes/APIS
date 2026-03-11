package com.example.tiendaonline.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tiendas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tienda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTienda;

    private String nombre;
    private String direccion;
    private String telefono;
    private String email;

    private LocalDateTime fechaRegistro;

    private String estatus;
}
