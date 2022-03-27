package io.github.qpcrummer;

import io.github.qpcrummer.guis.GUI;
import io.github.qpcrummer.guis.LoadingGUI;

public class Main {
    public static LoadingGUI loadingGUI;

    public static void main(String[] args) {
        Config.loadConfig();

        if (Config.CONFIG.getBoolean("loading.screen")) {
            try {
                loadingGUI = new LoadingGUI();
                System.out.println("Loading Screen Loaded As TRUE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!Config.CONFIG.getBoolean("loading.screen")) {
            try {
                Startup.check();
                System.out.println("Loading Screen Loaded As FALSE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        GUI.initializeGui();
    }
}
