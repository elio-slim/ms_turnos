package com.universidad.mscategorias.repository;

import com.universidad.mscategorias.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

// ═══════════════════════════════════════════════════
// CLASE 4 · ms-categorias · CategoriaRepository.java
// ═══════════════════════════════════════════════════

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Los métodos CRUD heredados son suficientes para este microservicio.
}
