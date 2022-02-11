package io.github.qpcrummer.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.GUI.icon;

public class VersionGUI {
    public static final JFrame versionframe = new JFrame();
    private static final JPanel versionpanel = new JPanel();

    public static void initializever() {
        //Version Frame
        versionpanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        versionpanel.setBackground(new Color(98, 184, 245));
        versionframe.add(versionpanel);
        versionframe.setTitle("Version Selector");
        versionframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        versionframe.pack();
        versionframe.setMinimumSize(new Dimension(500,500));
        versionframe.setIconImage(icon);

        versionframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Version is closing");
                frame.setVisible(true);
            }
        });

    }
}
