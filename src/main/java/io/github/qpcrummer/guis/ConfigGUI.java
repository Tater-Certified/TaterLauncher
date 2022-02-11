package io.github.qpcrummer.guis;

import io.github.qpcrummer.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.GUI.icon;

public class ConfigGUI {
    public static final JFrame settingframe = new JFrame();
    private static final JPanel settingpanel = new JPanel();
    public static final JTextField username = new JTextField();
    public static final JTextField password = new JTextField();
    public static final JLabel user = new JLabel("Insert MineCraft Username");
    private static final JLabel pass = new JLabel("Insert MineCraft Password");
    // Public Variable for storing the username and password

    public static String usernameVar = username.getText();
    public static String passwordVar = password.getText();

    public static void initializeconfigui() {
        //Settings Frame
        settingpanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        settingpanel.setBackground(new Color(98,184,245));
        settingframe.add(settingpanel, BorderLayout.CENTER);
        settingframe.setTitle("Settings");
        settingframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingframe.pack();
        settingframe.setMinimumSize(new Dimension(500,500));
        settingframe.setIconImage(icon);
        settingframe.setLayout(null);

        settingframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Config.storeConfig();
                System.out.println("Setting is closing");
                frame.setVisible(true);
            }
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
    }
}
