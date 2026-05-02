package com.universidad.mscategorias.config;

import com.universidad.mscategorias.model.Categoria;
import com.universidad.mscategorias.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// ═══════════════════════════════════════════════════
// CLASE 4 · ms-categorias · DataInitializer.java
// Misma estrategia de Clase 1: solo inserta si la
// BD está vacía (count == 0).
// ═══════════════════════════════════════════════════

@Slf4j
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;

    @Override
    public void run(String... args) {
        if (categoriaRepository.count() > 0) {
            log.info(">>> ms-categorias: BD ya tiene datos, se omite la carga inicial.");
            return;
        }
        categoriaRepository.save(new Categoria(null, "Programación",  "Libros de lenguajes y frameworks"));
        categoriaRepository.save(new Categoria(null, "Bases de Datos","SQL, NoSQL y diseño de datos"));
        log.info(">>> ms-categorias: {} categorías insertadas.", categoriaRepository.count());
    }
}
