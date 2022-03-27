package io.github.qpcrummer;

import io.github.qpcrummer.themes.Dark;
import io.github.qpcrummer.themes.Light;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.github.qpcrummer.guis.ConfigGUI.colormodeVar;

public class Startup {
    public static void prep() throws IOException {
        System.out.println("Creating files");
        //Main folder
        try {
            Files.createDirectory(Paths.get("TaterLauncher"));
        } catch (IOException ignored) {
        }
        //Other folders
        try {
            Files.createDirectory(Paths.get("TaterLauncher/java_profiles"));
            Files.createDirectory(Paths.get("TaterLauncher/game_profiles"));
            Files.createDirectory(Paths.get("TaterLauncher/apps"));
            Files.createDirectory(Paths.get("TaterLauncher/accounts"));
        } catch (IOException ignored) {
        }
    }
    //Check to see if things are toggled
    public static void check() {
        if (Config.CONFIG.getBoolean("hooks.discord-rpc")) {
            try {
                DiscordRP.reset();
                System.out.println("RPC Loaded As TRUE From Config");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (Config.CONFIG.getBoolean("dark.darkgui")) {
            try {
                Config.CONFIG.set("dark.darkgui", true);
                colormodeVar = true;
                Dark.initdark();
                System.out.println("Dark Mode Loaded As TRUE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!Config.CONFIG.getBoolean("dark.darkgui")) {
            try {
                Config.CONFIG.set("dark.darkgui", false);
                colormodeVar = false;
                Light.initlight();
                System.out.println("Light Mode Loaded As TRUE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}