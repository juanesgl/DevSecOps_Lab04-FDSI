package com.lab.services;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

public class FileService {
    private static final Logger LOGGER = Logger.getLogger(FileService.class.getName());

    public void viewDocument(String filename) {
        // S-05 FIX: Normalizar ruta y validar que no exista Path Traversal
        Path basePath = Paths.get("/var/www/html/public_docs/").normalize();
        Path resolvedPath = basePath.resolve(filename).normalize();
        
        if (!resolvedPath.startsWith(basePath)) {
            LOGGER.severe("¡Intento de Path Traversal bloqueado!");
            return;
        }

        try (FileInputStream fis = new FileInputStream(resolvedPath.toFile())) {
            LOGGER.info("Archivo leído de manera segura.");
        } catch (IOException e) {
            LOGGER.severe("Error de lectura: " + e.getMessage());
        }
    }
}