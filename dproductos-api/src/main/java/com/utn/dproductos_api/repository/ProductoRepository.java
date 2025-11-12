package com.utn.dproductos_api.repository; // (Tu package está bien)

import com.utn.dproductos_api.model.Categoria;
import com.utn.dproductos_api.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /**
     * Método personalizado para buscar productos por categoría
     * (Esto es lo que pide la Parte 2.1 del TP)
     */
    List<Producto> findByCategoria(Categoria categoria);
}