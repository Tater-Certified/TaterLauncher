package io.github.qpcrummer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

import static io.github.qpcrummer.guis.ConfigGUI.usernameVar;
import static io.github.qpcrummer.guis.ConfigGUI.passwordVar;

public class Config {
    static Properties prop = new Properties();

    public static void loadConfig() {
        try (InputStream input = new FileInputStream("TaterLauncher/config.properties")) {
            Files.createFile(Path.of("config.properties"));
            //get the properties value
            usernameVar = prop.getProperty("Username"); // Get the username from the GUI class
            passwordVar = prop.getProperty("Password"); // Get the password from the GUI class
            prop.load(input);
            System.out.println(prop);
        } catch (IOException ignored) {
        }
        System.out.println("Config was loaded");
    }

    public static void storeConfig() {
        try (OutputStream output = new FileOutputStream("TaterLauncher/config.properties")) {

            //set the properties value
            prop.setProperty("Username", usernameVar); // Get the username from the GUI class
            prop.setProperty("Password", passwordVar); // Get the password from the GUI class
            // save properties to project root folder
            prop.store(output, null);

            //Text Box Testing
            System.out.println(usernameVar);
            System.out.println(passwordVar);
            //set the properties value
            System.out.println(prop);
        } catch (IOException io) {
            io.printStackTrace();
        }
        System.out.println("Config was stored");
    }
}
