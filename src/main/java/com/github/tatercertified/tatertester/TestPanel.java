package com.github.tatercertified.tatertester;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JFrame {
    private final JPanel panel = new JPanel();
    private final JButton button = new JButton("Run Test");
    private final JTextArea textArea = new JTextArea("Output");
    public void initTestPanel() {
        add(panel);
        setMinimumSize(new Dimension(1400,500));
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        panel.add(button);
        panel.add(textArea);
        textArea.setMinimumSize(new Dimension(1400, 400));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        setVisible(true);

        button.addActionListener(e -> {
            textArea.setText(DownloadMCV2.getAllMojankVersions(false).toString());
            DownloadMCV2.downloadMojankJar("1.19.4", "C:\\Users\\qpcru\\Downloads\\Test", "1-19-4-client");
            textArea.updateUI();
        });

        pack();
    }
}
