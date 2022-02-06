package io.github.qpcrummer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Config {
    public static void folder() throws IOException {
        try {
            Files.createDirectory(Paths.get("TaterLauncher"));
        } catch (IOException e) {
        }
    }

    public static void initializeconfig() {
       // try (OutputStream output = new FileOutputStream("path/to/config.properties")) {

            //Properties prop = new Properties();

            // set the properties value
            //prop.setProperty("LauncherPath", "");
            //prop.setProperty("JavaPath", "");
            //prop.setProperty("MineCraftPath", "");
            //prop.setProperty("Version", "");
            //prop.setProperty("Username", "");

            //prop.setProperty("MinimumRam", "");
            //prop.setProperty("MaximumRam", "");
           // prop.setProperty("GarbageCollector", "");
            //prop.setProperty("OtherFlags", "");

            // save properties to project root folder
            //prop.store(output, null);

            //System.out.println(prop);

        //} catch (IOException io) {
            //io.printStackTrace();
        //}
        System.out.println("Config was loaded");
    }
}
