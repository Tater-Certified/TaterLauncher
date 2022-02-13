package io.github.qpcrummer.guis;

import io.github.qpcrummer.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.GUI.icon;

public class ConfigGUI {
    //Frames
    public static final JFrame settingframe = new JFrame();
    //Panels
    private static final JPanel authpanel = new JPanel();
    //Tabs
    public static final JTabbedPane tabPane = new JTabbedPane(JTabbedPane.TOP);
    //TextBoxes
    public static final JTextField username = new JTextField();
    public static final JTextField password = new JTextField();
    //Labels
    public static final JLabel user = new JLabel("Insert MineCraft Username");
    private static final JLabel pass = new JLabel("Insert MineCraft Password");
    //Dividers
    public static final JSeparator divider1 = new JSeparator();

    // Public Variable for storing the username and password
    public static String usernameVar = username.getText();
    public static String passwordVar = password.getText();

    public static void initializeconfigui() {
        //Settings Frame
        settingframe.getContentPane().setLayout(new GridLayout(1, 1));
        settingframe.setTitle("Settings");
        settingframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        settingframe.pack();
        settingframe.setMinimumSize(new Dimension(500,500));
        settingframe.setIconImage(icon);

        //AuthPanel
        authpanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        authpanel.setBackground(new Color(98,184,245));
        authpanel.setLayout(new BoxLayout(authpanel, BoxLayout.PAGE_AXIS));
        authpanel.add(user);
        authpanel.add(username);
        authpanel.add(divider1);
        authpanel.add(pass);
        authpanel.add(password);

        //Add Tabs
        tabPane.addTab("MC Auth", authpanel);

        settingframe.getContentPane().add(tabPane);

        settingframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                Config.storeConfig();
                System.out.println("Setting is closing");
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
    }
}
