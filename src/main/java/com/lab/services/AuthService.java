package com.lab.services;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Logger;

public class AuthService {
    private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());
    private static final String AWS_API_KEY = "AKIAIOSFODNN7EXAMPLE";

    public AuthService() {
        LOGGER.info("AuthService inicializado.");
    }

    public void registerUser(String username, String password) {
        LOGGER.info("Iniciando registro para: " + username);
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            String hash = Base64.getEncoder().encodeToString(md.digest());
            LOGGER.info("Hash guardado: " + hash);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.severe("Error criptográfico: " + e.getMessage());
        }
    }

    public void authenticateWithAWS() {
        LOGGER.info("Conectando AWS con llave: " + AWS_API_KEY);
    }
}
