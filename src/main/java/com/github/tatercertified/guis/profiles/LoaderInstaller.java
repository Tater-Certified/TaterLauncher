package com.github.tatercertified.guis.profiles;

import com.github.tatercertified.tatertester.DownloadMC;
import org.quiltmc.installer.QuiltMeta;
import org.quiltmc.installer.VersionManifest;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.*;

import static com.github.tatercertified.Main.LOADER_META;
import static com.github.tatercertified.tatertester.DownloadMC.getStableVersions;
import static com.github.tatercertified.tatertester.DownloadMC.versions;

public class LoaderInstaller {
    public static JFrame mainframe = new JFrame();
    public static JPanel mainpanel = new JPanel();
    public static JPanel configpanel = new JPanel();
    public static JPanel mcversionpanel = new JPanel();
    public static JButton startbutton = new JButton();
    public static JComboBox<String> loaderversion = new JComboBox<>();
    public static JComboBox<String> minecraftversion = new JComboBox<>(getStableVersions(List.of(versions)));
    public static ArrayList<String> fabricversions = new ArrayList<>();
    public static JLabel mcversionlabel = new JLabel("Minecraft Version", SwingConstants.CENTER);
    public static JLabel loaderlabel = new JLabel();
    public static JCheckBox mcsnapshotcheck = new JCheckBox("Snapshots");
    public static JCheckBox fabriccheck = new JCheckBox("Fabric");
    public static JCheckBox quiltcheck = new JCheckBox("Quilt");
    public static JSeparator thegreatdivide = new JSeparator();

    public static String loader = "Vanilla";
    public static List<String> quiltversions;




    public static void LaunchGUI() {
        mainframe.add(mainpanel);
        mainframe.setMinimumSize(new Dimension(600, 600));
        mainframe.setTitle("Tater Tester Development Build");
        mainframe.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        mainpanel.setLayout(new BorderLayout());
        mainpanel.add(startbutton, BorderLayout.SOUTH);

        startbutton.addActionListener((e) -> {
            try {
                DownloadMC.download();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            //LaunchMC.LaunchClient();
        });

        mainpanel.add(configpanel, BorderLayout.CENTER);
        configpanel.setLayout(new BoxLayout(configpanel, BoxLayout.PAGE_AXIS));
        configpanel.add(mcversionlabel);
        configpanel.add(mcversionpanel);

        mcversionpanel.add(minecraftversion);
        mcversionpanel.add(mcsnapshotcheck);
        mcversionpanel.add(fabriccheck);
        mcversionpanel.add(quiltcheck);

        mcsnapshotcheck.addActionListener(e -> {
            if (mcsnapshotcheck.isSelected()) {
                minecraftversion.setModel(new DefaultComboBoxModel<>(versions));
            } else {
                minecraftversion.setModel(new DefaultComboBoxModel<>(getStableVersions(List.of(versions))));
            }
            reloadStartButton();
        });

        fabriccheck.addActionListener(e -> {
            if (fabriccheck.isSelected()) {
                quiltcheck.setSelected(false);
                //forgecheck.setSelected(false);
                loaderlabel.setText("Fabric Loader Version");
                loader = "Fabric";
                loaderversion.setModel(new DefaultComboBoxModel<>(fabricversions.stream().toList().toArray(new String[0])));
                loaderversion.setVisible(true);
            } else {
                loader = "Vanilla";
                loaderlabel.setText("");
                loaderversion.setVisible(false);
            }
            reloadStartButton();
        });

        quiltcheck.addActionListener(e -> {
            if (quiltcheck.isSelected()) {
                fabriccheck.setSelected(false);
                //forgecheck.setSelected(false);
                loaderlabel.setText("Quilt Loader Version");
                loader = "Quilt";
                loaderversion.setModel(new DefaultComboBoxModel<>(quiltversions.stream().toList().toArray(new String[0])));
                loaderversion.setVisible(true);
            } else {
                loader = "Vanilla";
                loaderlabel.setText("");
                loaderversion.setVisible(false);
            }
            reloadStartButton();
        });

        /*/forgecheck.addActionListener(e -> {
            if (forgecheck.isSelected()) {
                fabriccheck.setSelected(false);
                quiltcheck.setSelected(false);
                loaderlabel.setText("Forge Loader Version");
                loader = "Forge";
                loaderversion.setModel(new DefaultComboBoxModel<>(quiltversions.stream().toList().toArray(new String[0])));
                loaderversion.setVisible(true);
            } else {
                loader = "Vanilla";
                loaderlabel.setText("");
                loaderversion.setVisible(false);
            }
            reloadStartButton();
        });
        /*/

        mcversionpanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));

        thegreatdivide.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        configpanel.add(thegreatdivide);

        //Fabric Loader Code

        int currentamount = 0;
        int fabricmaxversions = LOADER_META.getVersions().size();

        while (currentamount != fabricmaxversions) {
            String version = LOADER_META.getVersions().get(currentamount).getVersion();
            fabricversions.add(version);
            currentamount++;
        }

        DefaultListCellRenderer listRenderer = new DefaultListCellRenderer();
        listRenderer.setHorizontalAlignment(DefaultListCellRenderer.CENTER);

        //Quilt Stuff
        Set<QuiltMeta.Endpoint<?>> endpoints = new HashSet<>();
        endpoints.add(QuiltMeta.LOADER_VERSIONS_ENDPOINT);
        endpoints.add(QuiltMeta.INTERMEDIARY_VERSIONS_ENDPOINT);

        QuiltMeta.create(QuiltMeta.DEFAULT_META_URL, QuiltMeta.DEFAULT_FABRIC_META_URL, endpoints).thenAcceptBothAsync(VersionManifest.create(), ((quiltMeta, manifest) -> quiltversions = quiltMeta.getEndpoint(QuiltMeta.LOADER_VERSIONS_ENDPOINT)));

        loaderversion.setRenderer(listRenderer);
        minecraftversion.setRenderer(listRenderer);



        configpanel.add(loaderlabel);
        configpanel.add(loaderversion);
        loaderversion.setVisible(false);

        loaderversion.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));


        loaderversion.addActionListener((e -> reloadStartButton()));

        minecraftversion.addActionListener((e -> reloadStartButton()));

        //Finalize
        reloadStartButton();
        mainframe.setVisible(true);
    }

    public static void reloadStartButton() {
        if (!fabriccheck.isSelected() && !quiltcheck.isSelected()) {
            startbutton.setText("Download Minecraft " + Objects.requireNonNull(minecraftversion.getSelectedItem()));
        } else {
            startbutton.setText("Download " + loader + " Loader " + Objects.requireNonNull(loaderversion.getSelectedItem()) + " For Minecraft " + Objects.requireNonNull(minecraftversion.getSelectedItem()));
        }
    }
}
