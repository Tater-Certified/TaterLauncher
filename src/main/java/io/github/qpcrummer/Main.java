package io.github.qpcrummer;

import io.github.qpcrummer.guis.GUI;

public class Main {
    public static void main(String[] args) {
        Config.folder();
        Config.loadConfig();
        GUI.initializeGui();
    }
}
