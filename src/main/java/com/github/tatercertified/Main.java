package com.github.tatercertified;

import com.github.tatercertified.guis.LoadingGUI;
import com.github.tatercertified.tatertester.TestPanel;
import net.fabricmc.installer.util.MetaHandler;

import java.io.IOException;

public class Main {
    public static LoadingGUI loadingGUI;

    public static MetaHandler LOADER_META = new MetaHandler("/v2/versions/loader");
    public static MetaHandler GAME_VERSION_META = new MetaHandler("/v2/versions/game");

    public static void main(String[] args) {
        // TODO TESTING
        boolean testing = false;
        if (testing) {
            TestPanel panel = new TestPanel();
            panel.initTestPanel();
            return;
        }
        // TODO TESTING

        //Set Default Look and Feel
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        Config.loadConfig();

        try {
            GAME_VERSION_META.load();
            LOADER_META.load();
        } catch (IOException e){
            e.printStackTrace();
        }

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
                Startup.prep();
                Startup.check();
                System.out.println("Loading Screen Loaded As FALSE From Config");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
