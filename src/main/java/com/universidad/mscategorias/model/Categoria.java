package com.universidad.mscategorias.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ═══════════════════════════════════════════════════
// CLASE 4 · ms-categorias · Categoria.java
// Sin anotaciones de Validation: la entidad no recibe
// datos del cliente directamente. Las validaciones
// van en el DTO (si se agrega CategoriaRequestDTO)
// o se manejan en el GlobalExceptionHandler.
// Las restricciones @Column se mantienen: son de BD.
// ═══════════════════════════════════════════════════

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 255)
    private String descripcion;
}
