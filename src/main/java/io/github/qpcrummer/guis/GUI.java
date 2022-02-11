package io.github.qpcrummer.guis;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static io.github.qpcrummer.guis.ConfigGUI.settingframe;
import static io.github.qpcrummer.guis.JavaGUI.javaframe;
import static io.github.qpcrummer.guis.UtilGUI.utilframe;
import static io.github.qpcrummer.guis.VersionGUI.versionframe;

public class GUI {

    public static Image icon;
    static {
        try {
            icon = ImageIO.read(new URL("https://github.com/QPCrummer/TaterLauncherResources/blob/main/TaterMC.png?raw=true"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ImageIcon background;

    static {
        try {
            background = new ImageIcon(new URL("https://github.com/QPCrummer/TaterLauncherResources/blob/main/TaterMC%20V3%20RC4.png?raw=true"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //Frames
    public static final JFrame frame = new JFrame();
    //Panels
    private static final JPanel panel = new JPanel(new BorderLayout());
    //Sub Panels
    private static final JPanel buttonsubpanel = new JPanel();
    private static final JPanel leftsubpanel = new JPanel();
    private static final JPanel rightsubpanel = new JPanel();
    private static final JPanel topsubpanel = new JPanel();
    //Buttons
    private static final JButton startbutton = new JButton("Start Minecraft");
    private static final JButton settingsbutton = new JButton("Settings");
    private static final JButton versionbutton = new JButton("Version");
    private static final JButton utilsbutton = new JButton();
    private static final JButton javabutton = new JButton("Java Configuration");
    //Labels
    private static final JLabel menupic = new JLabel(background);
    private static final JLabel launchername = new JLabel("Tater Launcher");

    public static void initializeGui() {

        //Main Frame
        frame.add(panel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tater Launcher");
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(510,510));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setIconImage(icon);

        //Panel Settings
        panel.add(menupic);
        panel.setBackground(new Color(153, 170, 181));

        buttonsubpanel.add(versionbutton);
        buttonsubpanel.add(startbutton);
        buttonsubpanel.add(javabutton);
        topsubpanel.add(settingsbutton);
        topsubpanel.add(launchername);
        topsubpanel.add(utilsbutton);

        panel.add(buttonsubpanel, BorderLayout.PAGE_END);
        panel.add(leftsubpanel, BorderLayout.LINE_START);
        panel.add(rightsubpanel, BorderLayout.LINE_END);
        panel.add(topsubpanel, BorderLayout.PAGE_START);

        buttonsubpanel.setBackground(new Color(44, 47, 51));
        leftsubpanel.setBackground(new Color(35, 39, 42));
        rightsubpanel.setBackground(new Color(35, 39, 42));
        topsubpanel.setBackground(new Color(35, 39, 42));

        //start button settings
        startbutton.setPreferredSize(new Dimension(150,50));
        startbutton.addActionListener(e -> {
            startbutton.setText("Minecraft is starting!");
            String[] command = {"E:\\Minecraft\\Java\\Corretto 17\\bin\\javaw.exe\" -Xmx700M -Xss1M -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32M -Dlog4j2.formatMsgNoLookups=true -Dlog4j.configurationFile=assets\\log_configs\\client-1.12.xml \"-Djava.library.path=versions\\1.18.1\\natives\"   \"-cp\" \"libraries\\com\\mojang\\blocklist\\1.0.6\\blocklist-1.0.6.jar;libraries\\com\\mojang\\patchy\\2.1.6\\patchy-2.1.6.jar;libraries\\com\\github\\oshi\\oshi-core\\5.8.2\\oshi-core-5.8.2.jar;libraries\\net\\java\\dev\\jna\\jna\\5.9.0\\jna-5.9.0.jar;libraries\\net\\java\\dev\\jna\\jna-platform\\5.9.0\\jna-platform-5.9.0.jar;libraries\\org\\slf4j\\slf4j-api\\1.8.0-beta4\\slf4j-api-1.8.0-beta4.jar;libraries\\org\\apache\\logging\\log4j\\log4j-slf4j18-impl\\2.14.1\\log4j-slf4j18-impl-2.14.1.jar;libraries\\com\\ibm\\icu\\icu4j\\69.1\\icu4j-69.1.jar;libraries\\com\\mojang\\javabridge\\1.2.24\\javabridge-1.2.24.jar;libraries\\net\\sf\\jopt-simple\\jopt-simple\\5.0.4\\jopt-simple-5.0.4.jar;libraries\\io\\netty\\netty-all\\4.1.68.Final\\netty-all-4.1.68.Final.jar;libraries\\com\\google\\guava\\failureaccess\\1.0.1\\failureaccess-1.0.1.jar;libraries\\com\\google\\guava\\guava\\31.0.1-jre\\guava-31.0.1-jre.jar;libraries\\org\\apache\\commons\\commons-lang3\\3.12.0\\commons-lang3-3.12.0.jar;libraries\\commons-io\\commons-io\\2.11.0\\commons-io-2.11.0.jar;libraries\\commons-codec\\commons-codec\\1.15\\commons-codec-1.15.jar;libraries\\com\\mojang\\brigadier\\1.0.18\\brigadier-1.0.18.jar;libraries\\com\\mojang\\datafixerupper\\4.0.26\\datafixerupper-4.0.26.jar;libraries\\com\\google\\code\\gson\\gson\\2.8.8\\gson-2.8.8.jar;libraries\\com\\mojang\\authlib\\3.2.38\\authlib-3.2.38.jar;libraries\\org\\apache\\commons\\commons-compress\\1.21\\commons-compress-1.21.jar;libraries\\org\\apache\\httpcomponents\\httpclient\\4.5.13\\httpclient-4.5.13.jar;libraries\\commons-logging\\commons-logging\\1.2\\commons-logging-1.2.jar;libraries\\org\\apache\\httpcomponents\\httpcore\\4.4.14\\httpcore-4.4.14.jar;libraries\\it\\unimi\\dsi\\fastutil\\8.5.6\\fastutil-8.5.6.jar;libraries\\org\\apache\\logging\\log4j\\log4j-api\\2.14.1\\log4j-api-2.14.1.jar;libraries\\org\\apache\\logging\\log4j\\log4j-core\\2.14.1\\log4j-core-2.14.1.jar;libraries\\org\\lwjgl\\lwjgl\\3.2.2\\lwjgl-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.2.2\\lwjgl-jemalloc-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-openal\\3.2.2\\lwjgl-openal-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-opengl\\3.2.2\\lwjgl-opengl-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-glfw\\3.2.2\\lwjgl-glfw-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-stb\\3.2.2\\lwjgl-stb-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.2.2\\lwjgl-tinyfd-3.2.2.jar;libraries\\com\\mojang\\text2speech\\1.11.3\\text2speech-1.11.3.jar;versions\\1.18.1\\1.18.1.jar\" net.minecraft.client.main.Main --username Name --version 1.18.1 --gameDir . --assetsDir assets --assetIndex 1.18 --uuid 0f28983a46ce33b1aed45cdc95bf44c3 --accessToken 00000000000000000000000000000000 --clientId 0000 --xuid 0000 --userType mojang --versionType release"};
            ProcessBuilder builder = new ProcessBuilder(command);
            builder.directory(new File("C:\\Users\\qpcru\\Downloads"));
            try {
                Process process = builder.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        });
        //settings button settings
        settingsbutton.addActionListener(e -> {
            System.out.println("Settings Was Pressed");
            settingframe.setVisible(true);
            ConfigGUI.initializeconfigui();
        });

        //version button settings
        versionbutton.setPreferredSize(new Dimension(150,50));
        versionbutton.addActionListener(e -> {
            System.out.println("Version Button Was Pressed");
            versionframe.setVisible(true);
            VersionGUI.initializever();
        });

        //Java button settings
        javabutton.setPreferredSize(new Dimension(150,50));
        javabutton.addActionListener(e -> {
            javaframe.setVisible(true);
            System.out.println("Java Button Was Pressed");
            JavaGUI.initializejavaui();
        });

        //Util button settings
        utilsbutton.addActionListener(e -> {
            utilframe.setVisible(true);
            System.out.println("Util Button Was Pressed");
            UtilGUI.initializeutil();
        });
    }
}