package io.github.qpcrummer.guis;

import io.github.qpcrummer.Config;
import io.github.qpcrummer.DiscordRP;
import org.simpleyaml.configuration.file.YamlFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.GUI.icon;

public class UtilGUI {
    private static final YamlFile CONFIG = Config.CONFIG;
    //Frames
    public static final JFrame utilframe = new JFrame();
    //Panels
    public static final JPanel togglespanel = new JPanel();
    public static final JPanel appspanel = new JPanel();
    //Checkbox
    public static JCheckBox tatercape = new JCheckBox("TaterCape - Enables a Tater-styled cape");
    public static JCheckBox tatershoulder = new JCheckBox("TaterPet - Enables a tater that sits on your shoulder");
    public static JCheckBox resourceusage = new JCheckBox("Resource Graph - Enables a resource usage graph");
    public static JCheckBox tatertube = new JCheckBox("TaterTube - Enables an in-game Youtube client");
    public static JCheckBox rpc = new JCheckBox("TaterRPC - Discord Rich Presence (Can be slow sometimes)");
    //Labels
    public static final JLabel toggles = new JLabel("Toggles");
    public static final JLabel apps = new JLabel("Applications");
    public static final JLabel noapps = new JLabel("Apps are currently WIP");
    //Tabs
    public static final JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    //Toggle Variables
    public static boolean rpcVar = rpc.isSelected();
    public static boolean capeVar = tatercape.isSelected();
    public static boolean shoulderVar = tatershoulder.isSelected();
    public static boolean resourceVar = resourceusage.isSelected();
    public static boolean tubeVar = tatertube.isSelected();

    public static void initializeUtil() {
        //Util Frame
        utilframe.getContentPane().setLayout(new GridLayout(1, 1));
        utilframe.setTitle("Utilities");
        utilframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        utilframe.setMinimumSize(new Dimension(500,500));
        utilframe.setIconImage(icon);
        JFrame.setDefaultLookAndFeelDecorated(false);

        //Add tabs
        tabs.addTab("Toggles",togglespanel);
        tabs.addTab("Apps",appspanel);

        utilframe.getContentPane().add(tabs);

        //Toggles Panel
        togglespanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        togglespanel.setLayout(new BoxLayout(togglespanel, BoxLayout.PAGE_AXIS));
        togglespanel.add(toggles);
        togglespanel.add(rpc);
        togglespanel.add(tatercape);
        togglespanel.add(tatershoulder);
        togglespanel.add(resourceusage);
        togglespanel.add(tatertube);

        //Apps Panel
        appspanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        appspanel.setLayout(new BoxLayout(appspanel, BoxLayout.PAGE_AXIS));
        appspanel.add(apps);
        appspanel.add(noapps);

        //Label Config
        toggles.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));
        apps.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));
        noapps.setFont(new Font("Serif", Font.BOLD, 15));

        //Window Listener
        utilframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                getSelection();
                saveUtils();
                System.out.println("Util is closing");
                frame.setVisible(true);
            }
        });
        utilframe.pack();

        rpc.addActionListener(e -> {
            if (rpc.isSelected()) {
                try {
                    DiscordRP.reset();
                    System.out.println("RPC Init");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (!rpc.isSelected()) {
                try {
                    DiscordRP.shutdown();
                    System.out.println("RPC Stop");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private static void getSelection() {
        rpcVar = rpc.isSelected();
        capeVar = tatercape.isSelected();
        shoulderVar = tatershoulder.isSelected();
        resourceVar = resourceusage.isSelected();
        tubeVar = tatertube.isSelected();
    }

    private static void saveUtils() {
        CONFIG.set("tater.cape", capeVar);
        CONFIG.set("tater.shoulder", shoulderVar);
        CONFIG.set("tater.tube", tubeVar);
        CONFIG.set("hooks.discord-rpc", rpcVar);
        CONFIG.set("debug.resource-usage", resourceVar);

        try {
            CONFIG.save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Config.reloadConfig();
    }
}
