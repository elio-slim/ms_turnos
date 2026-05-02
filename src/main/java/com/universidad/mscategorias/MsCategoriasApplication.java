package com.universidad.mscategorias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ═══════════════════════════════════════════════════
// CLASE 4 · MsCategoriasApplication.java
// Punto de entrada del microservicio de Categorías.
// Corre en su propio proceso JVM, puerto 8081.
// ═══════════════════════════════════════════════════

@SpringBootApplication
public class MsCategoriasApplication {
    public static void main(String[] args) {
        SpringApplication.run(MsCategoriasApplication.class, args);
    }
}
