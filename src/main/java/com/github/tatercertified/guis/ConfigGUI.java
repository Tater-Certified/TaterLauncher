package com.github.tatercertified.guis;


import com.github.tatercertified.Config;
import com.github.tatercertified.themes.Dark;
import com.github.tatercertified.themes.Light;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URISyntaxException;

import static com.github.tatercertified.Config.getConfig;
import static com.github.tatercertified.guis.GUI.frame;
import static com.github.tatercertified.guis.GUI.initializeGui;

public class ConfigGUI {
    //Frames
    public static final JFrame settingframe = new JFrame();
    //Panels
    public static final JPanel themepanel = new JPanel();
    public static final JPanel maingui = new JPanel();
    //Tabs
    public static final JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
    //Labels
    public static final JLabel themelabel = new JLabel("Toggle Theme");
    public static final JLabel mainguilabel = new JLabel("Toggle GUI Style");
    //CheckBoxes
    public static final JCheckBox dark = new JCheckBox("Toggle Theme Modes");
    public static final JCheckBox legacygui = new JCheckBox("Toggle Legacy GUI");

    public static boolean colormodeVar;
    public static boolean legacyVar;

    public static void initializeConfigGui() {

        //Settings Frame
        settingframe.getContentPane().setLayout(new GridLayout(1, 1));
        settingframe.setTitle("Settings");
        settingframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingframe.setMinimumSize(new Dimension(500,500));
        settingframe.setIconImage(LoadingGUI.icon);
        JFrame.setDefaultLookAndFeelDecorated(false);

        //Theme Panel
        themepanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        themepanel.setLayout(new BoxLayout(themepanel, BoxLayout.PAGE_AXIS));
        themepanel.add(themelabel);
        themepanel.add(dark);

        //Main GUI
        maingui.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        maingui.setLayout(new BoxLayout(maingui, BoxLayout.PAGE_AXIS));
        maingui.add(mainguilabel);
        maingui.add(legacygui);

        //Add Tabs
        tabPane.addTab("Themes", themepanel);
        tabPane.addTab("Main GUI Themes", maingui);

        settingframe.getContentPane().add(tabPane);

        //Label Config
        themelabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 30));

        settingframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Setting is closing");
                getConfigSelection();
                saveConfig();
            }
        });

        //Set Checkmark Correctly
        dark.setSelected(getConfig().getBoolean("dark.darkgui"));

        settingframe.pack();

        //Action Listeners
        dark.addActionListener(e -> {
            if (dark.isSelected()) {
                try {
                    Dark.initdark();
                    System.out.println("Dark Mode Init");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (!dark.isSelected()) {
                try {
                    Light.initlight();
                    System.out.println("Light Mode Init");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        legacygui.addActionListener(e -> {
            if (legacygui.isSelected()) {
                initializeGui();
                NewMainGUI.mainframe.dispose();
            } else {
                try {
                    NewMainGUI.initMainGUI();
                } catch (URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
                frame.dispose();
            }
        });

    }
    public static void getConfigSelection() {
        colormodeVar = dark.isSelected();
        legacyVar = legacygui.isSelected();
    }
    public static void saveConfig() {
        getConfig().set("dark.darkgui", colormodeVar);
        getConfig().set("gui.legacy", legacyVar);

        try {
            getConfig().save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Config.getConfig();
    }
}
