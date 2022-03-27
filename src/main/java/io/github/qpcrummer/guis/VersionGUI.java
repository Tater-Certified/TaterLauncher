package io.github.qpcrummer.guis;

import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import static io.github.qpcrummer.guis.GUI.frame;
import static io.github.qpcrummer.guis.LoadingGUI.icon;

public class VersionGUI {
    //Name Vars
    public static String name0 = "Yes";
    public static String name1 = "This is a test";

    //Strings
    static String[] javaoptions = {"Grab Java Profiles"};
    static String[] loaderoptions = {"Vanilla","Fabric","Fabric Performance","Fabric Cinematic","Forge","Optifine"};

    //Frames
    public static final JFrame versionframe = new JFrame();
    //Panels
    public static final JPanel masterpanel = new JPanel();
    public static final JPanel versionpanel = new JPanel();
    public static final JPanel newverpanel = new JPanel();
    //Labels
    public static final JLabel verlabel = new JLabel("   Select Your Version");
    public static final JLabel newverlabel = new JLabel("Create A New Version");
    //Butons
    public static final JButton createver = new JButton("Create");
    //Text Boxes
    public static final JTextField namever = new JTextField("Name");
    //Profile Panels
    public static final JPanel profile0 = new JPanel();
    public static final JPanel profile1 = new JPanel();
    //Profile Names
    public static final JLabel label0 = new JLabel(name0);
    public static final JLabel label1 = new JLabel(name1);
    //DropDown Ver
    public static JComboBox<Object> ver0;
    public static JComboBox<Object> ver1;

    static {
        try {
            ver0 = new JComboBox<>(VersionHelpers.getVersions());

            ver1 = new JComboBox<>(VersionHelpers.getVersions());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Directories
    public static final JButton dir0 = new JButton("Choose Path");
    public static final JButton dir1 = new JButton("Choose Path");
    //Text Box Java
    public static final JComboBox<String> java0 = new JComboBox<>(javaoptions);
    public static final JComboBox<String> java1 = new JComboBox<>(javaoptions);
    //Profile Button
    public static final JButton select0 = new JButton("Select");
    public static final JButton select1 = new JButton("Select");
    //Loader DropDown
    public static final JComboBox<String> loader0 = new JComboBox<>(loaderoptions);
    public static final JComboBox<String> loader1 = new JComboBox<>(loaderoptions);
    //Separator
    public static final JSeparator separate = new JSeparator();

    public static void initializever() {
        //Version Frame
        versionframe.setTitle("Version Selector");
        versionframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        versionframe.setMinimumSize(new Dimension(500,500));
        versionframe.setIconImage(icon);
        JFrame.setDefaultLookAndFeelDecorated(false);

        versionframe.add(masterpanel);

        //Master Panel
        masterpanel.setLayout(new BorderLayout());
        masterpanel.add(verlabel, BorderLayout.PAGE_START);
        masterpanel.add(versionpanel, BorderLayout.CENTER);
        masterpanel.add(newverpanel, BorderLayout.PAGE_END);

        //Version Panel
        versionpanel.setLayout(new BoxLayout(versionpanel, BoxLayout.PAGE_AXIS));

        //Add Profiles
        versionpanel.add(profile0);
        versionpanel.add(profile1);
        versionpanel.add(separate);

        //New Version Panel
        newverpanel.setLayout(new BorderLayout());
        newverpanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
        newverpanel.add(newverlabel, BorderLayout.PAGE_START);
        newverpanel.add(namever, BorderLayout.LINE_START);
        newverpanel.add(createver, BorderLayout.CENTER);

        //Profile configurations
        profile0.setPreferredSize(new Dimension(800,35));
        profile0.add(label0);
        profile0.add(select0);
        profile0.add(ver0);
        profile0.add(dir0);
        dir0.addActionListener(ae -> {
        });
        dir0.setPreferredSize(new Dimension(300,25));
        profile0.add(java0);
        profile0.add(loader0);

        profile1.setPreferredSize(new Dimension(800,35));
        profile1.add(label1);
        profile1.add(select1);
        profile1.add(ver1);
        profile1.add(dir1);
        dir1.addActionListener(ae -> {
        });
        dir1.setPreferredSize(new Dimension(300,25));
        profile1.add(java1);
        profile1.add(loader1);

        //Name Config
        label0.setFont(new Font("Serif", Font.BOLD, 12));
        label1.setFont(new Font("Serif", Font.BOLD, 12));

        //Label Config
        verlabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));
        newverlabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 18));
        newverlabel.setPreferredSize(new Dimension(200,60));


        //Text Box Config
        namever.setPreferredSize(new Dimension(300,30));

        versionframe.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Version is closing");
                frame.setVisible(true);
            }
        });
        versionframe.pack();
    }

    //Version code I don't understand

    static class VersionHelpers {
        public static Object[] getVersions() throws IOException {
            Gson gson = new Gson();
            ArrayList<String> out = new ArrayList<>();
            VersionFromJsonButInAClass versionMetaFromJson = gson.fromJson(getVersionsFromMojank(), VersionFromJsonButInAClass.class);
            for (VersionFromJsonButInAClass.Version v: versionMetaFromJson.versions) {
                out.add(v.id);
            }
            return out.toArray();
        }

        public static String getVersionsFromMojank() throws IOException {
            InputStream in = new URL("https://launchermeta.mojang.com/mc/game/version_manifest.json").openConnection().getInputStream();
            Scanner jsonScanner = new Scanner(in).useDelimiter("\\A");
            return jsonScanner.hasNext() ? jsonScanner.next() : "";
        }

        static class VersionFromJsonButInAClass {
            Latest latest;
            Version[] versions;

            public VersionFromJsonButInAClass(Latest a, Version[] b) {
                latest = a;
                versions = b;
            }

            static class Latest {
                String release;
                String snapshot;

                public String getRelease() {
                    return release;
                }

                public String getSnapshot() {
                    return snapshot;
                }
            }

            static class Version {
                String id;
                String type;
                URL url;
                String time;
                String releaseTime;

                public String getId() {
                    return id;
                }

                public String getReleaseTime() {
                    return releaseTime;
                }

                public  String getTime() {
                    return time;
                }

                public String getType() {
                    return type;
                }

                public URL getUrl() {
                    return url;
                }
            }
        }
    }
}
