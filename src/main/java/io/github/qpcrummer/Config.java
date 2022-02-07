package io.github.qpcrummer;

import io.github.qpcrummer.guis.GUI;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import java.io.FileOutputStream;
import java.io.OutputStream;

import static io.github.qpcrummer.guis.GUI.username;

public class Config {
    static String launcher1 = "path";
    static String minecraft1 = "path";

    public static void folder() throws IOException {
        try {
            Files.createDirectory(Paths.get("TaterLauncher"));
        } catch (IOException e) {
        }
    }

    public static void initializeConfig() {
        try (OutputStream output = new FileOutputStream("TaterLauncher/config.properties")) {

            Properties prop = new Properties();

             //set the properties value
            prop.setProperty("LauncherPath", launcher1);
            prop.setProperty("MineCraftPath", minecraft1);
            prop.setProperty("Username", GUI.userVar); // Get the username from the GUI class
            prop.setProperty("Password", GUI.passVar); // Get the password from the GUI class

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }
        System.out.println("Config was loaded");
    }
}
