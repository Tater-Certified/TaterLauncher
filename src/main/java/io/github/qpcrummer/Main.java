package io.github.qpcrummer;

import io.github.qpcrummer.guis.GUI;
import io.github.qpcrummer.themes.Light;

public class Main {
    public static void main(String[] args) {
        Config.folder();
        Config.loadConfig();
        GUI.initializeGui();
        Light.initlight();
    }
}
