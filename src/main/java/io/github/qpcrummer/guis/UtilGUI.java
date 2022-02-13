package io.github.qpcrummer.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.GUI.icon;

public class UtilGUI {
    //Frames
    public static final JFrame utilframe = new JFrame();
    //Panels
    public static final JPanel togglespanel = new JPanel();
    public static final JPanel appspanel = new JPanel();
    //Checkbox
    public static final JCheckBox  tatercape = new JCheckBox("TaterCape - Enables a Tater-styled cape");
    public static final JCheckBox tatershoulder = new JCheckBox("TaterPet - Enables a tater that sits on your shoulder");
    public static final JCheckBox resourceusage = new JCheckBox("Resource Graph - Enables a resource usage graph");
    public static final JCheckBox tatertube = new JCheckBox("TaterTube - Enables an ingame Youtube client");
    //Labels
    public static final JLabel toggles = new JLabel("Toggles");
    public static final JLabel apps = new JLabel("Applications");
    public static final JLabel noapps = new JLabel("Apps are currently WIP");
    //Tabs
    public static final JTabbedPane tabs = new JTabbedPane(JTabbedPane.TOP);

    public static void initializeutil() {
        //Util Frame
        utilframe.getContentPane().setLayout(new GridLayout(1, 1));
        utilframe.setTitle("Utilities");
        utilframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        utilframe.pack();
        utilframe.setMinimumSize(new Dimension(500,500));
        utilframe.setIconImage(icon);

        //Add tabs
        tabs.addTab("Toggles",togglespanel);
        tabs.addTab("Apps",appspanel);

        utilframe.getContentPane().add(tabs);

        //Toggles Panel
        togglespanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        togglespanel.setLayout(new BoxLayout(togglespanel, BoxLayout.PAGE_AXIS));
        togglespanel.add(toggles);
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
                System.out.println("Util is closing");
                frame.setVisible(true);
            }
        });

    }
}
