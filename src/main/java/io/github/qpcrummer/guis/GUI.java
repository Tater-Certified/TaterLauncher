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
    private static final JPanel panel = new JPanel(new BorderLayout());
    //Sub Panels
    private static final JPanel buttonsubpanel = new JPanel();
    private static final JPanel leftsubpanel = new JPanel();
    private static final JPanel rightsubpanel = new JPanel();
    private static final JPanel topsubpanel = new JPanel();
    //Buttons
    private static final JButton startbutton = new JButton("Start Minecraft");
    private static final JButton settingsbutton = new JButton("Settings",settingtater);
    private static final JButton versionbutton = new JButton("Version");
    private static final JButton utilsbutton = new JButton("Utils",utilitater);
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
        //Label settings
        launchername.setFont(new Font("Serif", Font.BOLD, 40));
        launchername.setForeground(new Color(153, 170, 181));

        //start button settings
        startbutton.setPreferredSize(new Dimension(150,50));
        startbutton.setForeground(Color.WHITE);
        startbutton.setBackground(new Color(0, 140, 0));
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
            JavaGUI.initializejavaui();
        });

        //Util button settings
        utilsbutton.setVerticalTextPosition(SwingConstants.BOTTOM);
        utilsbutton.setHorizontalTextPosition(SwingConstants.CENTER);
        utilsbutton.addActionListener(e -> {
            utilframe.setVisible(true);
            System.out.println("Util Button Was Pressed");
            UtilGUI.initializeutil();
        });
    }
}