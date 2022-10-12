package com.github.tatercertified.guis;

import com.github.tatercertified.guis.profiles.VersionGUI;
import com.github.tatercertified.launch.ScuffedLoadingGUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class NewMainGUI {
    // Frames
    public static JFrame mainframe = new JFrame();

    //Panels
    public static JPanel mainpanel = new JPanel();
    public static JPanel leftsidebar = new JPanel();
    public static JPanel topbar = new JPanel();
    public static JPanel newspanel = new JPanel();
    public static JPanel middlebar = new JPanel();
    public static JPanel empty = new JPanel();

    //Images
    public static BufferedImage backgroundimg;
    public static ImageIcon utilitater;
    static {
        utilitater = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("assets/Utilitater.png")));
    }
    public static ImageIcon settingtater;

    static {
        settingtater = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("assets/SettingsTater.png")));
    }
    public static ImageIcon microtater;

    static {
        microtater = new ImageIcon(Objects.requireNonNull(GUI.class.getClassLoader().getResource("assets/MicroTater.png")));
    }

    //Labels
    public static JLabel background = new JLabel();

    //Buttons
    public static final JButton startbutton = new JButton("Start Minecraft");
    public static final JButton settingsbutton = new JButton("Settings",settingtater);
    public static final JButton profilebutton = new JButton("Profiles");
    public static final JButton utilsbutton = new JButton("Utils",utilitater);
    public static final JButton javabutton = new JButton("Java Configuration");
    public static final JButton microsoftbutton = new JButton("Microsoft Account", microtater);

    public static void initMainGUI() throws URISyntaxException {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        mainframe.setPreferredSize(new Dimension(screenSize));
        mainframe.setSize(mainframe.getPreferredSize());
        mainframe.setTitle("Tater Launcher");
        mainframe.setIconImage(LoadingGUI.icon);
        mainframe.add(mainpanel);
        mainframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        mainpanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        mainpanel.setBackground(new Color(48, 48, 48));

        Path icon = Path.of(Objects.requireNonNull(GUI.class.getClassLoader().getResource("assets/TaterMC%20V3%20RC4.png")).toURI());

        try {
            assert false;
            backgroundimg = ImageIO.read(Files.newInputStream(icon));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension framesize = mainframe.getSize();
        background.setPreferredSize(new Dimension((int) (framesize.width*0.58), (int) (framesize.height*0.55)));
        background.setSize(background.getPreferredSize());
        Image scaledImg = backgroundimg.getScaledInstance(background.getWidth(), background.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon backgroundicon = new ImageIcon(scaledImg);
        background.setIcon(backgroundicon);

        c.weightx = 0.1;
        c.weighty = 1.0;
        c.fill = GridBagConstraints.BOTH;

        //leftsliderbar
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 4;
        leftsidebar.setBackground(new Color(30,30,30));
        mainpanel.add(leftsidebar, c);
        leftsidebar.setLayout(new GridBagLayout());
        GridBagConstraints leftc = new GridBagConstraints();
        leftc.fill = GridBagConstraints.HORIZONTAL;
        leftc.weightx = 1.0;
        leftc.weighty = 0.1;

        leftc.gridx = 0;
        leftc.gridy = 0;
        microsoftbutton.setBackground(new Color(30,30,30));
        microsoftbutton.setForeground(Color.WHITE);
        microsoftbutton.setBorder(BorderFactory.createLineBorder(new Color(30,30,30),0));
        microsoftbutton.setFocusPainted(false);
        leftsidebar.add(microsoftbutton, leftc);

        leftc.weightx = 1.0;
        leftc.weighty = 0.7;
        leftc.gridx = 0;
        leftc.gridy = 1;
        empty.setBackground(new Color(255, 0, 0, 0));
        leftsidebar.add(empty, leftc);

        leftc.weightx = 1.0;
        leftc.weighty = 0.1;
        leftc.gridx = 0;
        leftc.gridy = 2;
        utilsbutton.setBackground(new Color(30,30,30));
        utilsbutton.setForeground(Color.WHITE);
        utilsbutton.setBorder(BorderFactory.createLineBorder(new Color(30,30,30),0));
        utilsbutton.setFocusPainted(false);
        leftsidebar.add(utilsbutton, leftc);

        utilsbutton.addActionListener(event -> {
            UtilGUI.utilframe.setVisible(true);
            System.out.println("Util Button Was Pressed");
            UtilGUI.initializeUtil();
        });

        leftc.weightx = 1.0;
        leftc.weighty = 0.1;
        leftc.gridx = 0;
        leftc.gridy = 3;
        settingsbutton.setBackground(new Color(30,30,30));
        settingsbutton.setForeground(Color.WHITE);
        settingsbutton.setBorder(BorderFactory.createLineBorder(new Color(30,30,30),0));
        settingsbutton.setFocusPainted(false);
        leftsidebar.add(settingsbutton, leftc);

        settingsbutton.addActionListener(event -> {
            System.out.println("Settings Was Pressed");
            ConfigGUI.settingframe.setVisible(true);
            ConfigGUI.initializeConfigGui();
        });


        //topbar
        c.weightx = 0.9;
        c.weighty = 0.15;
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        topbar.setBackground(new Color(30,30,30));
        mainpanel.add(topbar, c);

        //newspanel
        c.weighty = 0.75;
        c.gridx = 1;
        c.gridy = 3;
        c.gridwidth = 1;
        c.gridheight = 1;
        newspanel.setBackground(new Color(46, 46, 46));
        mainpanel.add(newspanel, c);

        //middlebar
        c.weighty = 0.15;
        c.gridx = 1;
        c.gridy = 2;
        c.gridwidth = 1;
        c.gridheight = 1;
        middlebar.setBackground(new Color(30,30,30));
        mainpanel.add(middlebar, c);
        middlebar.setLayout(new GridLayout(1,3,600,0));
        Border middlebarborder = BorderFactory.createMatteBorder(10,0,10,0, new Color(30,30,30));
        middlebar.setBorder(middlebarborder);

        middlebar.add(profilebutton);
        profilebutton.setVerticalAlignment(JButton.CENTER);
        profilebutton.setHorizontalAlignment(JButton.CENTER);
        profilebutton.setBackground(new Color(0, 140, 0));
        profilebutton.setForeground(Color.WHITE);
        profilebutton.setFont(new Font("Arial", Font.PLAIN, 30));
        profilebutton.setFocusPainted(false);

        profilebutton.addActionListener(event -> {
            System.out.println("Version Button Was Pressed");
            VersionGUI.versionframe.setVisible(true);
            VersionGUI.initializever();
        });

        middlebar.add(startbutton);
        startbutton.setVerticalAlignment(JButton.CENTER);
        startbutton.setHorizontalAlignment(JButton.CENTER);
        startbutton.setBackground(new Color(0, 140, 0));
        startbutton.setForeground(Color.WHITE);
        startbutton.setFont(new Font("Arial", Font.PLAIN, 30));
        startbutton.setFocusPainted(false);

        startbutton.addActionListener(event -> {
            //Temp. removed for alternative launch method
            //startbutton.setText("Minecraft is starting!");
            ScuffedLoadingGUI.openTempLoadingScreen();
        });

        middlebar.add(javabutton);
        javabutton.setVerticalAlignment(JButton.CENTER);
        javabutton.setHorizontalAlignment(JButton.CENTER);
        javabutton.setBackground(new Color(0, 140, 0));
        javabutton.setForeground(Color.WHITE);
        javabutton.setFont(new Font("Arial", Font.PLAIN, 30));
        javabutton.setFocusPainted(false);

        javabutton.addActionListener(event -> {
            JavaGUI.javaframe.setVisible(true);
            System.out.println("Java Button Was Pressed");
            try {
                JavaGUI.initializejavaui();
            } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });

        //backgroundimg
        c.weighty = 0.35;
        c.gridx = 1;
        c.gridy = 1;
        c.gridwidth = 1;
        c.gridheight = 1;
        background.setHorizontalAlignment(JLabel.CENTER);
        mainpanel.add(background, c);




        mainframe.setVisible(true);
        mainframe.pack();
    }

}
