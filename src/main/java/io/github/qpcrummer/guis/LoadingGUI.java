package io.github.qpcrummer.guis;

import io.github.qpcrummer.Config;
import io.github.qpcrummer.Startup;
import io.github.qpcrummer.guis.panels.CustomProgressBarPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.io.IOException;

public class LoadingGUI extends JFrame {
    JPanel contentPane;

    public LoadingGUI() {
        setUndecorated(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(GUI.SCREEN_WIDTH / 3, GUI.SCREEN_HEIGHT / 3);
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
        ImageIcon pgOutline = new ImageIcon(getClass().getClassLoader().getResource("assets/progressbaroutline.png"));
        pgOutline = CustomProgressBarPanel.resizeIcon(pgOutline, pbWidth + 20, pbHeight);
        progressBarOutline.setIcon(pgOutline);
        contentPane.add(progressBarOutline);

        CustomProgressBarPanel progressBar = new CustomProgressBarPanel(pbWidth, pbHeight);
        progressBar.setBounds(pbX, pbY, pbWidth, pbHeight);
        contentPane.add(progressBar);

        JLabel splashIcon = new JLabel("");
        splashIcon.setSize(getWidth(), getHeight());
        ImageIcon backgroundImg = new ImageIcon(getClass().getClassLoader().getResource("assets/background.png"));
        backgroundImg = CustomProgressBarPanel.resizeIcon(backgroundImg, splashIcon.getWidth(), splashIcon.getHeight());
        splashIcon.setIcon(backgroundImg);
        contentPane.add(splashIcon);

        setVisible(true);


        progressBar.setProgress(0);
        try {
            Startup.prep();
        } catch (IOException ignored) {}
        smoothIncrease(progressBar, 25);
        Config.loadConfig();
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