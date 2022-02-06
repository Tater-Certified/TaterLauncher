package io.github.qpcrummer;

import java.io.IOException;
import java.util.Properties;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Config {

    public static void main(String[] args) {

        try (OutputStream output = new FileOutputStream("path/to/config.properties")) {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty("LauncherPath", "");
            prop.setProperty("JavaPath", "");
            prop.setProperty("MineCraftPath", "");
            prop.setProperty("Version", "");
            prop.setProperty("Username", "");
            prop.setProperty("MineCraftPat", "");

            prop.setProperty("MinimumRam", "");
            prop.setProperty("MaximumRam", "");
            prop.setProperty("GarbageCollector", "");
            prop.setProperty("OtherFlags", "");

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }

    }
}
