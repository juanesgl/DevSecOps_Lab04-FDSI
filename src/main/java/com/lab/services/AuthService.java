package com.lab.services;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.logging.Logger;

public class AuthService {
    private static final Logger LOGGER = Logger.getLogger(AuthService.class.getName());
    // S-01 FIX: Usar variable de entorno en lugar de credencial quemada
    private static final String AWS_API_KEY = System.getenv("AWS_API_KEY");

    public void registerUser(String username, String password) {
        try {
            // S-02 FIX: Cambiar MD5 por SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());
            String hash = Base64.getEncoder().encodeToString(md.digest());
            LOGGER.info("Hash seguro generado.");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.severe("Error criptográfico.");
        }
    }
    public void authenticateWithAWS() {
        LOGGER.info("Conectando con credenciales seguras de entorno.");
    }
}