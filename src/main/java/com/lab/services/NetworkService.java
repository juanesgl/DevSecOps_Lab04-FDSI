package com.lab.services;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class NetworkService {
    private static final Logger LOGGER = Logger.getLogger(NetworkService.class.getName());

    public void executeNetworkCheck(String targetIp) {
        // S-04 FIX: Usar ProcessBuilder separando comando y argumentos para evitar Inyección
        try {
            ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", targetIp);
            Process process = pb.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (reader.readLine() != null) {}
            process.waitFor();
            LOGGER.info("Diagnóstico de red seguro ejecutado.");
        } catch (Exception e) {
            LOGGER.severe("Fallo de sistema: " + e.getMessage());
        }
    }
}