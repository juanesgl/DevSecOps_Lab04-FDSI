package com.lab;
import com.lab.services.*;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        LOGGER.info("Iniciando Application Services v0.1 (Versión Modular)...");
        AuthService authService = new AuthService();
        DatabaseService dbService = new DatabaseService();
        NetworkService netService = new NetworkService();
        FileService fileService = new FileService();
        
        authService.registerUser("admin", "supersecret123");
        authService.authenticateWithAWS();
        dbService.fetchUserData("admin");
        netService.executeNetworkCheck("127.0.0.1");
        fileService.viewDocument("report.pdf");
        LOGGER.info("Ejecución de servicios finalizada.");
    }
}
