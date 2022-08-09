package com.github.tatercertified;

import com.github.tatercertified.guis.LoadingGUI;

public class Main {
    public static LoadingGUI loadingGUI;

    public static void main(String[] args) {
        //Set Default Look and Feel
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        Config.loadConfig();

        if (Config.getConfig().getBoolean("loading.screen")) {
            try {
                loadingGUI = new LoadingGUI();
                System.out.println("Loading Screen Loaded As TRUE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (!Config.getConfig().getBoolean("loading.screen")) {
            try {
                Startup.check();
                System.out.println("Loading Screen Loaded As FALSE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
