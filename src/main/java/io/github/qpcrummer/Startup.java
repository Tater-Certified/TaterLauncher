package io.github.qpcrummer;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Startup {
    public static void prep() throws IOException {
        System.out.println("Creating files");
        //Main folder
        try {
            Files.createDirectory(Paths.get("TaterLauncher"));
        } catch (IOException ignored) {
        }
        //Other folders
        try {
            Files.createDirectory(Paths.get("TaterLauncher/assets"));
            Files.createDirectory(Paths.get("TaterLauncher/java_profiles"));
            Files.createDirectory(Paths.get("TaterLauncher/game_profiles"));
            Files.createDirectory(Paths.get("TaterLauncher/apps"));
        } catch (IOException ignored) {
        }
        //Download Assets
        String[] assetList = {"SettingsTater.png", "TaterMC%20V3%20RC4.png", "TaterMC.png", "Utilitater.png"};
        for (int i = 0; i < assetList.length; i++) {
            URL url = new URL("https://github.com/QPCrummer/TaterLauncherResources/blob/main/" + assetList[i] + "?raw=true");
            InputStream in = new BufferedInputStream(url.openStream());
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int n;
            while (-1 != (n = in.read(buf))) {
                out.write(buf, 0, n);
            }
            out.close();
            in.close();
            byte[] response = out.toByteArray();
            //Save Assets
            FileOutputStream fos = new FileOutputStream("TaterLauncher/assets/" + assetList[i]);
            fos.write(response);
            fos.close();
        }
    }
}