package com.github.tatercertified.guis.profiles;

import com.github.tatercertified.GameProfile;
import com.github.tatercertified.guis.LoadingGUI;
import com.github.tatercertified.guis.panels.ProfileEditor;
import com.github.tatercertified.guis.panels.ProfilePanel;
import com.github.tatercertified.util.GameProfileGson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class VersionGUIV2 extends JFrame {
    //Panels
    private final JPanel main_panel = new JPanel();
    public final JPanel profile_container_panel = new JPanel();
    private final JPanel bottom_panel = new JPanel();
    //Labels
    private final JLabel main_label = new JLabel("Select Your Profile");
    private final JLabel create_profile_label = new JLabel("Create A New Profile");
    //Button
    private final JButton create_profile_button = new JButton("Create");
    //Textbox
    public final JTextField create_profile_textbox = new JTextField("Name");
    //Separator
    private final JSeparator separator1 = new JSeparator();
    //Scroll
    private JScrollPane scroll;
    //Panel List
    List<ProfilePanel> panels;

    public VersionGUIV2() {
        initVersionGUI();
    }

    private void initVersionGUI() {
        setTitle("Game Profile Selection");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(500,500));
        setIconImage(LoadingGUI.icon);

        // Main panel
        add(main_panel);
        main_panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints1 = new GridBagConstraints();
        constraints1.fill = GridBagConstraints.HORIZONTAL;
        constraints1.anchor = GridBagConstraints.CENTER;
        constraints1.weightx = 1.0;
        constraints1.insets = new Insets(5, 5, 5, 5);
        constraints1.gridx = 0;
        constraints1.gridy = 0;
        constraints1.gridwidth = 2;
        main_panel.add(main_label, constraints1);
        constraints1.gridy = 1;
        constraints1.gridheight = 3;
        main_panel.add(profile_container_panel, constraints1);
        scroll = new JScrollPane(profile_container_panel);
        main_panel.add(scroll, constraints1);
        constraints1.gridheight = 1;
        constraints1.gridy = 4;
        main_panel.add(bottom_panel, constraints1);

        // Profile Container Panel
        createProfiles(profile_container_panel);

        // Bottom Panel
        bottom_panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        bottom_panel.add(separator1, constraints);
        constraints.gridy = 1;
        bottom_panel.add(create_profile_label, constraints);
        constraints.gridwidth = 1;
        constraints.gridy = 2;
        bottom_panel.add(create_profile_textbox, constraints);
        constraints.gridx = 1;
        bottom_panel.add(create_profile_button, constraints);

        // Size
        create_profile_label.setPreferredSize(new Dimension(200,60));
        create_profile_textbox.setPreferredSize(new Dimension(300,30));

        // Fonts
        create_profile_label.setFont(new Font("Serif", Font.PLAIN, 15));
        main_label.setFont(new Font("Serif", Font.BOLD, 20));

        // ActionListeners
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Version is closing");
                saveSelected();
            }
        });

        create_profile_button.addActionListener(e -> {
            GameProfile profile = new GameProfile();
            profile.setProfileName(create_profile_textbox.getText());
            JFrame editor = new ProfileEditor(this, profile, true);
            editor.setVisible(true);
        });

        pack();
    }

    public void createProfiles(JPanel profile_container_panel) {
        profile_container_panel.removeAll();
        profile_container_panel.setLayout(new GridLayout(0, 3, 10, 10)); // Change the number of columns (3 in this example)

        panels = ProfileGenerator.createProfiles();
        for (ProfilePanel panel : panels) {
            if (panel.getProfile().getSelected()) {
                panel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }
            profile_container_panel.add(panel);
        }
    }

    private void saveSelected() {
        for (ProfilePanel panel : panels) {
            GameProfile profile = panel.getProfile();
            GameProfileGson.updateGameProfileInFile(profile, profile.getProfileName());
        }
    }
}
