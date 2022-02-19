package io.github.qpcrummer.guis;

import io.github.qpcrummer.launch.MinecraftLaunch;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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
    public static ImageIcon utilitater;

    static {
        try {
            utilitater = new ImageIcon(new URL("https://github.com/QPCrummer/TaterLauncherResources/blob/main/Utilitater.png?raw=true"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
    public static ImageIcon settingtater;

    static {
        try {
            settingtater = new ImageIcon(new URL("https://github.com/QPCrummer/TaterLauncherResources/blob/main/SettingsTater.png?raw=true"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    //Frames
    public static final JFrame frame = new JFrame();
    //Panels
    public static final JPanel panel = new JPanel();
    //Sub Panels
    public static final JPanel buttonsubpanel = new JPanel();
    public static final JPanel topsubpanel = new JPanel();
    public static final JPanel leftsubpanel = new JPanel();
    public static final JPanel rightsubpanel = new JPanel();
    //Buttons
    public static final JButton startbutton = new JButton("Start Minecraft");
    public static final JButton settingsbutton = new JButton("Settings",settingtater);
    public static final JButton versionbutton = new JButton("Version");
    public static final JButton utilsbutton = new JButton("Utils",utilitater);
    public static final JButton javabutton = new JButton("Java Configuration");
    //Labels
    private static final JLabel menupic = new JLabel(background);
    public static final JLabel launchername = new JLabel("Tater Launcher");

    public static void initializeGui() {

        //Main Frame
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tater Launcher");
        frame.setMinimumSize(new Dimension(510,510));
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setIconImage(icon);
        frame.getContentPane().add(panel);
        JFrame.setDefaultLookAndFeelDecorated(false);

        //Panel Settings
        panel.setLayout(new BorderLayout());
        panel.add(menupic, BorderLayout.CENTER);
        panel.add(buttonsubpanel, BorderLayout.PAGE_END);
        panel.add(leftsubpanel, BorderLayout.LINE_START);
        panel.add(rightsubpanel, BorderLayout.LINE_END);
        panel.add(topsubpanel, BorderLayout.PAGE_START);


        buttonsubpanel.add(versionbutton);
        buttonsubpanel.add(startbutton);
        buttonsubpanel.add(javabutton);

        topsubpanel.add(settingsbutton);
        topsubpanel.add(launchername);
        topsubpanel.add(utilsbutton);


        //Label settings
        launchername.setFont(new Font("Serif", Font.BOLD, 40));

        //start button settings
        startbutton.setPreferredSize(new Dimension(150,50));
        startbutton.addActionListener(e -> {
            startbutton.setText("Minecraft is starting!");
            MinecraftLaunch.launchmc();
        });
        //settings button settings
        settingsbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
        settingsbutton.setHorizontalTextPosition(SwingConstants.CENTER);
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
            try {
                JavaGUI.initializejavaui();
            } catch (UnsupportedLookAndFeelException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (InstantiationException ex) {
                ex.printStackTrace();
            } catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });

        //Util button settings
        utilsbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
        utilsbutton.setHorizontalTextPosition(SwingConstants.CENTER);
        utilsbutton.addActionListener(e -> {
            utilframe.setVisible(true);
            System.out.println("Util Button Was Pressed");
            UtilGUI.initializeutil();
        });
        frame.pack();
    }
}