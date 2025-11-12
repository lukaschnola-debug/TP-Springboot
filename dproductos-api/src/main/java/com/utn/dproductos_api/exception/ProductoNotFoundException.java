package com.utn.dproductos_api.exception; // (Revisá tu package)

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Excepción personalizada para producto no encontrado (HTTP 404).
 */
@ResponseStatus(HttpStatus.NOT_FOUND) // Esto le dice a Spring que devuelva 404
public class ProductoNotFoundException extends RuntimeException {
    public ProductoNotFoundException(String message) {
        super(message);
    }

