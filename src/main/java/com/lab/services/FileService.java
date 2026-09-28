package com.lab.services;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.Logger;

public class FileService {
    private static final Logger LOGGER = Logger.getLogger(FileService.class.getName());

    public FileService() {
        LOGGER.info("FileService inicializado.");
    }

    public void viewDocument(String filename) {
        String fullPath = "/var/www/html/public_docs/" + filename;
        LOGGER.info("Leyendo archivo en: " + fullPath);
        File file = new File(fullPath);
        try (FileInputStream fis = new FileInputStream(file)) {
            int content;
            while ((content = fis.read()) != -1) {
                System.out.print((char) content);
            }
        } catch (IOException e) {
            LOGGER.severe("Error de lectura: " + e.getMessage());
        }
    }
}
