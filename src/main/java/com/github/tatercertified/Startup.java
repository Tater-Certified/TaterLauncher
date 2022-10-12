package com.github.tatercertified;

import com.github.tatercertified.guis.GUI;
import com.github.tatercertified.guis.NewMainGUI;
import com.github.tatercertified.themes.Dark;
import com.github.tatercertified.themes.Light;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.github.tatercertified.guis.ConfigGUI.colormodeVar;
import static com.github.tatercertified.guis.ConfigGUI.legacyVar;

public class Startup {
    public static void prep() throws IOException {
        System.out.println("Creating files");
        //Main folder
        try {
            Files.createDirectory(Paths.get("TaterLauncher"));
        } catch (IOException ignored) {
        }
        //Other folders & files
        try {
            Files.createDirectory(Paths.get("TaterLauncher/java_profiles"));
            Files.createDirectory(Paths.get("TaterLauncher/game_profiles"));
            Files.createDirectory(Paths.get("TaterLauncher/apps"));
            Files.createDirectory(Paths.get("TaterLauncher/accounts"));
            if (!Files.exists(Paths.get("TaterLauncher/profiles.json"))) {
                Files.createFile(Paths.get("TaterLauncher/profiles.json"));
            }
        } catch (IOException ignored) {
        }
    }
    //Check to see if things are toggled
    public static void check() {
        if (Config.getConfig().getBoolean("hooks.discord-rpc")) {
            try {
                DiscordRP.start();
                System.out.println("RPC Loaded As TRUE From Config");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        if (Config.getConfig().getBoolean("dark.darkgui")) {
            try {
                Config.getConfig().set("dark.darkgui", true);
                colormodeVar = true;
                Dark.initdark();
                System.out.println("Dark Mode Loaded As TRUE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!Config.getConfig().getBoolean("dark.darkgui")) {
            try {
                Config.getConfig().set("dark.darkgui", false);
                colormodeVar = false;
                Light.initlight();
                System.out.println("Light Mode Loaded As TRUE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (Config.getConfig().getBoolean("gui.legacy")) {
            Config.getConfig().set("gui.legacy", true);
            legacyVar = true;
            GUI.initializeGui();
            System.out.println("Legacy GUI Loaded As TRUE From Config");
        } else {
            Config.getConfig().set("gui.legacy", false);
            legacyVar = false;
            try {
                NewMainGUI.initMainGUI();
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Legacy GUI Loaded As FALSE From Config");
        }
    }
}