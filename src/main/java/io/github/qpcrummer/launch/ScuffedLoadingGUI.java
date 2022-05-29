package io.github.qpcrummer.launch;

import javax.swing.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.LoadingGUI.icon;

public class ScuffedLoadingGUI {
    public static JFrame temploadingscreen = new JFrame();
    public static JPanel temploadingpanel = new JPanel();
    public static JTextField args = new JTextField();
    public static JTextField version = new JTextField();
    public static JFileChooser jvmselect = new JFileChooser();
    public static JFileChooser dirselect = new JFileChooser();
    public static JButton launch = new JButton("Launch Minecraft " + version.getText());

    public static JLabel argslabel = new JLabel("JVM Arguments");
    public static JLabel versionlabel = new JLabel("Minecraft Version");
    public static JLabel jvmlabel = new JLabel("Java.exe Path");
    public static JLabel dirlabel = new JLabel("Minecraft Directory");

    public static JSeparator sep1 = new JSeparator();
    public static JSeparator sep2 = new JSeparator();

    //Variables
    public static String argvar;
    public static String jvmvar;
    public static String vervar;
    public static String dirvar;

    public static void openTempLoadingScreen() {
        frame.setVisible(false);
        temploadingscreen.setVisible(true);
        temploadingscreen.setIconImage(icon);
        temploadingscreen.setMinimumSize(new Dimension(510, 900));

        temploadingscreen.add(temploadingpanel);
        temploadingpanel.setLayout(new BoxLayout(temploadingpanel, BoxLayout.PAGE_AXIS));

        temploadingpanel.add(jvmlabel);
        temploadingpanel.add(sep1);
        temploadingpanel.add(jvmselect);
        temploadingpanel.add(sep2);
        temploadingpanel.add(dirlabel);
        temploadingpanel.add(dirselect);
        temploadingpanel.add(versionlabel);
        temploadingpanel.add(version);
        temploadingpanel.add(argslabel);
        temploadingpanel.add(args);
        temploadingpanel.add(launch);



        temploadingscreen.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

          temploadingscreen.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    frame.setVisible(true);
                    System.out.println("Temp Launch Frame is closing");
                }
            });

          launch.addActionListener(e -> {
              argvar = args.getText();
              jvmvar = String.valueOf(jvmselect.getSelectedFile());
              vervar = version.getText();
              dirvar = String.valueOf(dirselect.getCurrentDirectory());
              System.out.println("Temp Launch Initiating");
              System.out.println("Launching Minecraft " + vervar +" using Java: " + jvmvar + " with a directory: " + dirvar + " and with the following args: " + argvar);
              launchMC();
          });
    }
    public static void launchMC() {
        String[] command = {jvmvar, argvar, "-Dlog4j2.formatMsgNoLookups=true", "-Dlog4j.configurationFile=assets/log_configs/client-1.12.xml", "-Djava.library.path=versions/"+vervar+"/natives", "-cp", "libraries/io/netty/netty-all/4.1.68.Final/netty-all-4.1.68.Final.jar;libraries/com/google/code/gson/gson/2.8.9/gson-2.8.9.jar;libraries/org/apache/httpcomponents/httpclient/4.5.13/httpclient-4.5.13.jar;libraries/org/apache/commons/commons-compress/1.21/commons-compress-1.21.jar;libraries/org/lwjgl/lwjgl-glfw/3.2.2/lwjgl-glfw-3.2.2.jar;libraries/ca/weblite/java-objc-bridge/1.0.0/java-objc-bridge-1.0.0.jar;libraries/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar;libraries/net/sf/jopt-simple/jopt-simple/5.0.4/jopt-simple-5.0.4.jar;libraries/commons-logging/commons-logging/1.2/commons-logging-1.2.jar;libraries/org/lwjgl/lwjgl-openal/3.2.2/lwjgl-openal-3.2.2.jar;libraries/org/slf4j/slf4j-api/1.8.0-beta4/slf4j-api-1.8.0-beta4.jar;libraries/com/mojang/logging/1.0.0/logging-1.0.0.jar;libraries/org/lwjgl/lwjgl/3.2.2/lwjgl-3.2.2.jar;libraries/org/lwjgl/lwjgl-opengl/3.2.2/lwjgl-opengl-3.2.2.jar;libraries/com/mojang/patchy/2.2.10/patchy-2.2.10.jar;libraries/org/apache/logging/log4j/log4j-core/2.17.0/log4j-core-2.17.0.jar;libraries/org/apache/logging/log4j/log4j-api/2.17.0/log4j-api-2.17.0.jar;libraries/org/lwjgl/lwjgl-stb/3.2.2/lwjgl-stb-3.2.2.jar;libraries/net/java/dev/jna/jna/5.10.0/jna-5.10.0.jar;libraries/com/mojang/text2speech/1.12.4/text2speech-1.12.4.jar;libraries/com/github/oshi/oshi-core/5.8.5/oshi-core-5.8.5.jar;libraries/org/lwjgl/lwjgl-jemalloc/3.2.2/lwjgl-jemalloc-3.2.2.jar;libraries/com/ibm/icu/icu4j/70.1/icu4j-70.1.jar;libraries/commons-io/commons-io/2.11.0/commons-io-2.11.0.jar;libraries/it/unimi/dsi/fastutil/8.5.6/fastutil-8.5.6.jar;libraries/commons-codec/commons-codec/1.15/commons-codec-1.15.jar;libraries/com/mojang/authlib/3.3.39/authlib-3.3.39.jar;libraries/com/mojang/brigadier/1.0.18/brigadier-1.0.18.jar;libraries/net/java/dev/jna/jna-platform/5.10.0/jna-platform-5.10.0.jar;libraries/com/mojang/javabridge/1.2.24/javabridge-1.2.24.jar;libraries/com/google/guava/guava/31.0.1-jre/guava-31.0.1-jre.jar;libraries/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar;libraries/com/mojang/blocklist/1.0.10/blocklist-1.0.10.jar;libraries/org/apache/logging/log4j/log4j-slf4j18-impl/2.17.0/log4j-slf4j18-impl-2.17.0.jar;libraries/org/lwjgl/lwjgl-tinyfd/3.2.2/lwjgl-tinyfd-3.2.2.jar;libraries/com/mojang/datafixerupper/4.1.27/datafixerupper-4.1.27.jar;libraries/org/lwjgl/lwjgl-jemalloc/3.2.2/lwjgl-jemalloc-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl-opengl/3.2.2/lwjgl-opengl-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl-stb/3.2.2/lwjgl-stb-3.2.2-natives-windows.jar;libraries/com/mojang/text2speech/1.12.4/text2speech-1.12.4-natives-windows.jar;libraries/org/lwjgl/lwjgl-glfw/3.2.2/lwjgl-glfw-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl-tinyfd/3.2.2/lwjgl-tinyfd-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl/3.2.2/lwjgl-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl-openal/3.2.2/lwjgl-openal-3.2.2-natives-windows.jar;versions/"+vervar+"/"+vervar+".jar", "net.minecraft.client.main.Main", "--username", "Name", "--version", vervar, "--gameDir", ".", "--assetsDir", "assets", "--assetIndex", "1.18", "--uuid", "0f28983a46ce33b1aed45cdc95bf44c3", "--accessToken", "00000000000000000000000000000000", "--clientId", "0000", "--xuid", "0000", "--userType", "mojang", "--versionType", "release"};
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.directory(new File(dirvar));
        try {
            Process process = builder.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }
}
