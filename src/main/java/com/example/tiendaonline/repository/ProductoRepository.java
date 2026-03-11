package com.example.tiendaonline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.tiendaonline.models.*;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
