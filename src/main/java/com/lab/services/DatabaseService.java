package com.lab.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Logger;

public class DatabaseService {
    private static final Logger LOGGER = Logger.getLogger(DatabaseService.class.getName());
    private final String dbUrl = "jdbc:h2:mem:testdb";

    public void fetchUserData(String username) {
        // S-03 FIX: Consulta parametrizada con PreparedStatement contra SQLi
        String query = "SELECT id, username, email FROM users WHERE username = ?";
        try (Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                LOGGER.info("Usuario encontrado de forma segura.");
            }
        } catch (Exception e) {
            LOGGER.warning("Error DB: " + e.getMessage());
        }
    }
}