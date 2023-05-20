package com.github.tatercertified.guis.profiles;

import com.github.tatercertified.GameProfile;
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
        List<GameProfile> profile_list = GameProfileGson.readGameProfilesFromFile();
        if (profile_list == null) {
            return profiles;
        }
        for (GameProfile profile : profile_list) {
            ProfilePanel panel = createSquarePanel(profile);
            panel.setProfile(profile);
            profiles.add(panel);
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
                for (ProfilePanel current_profile : profiles) {
                    if (current_profile != panel && current_profile.getSelected()) {
                        current_profile.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                        current_profile.setSelected(false);
                    }
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    JFrame new_editor = new ProfileEditor(profile, false);
                    new_editor.setVisible(true);
                }
            }
        });

        JLabel name_label = new JLabel(profile.getProfileName());
        JLabel ver_label = new JLabel(profile.getVersion());
        JLabel loader_label = new JLabel(profile.getLoader());
        panel.add(name_label);
        panel.add(ver_label);
        panel.add(loader_label);
        return panel;
    }
}
