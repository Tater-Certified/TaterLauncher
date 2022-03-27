package io.github.qpcrummer.guis;

import io.github.qpcrummer.Config;
import io.github.qpcrummer.Startup;
import io.github.qpcrummer.guis.panels.CustomProgressBarPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class LoadingGUI extends JFrame {

    public static BufferedImage icon;
    static {
        try {
            icon = ImageIO.read(Objects.requireNonNull(GUI.class.getClassLoader().getResource("assets/TaterMC.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    public static final int SCREEN_HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

    JPanel contentPane;

    public LoadingGUI() {
        setIconImage(icon);
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(SCREEN_WIDTH / 3, SCREEN_HEIGHT / 3);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setLocationRelativeTo(null);

        int pbWidth = (int) (getWidth() / 1.1);
        int pbHeight = getHeight() / 24;
        int pbX = (getWidth() - pbWidth) / 2;
        int pbY = getHeight() - (pbHeight * 2);

        JLabel progressBarOutline = new JLabel();
        progressBarOutline.setBounds(pbX, pbY - 10, pbWidth, pbHeight + 20);
        ImageIcon pgOutline = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("assets/progressbaroutline.png")));
        pgOutline = CustomProgressBarPanel.resizeIcon(pgOutline, pbWidth + 20, pbHeight);
        progressBarOutline.setIcon(pgOutline);
        contentPane.add(progressBarOutline);

        CustomProgressBarPanel progressBar = new CustomProgressBarPanel(pbWidth, pbHeight);
        progressBar.setBounds(pbX, pbY, pbWidth, pbHeight);
        contentPane.add(progressBar);

        JLabel splashIcon = new JLabel("");
        splashIcon.setSize(getWidth(), getHeight());
        ImageIcon backgroundImg = new ImageIcon(Objects.requireNonNull(getClass().getClassLoader().getResource("assets/background.png")));
        backgroundImg = CustomProgressBarPanel.resizeIcon(backgroundImg, splashIcon.getWidth(), splashIcon.getHeight());
        splashIcon.setIcon(backgroundImg);
        contentPane.add(splashIcon);

        setVisible(true);


        progressBar.setProgress(0);
        try {
            Startup.prep();
        } catch (IOException ignored) {}
        smoothIncrease(progressBar, 25);
        sleep();
        smoothIncrease(progressBar, 50);
        Startup.check();
        sleep();
        smoothIncrease(progressBar, 75);
        sleep();
        smoothIncrease(progressBar, 100);


    }

    private static void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException ignored) {

        }
    }

    private static void smoothIncrease(CustomProgressBarPanel pb, int to) {
        int i = pb.getProgress();
        while (i <= to) {
            pb.setProgress(i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i += 1;
        }
    }
}