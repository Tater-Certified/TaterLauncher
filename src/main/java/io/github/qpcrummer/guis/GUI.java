package io.github.qpcrummer.guis;

import io.github.qpcrummer.Config;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class GUI {

    public static Image icon;
    static {
        try {
            icon = ImageIO.read(new URL("https://github.com/QPCrummer/TaterLauncherResources/blob/main/TaterMC.png?raw=true"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static final JFrame frame = new JFrame();
    private static final JPanel panel = new JPanel();
    private static final JPanel versionpanel = new JPanel();
    private static final JButton startbutton = new JButton("Start Minecraft");
    private static final JButton settingsbutton = new JButton("Settings");
    private static final JButton version = new JButton("Version");
    private static final JLabel namelabel = new JLabel("Tater Launcher");
    private static final JFrame versionframe = new JFrame();
    private static final JFrame settingframe = new JFrame();
    private static final JPanel settingpanel = new JPanel();
    public static final JTextField username = new JTextField();
    private static final JTextField password = new JTextField();
    public static final JLabel user = new JLabel("Insert MineCraft Username");
    private static final JLabel pass = new JLabel("Insert MineCraft Password");

    // Public Variable for storing the username and password
    public static String usernameVar;
    public static String passwordVar;

    public static void initializeGui() {

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(panel, BorderLayout.CENTER);
        frame.add(namelabel, BorderLayout.NORTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tater Launcher");
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(300,80));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setIconImage(icon);

        //Version Frame
        versionpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        versionpanel.setBackground(new Color(98, 184, 245));
        versionframe.add(versionpanel, BorderLayout.CENTER);
        versionframe.setTitle("Version Selector");
        versionframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        versionframe.pack();
        versionframe.setVisible(false);
        versionframe.setMinimumSize(new Dimension(500,500));
        versionframe.setIconImage(icon);

        //Settings Frame
        settingpanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        settingpanel.setBackground(new Color(98,184,245));
        settingframe.add(settingpanel, BorderLayout.CENTER);
        settingframe.setTitle("Settings");
        settingframe.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        settingframe.pack();
        settingframe.setVisible(false);
        settingframe.setMinimumSize(new Dimension(500,500));
        settingframe.setIconImage(icon);
        settingframe.setLayout(null);

        //Window reopener
        versionframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Version is closing");
                frame.setVisible(true);
            }
        });

        settingframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                //Config.storeConfig();
                System.out.println("Setting is closing");
                frame.setVisible(true);
            }
        });

        //start button settings
        startbutton.setMaximumSize(new Dimension(300,80));
        panel.add(startbutton);
        startbutton.addActionListener(e -> {
            startbutton.setText("Minecraft is starting!");
            String[] command = {"E:\\Minecraft\\Java\\Corretto 17\\bin\\javaw.exe\" -Xmx700M -Xss1M -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32M -Dlog4j2.formatMsgNoLookups=true -Dlog4j.configurationFile=assets\\log_configs\\client-1.12.xml \"-Djava.library.path=versions\\1.18.1\\natives\"   \"-cp\" \"libraries\\com\\mojang\\blocklist\\1.0.6\\blocklist-1.0.6.jar;libraries\\com\\mojang\\patchy\\2.1.6\\patchy-2.1.6.jar;libraries\\com\\github\\oshi\\oshi-core\\5.8.2\\oshi-core-5.8.2.jar;libraries\\net\\java\\dev\\jna\\jna\\5.9.0\\jna-5.9.0.jar;libraries\\net\\java\\dev\\jna\\jna-platform\\5.9.0\\jna-platform-5.9.0.jar;libraries\\org\\slf4j\\slf4j-api\\1.8.0-beta4\\slf4j-api-1.8.0-beta4.jar;libraries\\org\\apache\\logging\\log4j\\log4j-slf4j18-impl\\2.14.1\\log4j-slf4j18-impl-2.14.1.jar;libraries\\com\\ibm\\icu\\icu4j\\69.1\\icu4j-69.1.jar;libraries\\com\\mojang\\javabridge\\1.2.24\\javabridge-1.2.24.jar;libraries\\net\\sf\\jopt-simple\\jopt-simple\\5.0.4\\jopt-simple-5.0.4.jar;libraries\\io\\netty\\netty-all\\4.1.68.Final\\netty-all-4.1.68.Final.jar;libraries\\com\\google\\guava\\failureaccess\\1.0.1\\failureaccess-1.0.1.jar;libraries\\com\\google\\guava\\guava\\31.0.1-jre\\guava-31.0.1-jre.jar;libraries\\org\\apache\\commons\\commons-lang3\\3.12.0\\commons-lang3-3.12.0.jar;libraries\\commons-io\\commons-io\\2.11.0\\commons-io-2.11.0.jar;libraries\\commons-codec\\commons-codec\\1.15\\commons-codec-1.15.jar;libraries\\com\\mojang\\brigadier\\1.0.18\\brigadier-1.0.18.jar;libraries\\com\\mojang\\datafixerupper\\4.0.26\\datafixerupper-4.0.26.jar;libraries\\com\\google\\code\\gson\\gson\\2.8.8\\gson-2.8.8.jar;libraries\\com\\mojang\\authlib\\3.2.38\\authlib-3.2.38.jar;libraries\\org\\apache\\commons\\commons-compress\\1.21\\commons-compress-1.21.jar;libraries\\org\\apache\\httpcomponents\\httpclient\\4.5.13\\httpclient-4.5.13.jar;libraries\\commons-logging\\commons-logging\\1.2\\commons-logging-1.2.jar;libraries\\org\\apache\\httpcomponents\\httpcore\\4.4.14\\httpcore-4.4.14.jar;libraries\\it\\unimi\\dsi\\fastutil\\8.5.6\\fastutil-8.5.6.jar;libraries\\org\\apache\\logging\\log4j\\log4j-api\\2.14.1\\log4j-api-2.14.1.jar;libraries\\org\\apache\\logging\\log4j\\log4j-core\\2.14.1\\log4j-core-2.14.1.jar;libraries\\org\\lwjgl\\lwjgl\\3.2.2\\lwjgl-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.2.2\\lwjgl-jemalloc-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-openal\\3.2.2\\lwjgl-openal-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-opengl\\3.2.2\\lwjgl-opengl-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-glfw\\3.2.2\\lwjgl-glfw-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-stb\\3.2.2\\lwjgl-stb-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.2.2\\lwjgl-tinyfd-3.2.2.jar;libraries\\com\\mojang\\text2speech\\1.11.3\\text2speech-1.11.3.jar;versions\\1.18.1\\1.18.1.jar\" net.minecraft.client.main.Main --username Name --version 1.18.1 --gameDir . --assetsDir assets --assetIndex 1.18 --uuid 0f28983a46ce33b1aed45cdc95bf44c3 --accessToken 00000000000000000000000000000000 --clientId 0000 --xuid 0000 --userType mojang --versionType release"};
            ProcessBuilder builder = new ProcessBuilder(command);
            builder = builder.directory(new File("C:\\Users\\qpcru\\Downloads"));
            try {
                Process process = builder.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        });
        //settings button settings
        startbutton.setMaximumSize(new Dimension(300,80));
        panel.add(settingsbutton);
        settingsbutton.addActionListener(e -> {
            System.out.println("Button Was Pressed");
            settingframe.setVisible(true);
            frame.setVisible(false);
        });

        //version button settings
        version.setMaximumSize(new Dimension(300,80));
        panel.add(version);
        version.addActionListener(e -> {
            System.out.println("Version Button Was Pressed");
            versionframe.setVisible(true);
            frame.setVisible(false);
        });

        //Settings Fill-in Blanks
        settingframe.add(username);
        username.setBounds(200, 30, 400, 40);
        settingframe.add(password);
        password.setBounds(200, 80, 400, 40);
        settingframe.add(user);
        settingframe.add(pass);
        user.setBounds(20, 30,180,40);
        pass.setBounds(20,80,180,40);

        username.addActionListener(e -> {
            System.out.println("Username Inserted");
            usernameVar = username.getText();
        });
        password.addActionListener(e -> passwordVar = password.getText());


    }
}