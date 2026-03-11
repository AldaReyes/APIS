package com.example.tiendaonline.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEnvio;

    private String direccionEnvio;

    private String estado;

    private LocalDateTime fechaEnvio;

    private LocalDateTime fechaEntrega;

    private String estatus;

    @OneToOne
    @JoinColumn(name = "id_venta")
    private Venta venta;
}