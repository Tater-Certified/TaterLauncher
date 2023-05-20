package com.github.tatercertified.guis.panels;

import com.github.tatercertified.GameProfile;

import javax.swing.*;

public class ProfilePanel extends JPanel {
    public boolean isSelected;
    public GameProfile profile;

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
    public boolean getSelected() {
        return isSelected;
    }
    public void setProfile(GameProfile profile) {
        this.profile = profile;
    }
    public GameProfile getProfile() {
        return profile;
    }
}
