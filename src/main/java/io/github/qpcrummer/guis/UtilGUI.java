package io.github.qpcrummer.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.GUI.icon;

public class UtilGUI {
    public static final JFrame utilframe = new JFrame();

    public static void initializeutil() {
        //Util Frame
        utilframe.setTitle("Utilities");
        utilframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        utilframe.pack();
        utilframe.setMinimumSize(new Dimension(500,500));
        utilframe.setIconImage(icon);

        utilframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Util is closing");
                frame.setVisible(true);
            }
        });

    }
}
