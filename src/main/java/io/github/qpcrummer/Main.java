package io.github.qpcrummer;

import io.github.qpcrummer.guis.GUI;
import io.github.qpcrummer.themes.Light;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Startup.prep();
        Config.loadConfig();
        GUI.initializeGui();
        Light.initlight();
    }
}
