package com.universidad.mscategorias.service;

import com.universidad.mscategorias.model.Categoria;
import com.universidad.mscategorias.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// ═══════════════════════════════════════════════════
// CLASE 4 · ms-categorias · CategoriaService.java
// ═══════════════════════════════════════════════════

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    // Este método es clave: ms-libros llama al endpoint
    // GET /api/categorias/{id} para verificar que la
    // categoría existe antes de guardar un libro.
    public Optional<Categoria> obtenerPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    public Categoria guardar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void eliminar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
