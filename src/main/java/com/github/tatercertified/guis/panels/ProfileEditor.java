package com.github.tatercertified.guis.panels;

import com.github.tatercertified.util.GameProfile;
import com.github.tatercertified.guis.profiles.VersionGUIV2;
import com.github.tatercertified.tatertester.DownloadLoaders;
import com.github.tatercertified.tatertester.DownloadMC;
import com.github.tatercertified.util.GameProfileGson;
import com.github.tatercertified.util.JavaProfile;
import com.github.tatercertified.util.JavaProfileGson;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class ProfileEditor extends JFrame {
    private final JPanel main_panel = new JPanel();
    private final VersionGUIV2 parent_gui;
    public ProfileEditor(VersionGUIV2 parent, GameProfile profile, boolean is_new) {
        this.parent_gui = parent;
        create(profile, is_new);
    }

    private void create(GameProfile profile, boolean is_new) {
        setTitle("Game Profile Editor");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(500,500));
        add(main_panel);
        main_panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        // Labels
        JLabel pathLabel = new JLabel("Path:");
        JLabel nameLabel = new JLabel("Name:");
        JLabel versionLabel = new JLabel("Version:");
        JLabel loaderLabel = new JLabel("Loader:");
        JLabel loaderVersionLabel = new JLabel("Loader Version:");
        JLabel javaProfileLabel = new JLabel("Java Profile:");

        // Components
        JTextField pathTextField = new JTextField();
        JTextField nameTextField = new JTextField();
        JComboBox<String> versionComboBox = new JComboBox<>(DownloadMC.getStableVersions(List.of(DownloadMC.versions)));
        JComboBox<String> loaderComboBox = new JComboBox<>(new String[]{"Vanilla", "Fabric", "Quilt"});
        JComboBox<String> loaderVersionComboBox = new JComboBox<>();
        JComboBox<JavaProfile> javaProfileComboBox = new JComboBox<>(JavaProfileGson.readJavaProfilesFromFile().toArray(new JavaProfile[0]));
        JButton saveButton = new JButton("Save");
        ImageIcon folder_icon = new ImageIcon(Objects.requireNonNull(ProfileEditor.class.getClassLoader().getResource("assets/folder.png")));
        JButton openInFileExplorer = new JButton(folder_icon);
        JCheckBox mcSnapshotCheck = new JCheckBox("Snapshots");
        JCheckBox loaderSnapshotCheck = new JCheckBox("Snapshots");

        // Check for NullPointers
        if (is_new) {
            profile.setPath(Path.of(""));
            profile.setSnapshot(false);
            profile.setLoaderSnapshot(false);
            profile.setVersion(DownloadMC.getLatestStableVersion(List.of(DownloadMC.versions)));
            profile.setLoader("Vanilla");
            profile.setJavaProfile(JavaProfileGson.readJavaProfilesFromFile().get(0));
        }

        // Configure Components
        pathTextField.setText(profile.getPath().toString());
        openInFileExplorer.setBorderPainted(false);
        openInFileExplorer.setOpaque(false);
        openInFileExplorer.setFocusPainted(false);
        openInFileExplorer.setBackground(Color.WHITE);
        openInFileExplorer.setBorder(BorderFactory.createEmptyBorder());
        nameTextField.setText(profile.getProfileName());
        javaProfileComboBox.setSelectedItem(profile.getJavaProfile());
        mcSnapshotCheck.setSelected(profile.isSnapshot());
        loaderSnapshotCheck.setSelected(profile.isLoaderSnapshot());
        updateSnapshot(mcSnapshotCheck, versionComboBox);
        versionComboBox.setSelectedItem(profile.getVersion());
        loaderComboBox.setSelectedItem(profile.getLoader());
        if (profile.getLoaderVer() != null) {
            loaderVersionComboBox.setSelectedItem(profile.getLoaderVer());
        }
        javaProfileComboBox.setSelectedItem(profile.getJavaProfile());
        updateLoaderVersions(loaderComboBox, loaderVersionComboBox, loaderVersionLabel, loaderSnapshotCheck);

        // Separators
        JSeparator separator1 = new JSeparator();
        JSeparator separator2 = new JSeparator();
        JSeparator separator3 = new JSeparator();
        JSeparator separator4 = new JSeparator();
        JSeparator separator5 = new JSeparator();

        // Action Listeners
        saveButton.addActionListener(e -> {
            if (is_new || !Objects.equals(versionComboBox.getSelectedItem().toString(), profile.getVersion())) {
                DownloadMC.install(loaderComboBox.getSelectedItem().toString(), versionComboBox, loaderVersionComboBox, parent_gui);
            }
            save(profile, nameTextField, pathTextField, versionComboBox, mcSnapshotCheck, loaderComboBox, loaderVersionComboBox, loaderSnapshotCheck, javaProfileComboBox);
            dispose();
        });

        openInFileExplorer.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

            int result = fileChooser.showOpenDialog(main_panel);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedDirectory = fileChooser.getSelectedFile();

                String selectedDirectoryPath = selectedDirectory.getAbsolutePath();

                pathTextField.setText(selectedDirectoryPath);
            }
        });

        loaderComboBox.addActionListener(e -> updateLoaderVersions(loaderComboBox, loaderVersionComboBox, loaderVersionLabel, loaderSnapshotCheck));

        mcSnapshotCheck.addActionListener(e -> updateSnapshot(mcSnapshotCheck, versionComboBox));

        loaderSnapshotCheck.addActionListener(e -> updateSnapshotLoader(loaderSnapshotCheck, loaderVersionComboBox));

        // Add components and labels to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;
        main_panel.add(nameLabel, constraints);

        constraints.gridx = 1;
        main_panel.add(nameTextField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        main_panel.add(separator1, constraints);

        constraints.gridy = 2;
        main_panel.add(pathLabel, constraints);

        constraints.gridx = 1;
        main_panel.add(pathTextField, constraints);

        constraints.gridx = 2;
        main_panel.add(openInFileExplorer, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        main_panel.add(separator2, constraints);

        constraints.gridy = 4;
        main_panel.add(versionLabel, constraints);

        constraints.gridx = 1;
        main_panel.add(versionComboBox, constraints);

        constraints.gridx = 2;
        main_panel.add(mcSnapshotCheck, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        main_panel.add(separator3, constraints);

        constraints.gridy = 6;
        main_panel.add(loaderLabel, constraints);

        constraints.gridx = 1;
        main_panel.add(loaderComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 7;
        main_panel.add(loaderVersionLabel, constraints);

        constraints.gridx = 1;
        main_panel.add(loaderVersionComboBox, constraints);

        constraints.gridx = 2;
        main_panel.add(loaderSnapshotCheck, constraints);

        constraints.gridx = 0;
        constraints.gridy = 8;
        main_panel.add(separator4, constraints);

        constraints.gridy = 9;
        main_panel.add(javaProfileLabel, constraints);

        constraints.gridx = 1;
        main_panel.add(javaProfileComboBox, constraints);

        constraints.gridx = 0;
        constraints.gridy = 10;
        main_panel.add(separator5, constraints);

        constraints.gridx = 1;
        constraints.gridy = 11;
        main_panel.add(saveButton, constraints);

        pack();
    }

    private void save(GameProfile profile, JTextField name, JTextField path, JComboBox<String> version, JCheckBox snapshot, JComboBox<String> loader, JComboBox<String> loader_version, JCheckBox loader_snaphsot, JComboBox<JavaProfile> java_profile) {
        String original_name = profile.getProfileName();
        profile.setProfileName(name.getText());
        profile.setPath(Paths.get(path.getText()));
        profile.setVersion((String) version.getSelectedItem());
        profile.setSnapshot(snapshot.isSelected());
        profile.setLoader((String) loader.getSelectedItem());
        profile.setLoaderVer((String) loader_version.getSelectedItem());
        profile.setLoaderSnapshot(loader_snaphsot.isSelected());
        profile.setJavaProfile((JavaProfile) java_profile.getSelectedItem());
        GameProfileGson.updateGameProfileInFile(profile, original_name);
        parent_gui.createProfiles(parent_gui.profile_container_panel);
        profile.setNeedsInstallations(true);
    }

    private void updateLoaderVersions(JComboBox<String> loader, JComboBox<String> loader_version, JLabel loader_ver_label, JCheckBox snapshot) {
        switch (loader.getSelectedItem().toString()) {
            case "Fabric" -> {
                loader_version.setModel(new DefaultComboBoxModel<>(DownloadLoaders.fabricVersions()));
                loader_version.setVisible(true);
                loader_ver_label.setVisible(true);
                snapshot.setVisible(false);
            }
            case  "Quilt" -> {
                if (snapshot.isSelected()) {
                    loader_version.setModel(new DefaultComboBoxModel<>(DownloadLoaders.quiltVersions()));
                } else {
                    loader_version.setModel(new DefaultComboBoxModel<>(DownloadLoaders.quiltVersionsStable()));
                }
                loader_version.setVisible(true);
                loader_ver_label.setVisible(true);
                snapshot.setVisible(true);
            }
            case "Vanilla" -> {
                loader_version.setVisible(false);
                loader_ver_label.setVisible(false);
                snapshot.setVisible(false);
            }
        }
    }

    private void updateSnapshot(JCheckBox snapshot, JComboBox<String> version) {
        if (snapshot.isSelected()) {
            version.setModel(new DefaultComboBoxModel<>(DownloadMC.versions));
        } else {
            version.setModel(new DefaultComboBoxModel<>(DownloadMC.getStableVersions(List.of(DownloadMC.versions))));
        }
    }

    private void updateSnapshotLoader(JCheckBox snapshot, JComboBox<String> loader_version) {
        if (snapshot.isSelected()) {
            loader_version.setModel(new DefaultComboBoxModel<>(DownloadLoaders.quiltVersions()));
        } else {
            loader_version.setModel(new DefaultComboBoxModel<>(DownloadLoaders.quiltVersionsStable()));
        }
    }
}
