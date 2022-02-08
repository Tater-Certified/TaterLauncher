package io.github.qpcrummer;

import io.github.qpcrummer.guis.GUI;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;


public class Config {
    static String launcher1 = "path";
    static String minecraft1 = "path";
    static Properties prop = new Properties();

    public static void folder() {
        try {
            Files.createDirectory(Paths.get("TaterLauncher"));
        } catch (IOException ignored) {
        }
    }

    public static void loadConfig() {
        try (InputStream input = new FileInputStream("TaterLauncher/config.properties")) {
            prop.load(input);

            //get the properties value
            launcher1 = prop.getProperty("LauncherPath");
            minecraft1 = prop.getProperty("MineCraftPath");
            GUI.usernameVar = prop.getProperty("Username"); // Get the username from the GUI class
            GUI.passwordVar = prop.getProperty("Password"); // Get the password from the GUI class

            System.out.println(prop);
        } catch (IOException io) {
            io.printStackTrace();
        }

        System.out.println("Config was loaded");
    }
    public static void storeConfig() {

        try (OutputStream output = new FileOutputStream("TaterLauncher/config.properties")) {

            prop.store(output, null);
            //set the properties value
            prop.setProperty("LauncherPath", launcher1);
            prop.setProperty("MineCraftPath", minecraft1);
            prop.setProperty("Username", GUI.usernameVar); // Get the username from the GUI class
            prop.setProperty("Password", GUI.passwordVar); // Get the password from the GUI class
            // save properties to project root folder

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
        System.out.println("Config was stored");
    }
}
