package com.github.tatercertified;

import com.github.tatercertified.guis.LoadingGUI;
import net.fabricmc.installer.util.MetaHandler;
import net.fabricmc.installer.util.Reference;

import java.io.IOException;

public class Main {
    public static LoadingGUI loadingGUI;

    public static MetaHandler LOADER_META = new MetaHandler(Reference.getMetaServerEndpoint("v2/versions/loader"));
    public static MetaHandler GAME_VERSION_META = new MetaHandler(Reference.getMetaServerEndpoint("v2/versions/game"));

    public static void main(String[] args) {
        //Set Default Look and Feel
        //UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        //LoaderInstaller.LaunchGUI();

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
