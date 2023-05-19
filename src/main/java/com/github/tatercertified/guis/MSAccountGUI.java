package com.github.tatercertified.guis;

import com.github.tatercertified.auth.MSAuth;

import javax.swing.*;
import java.awt.*;

public class MSAccountGUI {
    //Frames
    private static final JFrame mainframe = new JFrame("Microsoft Account");
    //Panels
    public static final JPanel authpanel = new JPanel();
    //Labels
    public static final JLabel user = new JLabel("Insert Microsoft Email");
    public static final JLabel pass = new JLabel("Insert Microsoft Password");
    //TextBoxes
    public static final JTextField username = new JTextField();
    public static final JTextField password = new JTextField();
    //Buttons
    public static final JButton auth = new JButton("Sign In");

    public static void openMSAccountGUI() {
        mainframe.setVisible(false);
        mainframe.add(authpanel);
        mainframe.setMinimumSize(new Dimension(500,500));
        mainframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        //AuthPanel
        authpanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        authpanel.setLayout(new BoxLayout(authpanel, BoxLayout.PAGE_AXIS));

        authpanel.add(user);
        authpanel.add(username);
        username.setMaximumSize(new Dimension(Integer.MAX_VALUE, username.getPreferredSize().height));

        authpanel.add(pass);
        authpanel.add(password);
        password.setMaximumSize(new Dimension(Integer.MAX_VALUE, password.getPreferredSize().height));

        authpanel.add(auth);
        auth.setMaximumSize(new Dimension(Integer.MAX_VALUE, auth.getPreferredSize().height));

        //Settings Fill-in Blanks
        username.setBounds(200, 30, 400, 40);
        password.setBounds(200, 80, 400, 40);
        user.setBounds(20, 30,180,40);
        pass.setBounds(20,80,180,40);

        //Label Config
        user.setFont(new Font("Serif", Font.BOLD, 15));
        pass.setFont(new Font("Serif", Font.BOLD, 15));
        auth.setFont(new Font("Serif", Font.BOLD, 15));

        //Action Listeners
        auth.addActionListener((e) -> {
            auth.setText("Authenticating...");
            System.out.println(username.getText() + ", " + password.getText());
            try {
                MSAuth.loginMicrosoft(username.getText(), password.getText());
            } catch (Exception ex) {
                auth.setText("Authentication Failed");
                throw new RuntimeException(ex);
            }
            auth.setText("Authenticated");
        });

        mainframe.setVisible(true);
    }
}
