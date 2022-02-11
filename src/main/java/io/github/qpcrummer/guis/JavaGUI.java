package io.github.qpcrummer.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.GUI.icon;

public class JavaGUI {
    public static final JFrame javaframe = new JFrame();

    public static void initializejavaui() {
        //Java Frame
        javaframe.setTitle("Java Settings");
        javaframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        javaframe.pack();
        javaframe.setMinimumSize(new Dimension(500,500));
        javaframe.setIconImage(icon);


        javaframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Java Frame is closing");
                frame.setVisible(true);
            }
        });

    }
}
