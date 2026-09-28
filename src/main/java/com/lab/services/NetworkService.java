package com.lab.services;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.logging.Logger;

public class NetworkService {
    private static final Logger LOGGER = Logger.getLogger(NetworkService.class.getName());

    public NetworkService() {
        LOGGER.info("NetworkService cargado.");
    }

    public void executeNetworkCheck(String targetIp) {
        String cmd = "ping -c 3 " + targetIp;
        LOGGER.info("Diagnóstico de red: " + cmd);
        try {
            Process process = Runtime.getRuntime().exec(cmd);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            process.waitFor();
        } catch (Exception e) {
            LOGGER.severe("Fallo de sistema: " + e.getMessage());
        }
    }
}
