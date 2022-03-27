package io.github.qpcrummer.guis;

import io.github.qpcrummer.Config;
import io.github.qpcrummer.themes.Dark;
import io.github.qpcrummer.themes.Light;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import static io.github.qpcrummer.Config.CONFIG;
import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.LoadingGUI.icon;

public class ConfigGUI {
    //Frames
    public static final JFrame settingframe = new JFrame();
    //Panels
    public static final JPanel authpanel = new JPanel();
    public static final JPanel themepanel = new JPanel();
    //Tabs
    public static final JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
    //TextBoxes
    public static final JTextField username = new JTextField();
    public static final JTextField password = new JTextField();
    //Labels
    public static final JLabel user = new JLabel("Insert MineCraft Username");
    public static final JLabel pass = new JLabel("Insert MineCraft Password");
    public static final JLabel themelabel = new JLabel("Toggle Theme");
    //CheckBoxes
    public static final JCheckBox dark = new JCheckBox("Toggle Theme Modes");

    // Public Variable for storing the username and password
    public static String usernameVar = username.getText();
    public static String passwordVar = password.getText();

    public static boolean colormodeVar;

    public static void initializeConfigGui() {

        //Settings Frame
        settingframe.getContentPane().setLayout(new GridLayout(1, 1));
        settingframe.setTitle("Settings");
        settingframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingframe.setMinimumSize(new Dimension(500,500));
        settingframe.setIconImage(icon);
        JFrame.setDefaultLookAndFeelDecorated(false);

        //AuthPanel
        authpanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        authpanel.setLayout(new BoxLayout(authpanel, BoxLayout.PAGE_AXIS));
        authpanel.add(user);
        authpanel.add(username);
        username.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,
                        username.getPreferredSize().height));
        authpanel.add(pass);
        authpanel.add(password);
        password.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,
                        password.getPreferredSize().height));

        //Theme Panel
        themepanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        themepanel.setLayout(new BoxLayout(themepanel, BoxLayout.PAGE_AXIS));
        themepanel.add(themelabel);
        themepanel.add(dark);

        //Add Tabs
        tabPane.addTab("MC Auth", authpanel);
        tabPane.addTab("Themes", themepanel);

        settingframe.getContentPane().add(tabPane);

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

        settingframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Setting is closing");
                getSelection();
                saveUtils();
                frame.setVisible(true);
            }
        });

        //Settings Fill-in Blanks
        username.setBounds(200, 30, 400, 40);
        password.setBounds(200, 80, 400, 40);
        user.setBounds(20, 30,180,40);
        pass.setBounds(20,80,180,40);

        //Label Config
        user.setFont(new Font("Serif", Font.BOLD, 15));
        pass.setFont(new Font("Serif", Font.BOLD, 15));
        themelabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 30));

        settingframe.pack();
    }
    static void getSelection() {
        colormodeVar = dark.isSelected();
    }
    static void saveUtils() {
        CONFIG.set("dark.darkgui", colormodeVar);

        try {
            CONFIG.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Config.reloadConfig();
    }
}
