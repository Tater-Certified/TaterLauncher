package io.github.qpcrummer;

import io.github.qpcrummer.guis.GUI;
import io.github.qpcrummer.guis.LoadingGUI;

import java.io.IOException;

public class Main {
    public static LoadingGUI loadingGUI;

    public static void main(String[] args) throws IOException {
        loadingGUI = new LoadingGUI();

        GUI.initializeGui();
    }
}
