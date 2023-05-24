package com.github.tatercertified.guis.profiles;

import com.github.tatercertified.util.GameProfile;
import com.github.tatercertified.guis.panels.ProfileEditor;
import com.github.tatercertified.guis.panels.ProfilePanel;
import com.github.tatercertified.util.GameProfileGson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ProfileGenerator {
    //Profiles
    public static final List<ProfilePanel> profiles = new ArrayList<>();
    public static List<ProfilePanel> createProfiles() {
        profiles.clear();
        List<GameProfile> profile_list = GameProfileGson.readGameProfilesFromFile();
        if (profile_list != null) {
            for (GameProfile profile : profile_list) {
                ProfilePanel panel = createSquarePanel(profile);
                panel.setProfile(profile);
                panel.setSelected(profile.getSelected());
                profiles.add(panel);
            }
        }
        return profiles;
    }

    private static ProfilePanel createSquarePanel(GameProfile profile) {
        ProfilePanel panel = new ProfilePanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setPreferredSize(new Dimension(100, 100)); // Set the size of each panel
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                panel.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                panel.setSelected(true);
                profile.setSelected(true);
                GameProfileGson.setCurrentlySelectedGameProfile(profile);
                for (ProfilePanel current_profile : profiles) {
                    if (current_profile != panel && current_profile.getSelected()) {
                        current_profile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        current_profile.setSelected(false);
                        current_profile.getProfile().setSelected(false);
                    }
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    VersionGUIV2 parentFrame = (VersionGUIV2) SwingUtilities.getWindowAncestor(panel);
                    JFrame new_editor = new ProfileEditor(parentFrame ,profile, false);
                    new_editor.setVisible(true);
                }
            }
        });

        JLabel name_label = new JLabel(profile.getProfileName());
        JLabel ver_label = new JLabel(profile.getVersion());
        JLabel loader_label = new JLabel(profile.getLoader());

        // Fonts
        name_label.setFont(new Font("Serif", Font.PLAIN, 20));

        panel.add(name_label);
        panel.add(ver_label);
        panel.add(loader_label);
        return panel;
    }
}
