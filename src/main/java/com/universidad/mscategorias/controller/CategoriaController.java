package com.universidad.mscategorias.controller;

import com.universidad.mscategorias.model.Categoria;
import com.universidad.mscategorias.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// ═══════════════════════════════════════════════════
// CLASE 4 · ms-categorias · CategoriaController.java
//
// En este microservicio Categoria sigue recibiendo
// el objeto directamente (sin DTO dedicado) porque
// es un modelo simple. @Valid aplicado aquí solo
// tendría efecto si la entidad tuviera anotaciones
// de validación, lo cual quitamos. Se deja @Valid
// para mostrar el patrón correcto; si en el futuro
// se agrega un CategoriaRequestDTO, @Valid ya funciona.
//
// GlobalExceptionHandler maneja cualquier error
// de validación o RuntimeException automáticamente.
// ═══════════════════════════════════════════════════

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    // GET http://localhost:8081/api/categorias → 200 OK
    @GetMapping
    public ResponseEntity<List<Categoria>> obtenerTodas() {
        return ResponseEntity.ok(categoriaService.obtenerTodas());
    }

    // GET http://localhost:8081/api/categorias/{id} → 200 OK o 404
    // ms-libros llama a este endpoint con RestTemplate para validar
    // que una categoría existe antes de guardar un libro.
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerPorId(@PathVariable Long id) {
        return categoriaService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST http://localhost:8081/api/categorias → 201 Created
    @PostMapping
    public ResponseEntity<Categoria> crear(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.status(201).body(categoriaService.guardar(categoria));
    }

    // PUT http://localhost:8081/api/categorias/{id} → 200 OK o 404
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody Categoria datos) {
        return categoriaService.obtenerPorId(id)
                .map(existente -> {
                    datos.setId(id);
                    return ResponseEntity.ok(categoriaService.guardar(datos));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE http://localhost:8081/api/categorias/{id} → 204 No Content o 404
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (categoriaService.obtenerPorId(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        categoriaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
