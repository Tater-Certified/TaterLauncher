package io.github.qpcrummer;

import io.github.qpcrummer.guis.GUI;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GUI.startLoadingScreen();

        GUI.initializeGui();
    }
}
