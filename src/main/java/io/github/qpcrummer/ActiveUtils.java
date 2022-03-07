package io.github.qpcrummer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import static io.github.qpcrummer.guis.UtilGUI.*;

public class ActiveUtils {
    static Properties prop = new Properties();

    public static void loadActiveUtils() {
        try (InputStream input = new FileInputStream("TaterLauncher/active_utils.properties")) {
            Files.createFile(Path.of("config.properties"));
            //get the properties value
            rpcVar = prop.getProperty("DiscordRPC");
            capeVar = prop.getProperty("Tater Cape");
            shoulderVar = prop.getProperty("Tater Shoulder");
            resourceVar = prop.getProperty("Resource Usage");
            tubeVar = prop.getProperty("Tater Tube");
            prop.load(input);
            System.out.println(prop);
        } catch (IOException ignored) {
        }
        System.out.println("Utils were loaded");
    }

    public static void storeActiveUtils() {
        try (OutputStream output = new FileOutputStream("TaterLauncher/active_utils.properties")) {

            //set the properties value
            prop.setProperty("DiscordRPC", rpcVar);
            prop.setProperty("Tater Cape", capeVar);
            prop.setProperty("Tater Shoulder", shoulderVar);
            prop.setProperty("Resource Usage", resourceVar);
            prop.setProperty("Tater Tube", tubeVar);
            // save properties to project root folder
            prop.store(output, null);

            //set the properties value
            System.out.println(prop);
        } catch (IOException io) {
            io.printStackTrace();
        }
        System.out.println("Utils were stored");
    }
}
