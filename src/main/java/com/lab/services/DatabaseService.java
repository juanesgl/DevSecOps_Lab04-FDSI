package com.lab.services;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;

public class DatabaseService {
    private static final Logger LOGGER = Logger.getLogger(DatabaseService.class.getName());
    private final String dbUrl = "jdbc:h2:mem:testdb";

    public DatabaseService() {
        LOGGER.info("DatabaseService inicializado.");
    }

    public void fetchUserData(String username) {
        String query = "SELECT id, username, email FROM users WHERE username = '" + username + "'";
        LOGGER.info("Ejecutando consulta: " + query);
        try (Connection conn = DriverManager.getConnection(dbUrl, "sa", "");
             Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                LOGGER.info("Usuario: " + rs.getString("username"));
            }
        } catch (Exception e) {
            LOGGER.warning("Error DB: " + e.getMessage());
        }
    }
}
