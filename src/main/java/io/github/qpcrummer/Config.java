package io.github.qpcrummer;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

public class Config {
    private static final YamlFile YML_FILE = new YamlFile("TaterLauncher/config.yml");
    private static final String TL_LOGO =
            """
                     _______    _            _                            _              \s
                    |__   __|  | |          | |                          | |             \s
                       | | __ _| |_ ___ _ __| |     __ _ _   _ _ __   ___| |__   ___ _ __\s
                       | |/ _` | __/ _ \\ '__| |    / _` | | | | '_ \\ / __| '_ \\ / _ \\ '__|
                       | | (_| | ||  __/ |  | |___| (_| | |_| | | | | (__| | | |  __/ |  \s
                       |_|\\__,_|\\__\\___|_|  |______\\__,_|\\__,_|_| |_|\\___|_| |_|\\___|_|""".indent(1)
            ;

    public static void loadConfig() {
        try {
            if (!YML_FILE.exists()) {
                System.out.println("Config file not found, creating new one...");
                YML_FILE.createNewFile(true);
                System.out.println("Config file created!");
            } else {
                System.out.println("Loading config file...");
                YML_FILE.loadWithComments();
                System.out.println("Config file loaded!");
            }
        } catch (final Exception e) {
            System.out.println("Error while loading config: " + e.getMessage());
        }

        YML_FILE.setComment("tater", TL_LOGO);
        YML_FILE.addDefault("tater.cape", false);
        YML_FILE.setComment("tater.cape", "Use custom cape to show Tater Launcher loyalty");
        YML_FILE.addDefault("tater.shoulder", false);
        YML_FILE.setComment("tater.shoulder", "Adds a Tater Pet on your shoulder");
        YML_FILE.addDefault("tater.tube", false);
        YML_FILE.setComment("tater.tube", "Integrated YouTube client");
        YML_FILE.addDefault("hooks.discord-rpc", true);
        YML_FILE.setComment("hooks.discord-rpc", "Shows Tater Launcher in Discord Activity");
        YML_FILE.addDefault("debug.resource-usage", false);
        YML_FILE.setComment("debug.resource-usage", "Debugging tool to show resource utilization of app");
        YML_FILE.addDefault("dark.darkgui", false);
        YML_FILE.setComment("dark.darkgui", "Enables Dark Mode");

        try {
            YML_FILE.save();
        } catch (IOException e) {
            System.out.println("Error saving config: " + e.getMessage());
        }
    }

    public static YamlFile getConfig() {
        return YML_FILE;
    }

    public static void reloadConfig() {
        Config.CONFIG = getConfig();
    }

    public static YamlFile CONFIG = Config.getConfig();
}
