package com.github.tatercertified.guis.panels;

import javax.swing.*;
import java.awt.*;

public class CustomProgressBarPanel extends JPanel {
    private int progress = 0;
    private int width;
    private int height;

    public CustomProgressBarPanel(int width, int height) {
        this.width = width;
        this.height = height;

        JLabel progressBar = new JLabel();
        progressBar.setSize(getWidth(), getHeight());
        ImageIcon image = new ImageIcon(getClass().getClassLoader().getResource("assets/progressbar.png"));
        image = resizeIcon(image, width, height);
        progressBar.setIcon(image);
        add(progressBar);
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        setSize(((progress * width) / 100), height);
        repaint();
    }

    public static ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        Image image = icon.getImage();
        Image newImg = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }
}