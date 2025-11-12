package com.utn.dproductos_api.service; // (Revisá tu package)

import com.utn.dproductos_api.dto.ActualizarStockDTO;
import com.utn.dproductos_api.dto.ProductoDTO;
import com.utn.dproductos_api.dto.ProductoResponseDTO;
import com.utn.dproductos_api.exception.ProductoNotFoundException;
import com.utn.dproductos_api.model.Categoria;
import com.utn.dproductos_api.model.Producto;
import com.utn.dproductos_api.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio que maneja la lógica de negocio para Productos.
 */
@Service
public class ProductoService {

    @Autowired // Inyecta el repositorio
    private ProductoRepository productoRepository;

    // --- Métodos de Mapeo (DTO <-> Entidad) ---
    // (Estos son los métodos auxiliares que pide el TP 3.3)

    private ProductoResponseDTO convertToResponseDTO(Producto producto) {
        ProductoResponseDTO dto = new ProductoResponseDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setStock(producto.getStock());
        dto.setCategoria(producto.getCategoria());
        return dto;
    }

    private Producto convertToEntity(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(dto.getCategoria());
        return producto;
    }

    // --- Métodos CRUD (Como pide el TP 2.2) ---

    public List<ProductoResponseDTO> obtenerTodos() {
        return productoRepository.findAll()
                .stream() // Convierte la lista a un Stream
                .map(this::convertToResponseDTO) // Mapea cada Producto a un DTO
                .collect(Collectors.toList()); // Vuelve a juntar en una lista
    }

    public ProductoResponseDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado con ID: "_ + id)); // Lanza la excepción
        return convertToResponseDTO(producto);
    }

    public ProductoResponseDTO crearProducto(ProductoDTO productoDTO) {
        Producto producto = convertToEntity(productoDTO);
        Producto productoGuardado = productoRepository.save(producto);
        return convertToResponseDTO(productoGuardado);
    }

    public ProductoResponseDTO actualizarProducto(Long id, ProductoDTO productoDTO) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado con ID: "_ + id)); // Valida que exista

        // Actualiza los campos
        productoExistente.setNombre(productoDTO.getNombre());
        productoExistente.setDescripcion(productoDTO.getDescripcion());
        productoExistente.setPrecio(productoDTO.getPrecio());
        productoExistente.setStock(productoDTO.getStock());
        productoExistente.setCategoria(productoDTO.getCategoria());

        Producto productoActualizado = productoRepository.save(productoExistente);
        return convertToResponseDTO(productoActualizado);
    }

    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) { // Valida que exista
            throw new ProductoNotFoundException("Producto no encontrado con ID: "_ + id);
        }
        productoRepository.deleteById(id);
    }

    public List<ProductoResponseDTO> obtenerPorCategoria(Categoria categoria) {
        return productoRepository.findByCategoria(categoria)
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductoResponseDTO actualizarStock(Long id, ActualizarStockDTO stockDTO) {
        Producto productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new ProductoNotFoundException("Producto no encontrado con ID: "_ + id)); // Valida que exista

        productoExistente.setStock(stockDTO.getStock());
        Producto productoActualizado = productoRepository.save(productoExistente);
        return convertToResponseDTO(productoActualizado);
    }
}