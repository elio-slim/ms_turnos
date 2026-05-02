package com.universidad.mscategorias.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.LinkedHashMap;
import java.util.Map;

// ═══════════════════════════════════════════════════
// CLASE 4 · ms-categorias · GlobalExceptionHandler.java
// Igual al de Clase 3. Cada microservicio tiene
// su propio manejador de excepciones porque son
// proyectos completamente independientes.
// ═══════════════════════════════════════════════════

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Captura errores de @Valid en los Controllers.
    // Devuelve 400 con { "campo": "mensaje de error" }.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationErrors(
            MethodArgumentNotValidException ex) {

        Map<String, String> errores = new LinkedHashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
            errores.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errores);
    }

    // Captura RuntimeException del Service.
    // Devuelve 400 con { "error": "mensaje" }.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleRuntimeException(
            RuntimeException ex) {

        Map<String, String> error = new LinkedHashMap<>();
        error.put("error", ex.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
}
