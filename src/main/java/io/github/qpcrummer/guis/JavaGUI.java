package io.github.qpcrummer.guis;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import static io.github.qpcrummer.guis.LoadingGUI.icon;

public class JavaGUI {
    //Frames
    public static final JFrame javaframe = new JFrame();
    //Panels
    public static final JPanel profiles = new JPanel();
    public static final JPanel newpro = new JPanel();
    public static final JPanel path = new JPanel();
    public static final JPanel ram = new JPanel();
    public static final JPanel flags = new JPanel();
    public static final JPanel newprocombo = new JPanel();
    public static final JPanel argpanel = new JPanel();
    public static final JPanel presets = new JPanel();
    public static final JPanel g1 = new JPanel();
    public static final JPanel z = new JPanel();
    public static final JPanel shen = new JPanel();
    //Tabs
    public static final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);

    //Buttons
    public static final JButton newprofile = new JButton("Create Profile");
    public static final JButton g1sel = new JButton("Load");
    public static final JButton zsel = new JButton("Load");
    public static final JButton shensel = new JButton("Load");
    //File Explorers
    public static final JFileChooser profilefinder = new JFileChooser();
    public static final JFileChooser javafinder = new JFileChooser();
    //Labels
    public static final JLabel finderlabel = new JLabel("Java Profiles");
    public static final JLabel javalabel = new JLabel("Select your Java");
    public static final JLabel ramlabel = new JLabel("Configure Ram Usage");
    public static final JLabel minjavalabel = new JLabel("Insert your starting ram");
    public static final JLabel maxjavalabel = new JLabel("Insert your maximum ram");
    public static final JLabel flagslabel = new JLabel("Configure Your JVM");
    public static final JLabel gclabel = new JLabel("Select your Garbage Collector");
    public static final JLabel largepage = new JLabel("Set LargePages size");
    public static final JLabel gcthreadlabel = new JLabel("Set number of GC threads");
    public static final JLabel otherargslabel = new JLabel("Add Other Arguments");
    public static final JLabel otherflagslabel = new JLabel("Add Other Flags");
    public static final JLabel jvmtoggles = new JLabel("Toggles");
    public static final JLabel amounts = new JLabel("Toggle Configuration");
    public static final JLabel g1title = new JLabel("       Graceful G1GC");
    public static final JLabel ztitle = new JLabel("            Zealous ZGC");
    public static final JLabel shentitle = new JLabel("        Shocking Shenandoah");
    //Text Boxes
    public static final JTextField minjava = new JTextField("Use M for megabytes and G for gigabytes");
    public static final JTextField maxjava = new JTextField("Use M for megabytes and G for gigabytes");
    public static final JTextField largepagesize = new JTextField("Use M for megabytes");
    public static final JTextField gcthreads = new JTextField("If set to 0, it will use as many as needed");
    public static final JTextField otherargs = new JTextField();
    public static final JTextField newproname = new JTextField("Profile Name");
    //CheckBoxes
    public static final JCheckBox noexplicitcheck = new JCheckBox("DisableExplicitGC - Disables this GC to stop slowdowns");
    public static final JCheckBox largepagescheck = new JCheckBox("UseLargePages - Gives more resources to the TLB");
    public static final JCheckBox utf8check = new JCheckBox("Dfile.encoding=UTF-8 - Fast Encoder");
    //DropDownMenus
    static String[] optionsToChoose = {"Parallel", "G1", "Z", "Shenandoah", "Other"};
    public static final JComboBox<String> gcselect = new JComboBox<>(optionsToChoose);
    //Separators
    public static final JSeparator partition1 = new JSeparator();
    public static final JSeparator partition2 = new JSeparator();
    //Borders
    public static final Border border1 = BorderFactory.createLineBorder(Color.black);
    public static final Border border2 = BorderFactory.createLineBorder(Color.black);
    public static final Border border3 = BorderFactory.createLineBorder(Color.black);
    public static final Border border4 = BorderFactory.createLineBorder(Color.black);
    public static final Border border5 = BorderFactory.createLineBorder(Color.black);
    //Text Areas
    public static final JTextArea g1text = new JTextArea(
            """
                    The default Minecraft Garbage Collector, but a bit more beefy.\s
                    
                    It includes the following features:
                    - Optimized Pause Times
                    - Very Aggressive
                    - Huge Pages for Linux"""
    );
    public static final JTextArea ztext = new JTextArea(
            """
                    The extremely fast GC added in JDK 15.\s
                    
                    It includes the following features:
                    - Optimized Uncommit Delays
                    - Minimal Lag Spikes
                    - Huge Pages for Linux
                    """
    );
    public static final JTextArea shentext = new JTextArea(
            """
                    The fastest and with the least latency, that is Shenandoah (as of JDK17).\s
                    
                    It includes the following features:
                    - Very Aggressive Mode
                    - Zero Lag Spikes
                    - Huge Pages for Linux"""
    );

    public static void initializejavaui() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        //Java Frame
        javaframe.getContentPane().setLayout(new GridLayout(1, 1));
        javaframe.setTitle("Java Settings");
        javaframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        javaframe.setMinimumSize(new Dimension(555, 500));
        javaframe.setIconImage(icon);

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        javafinder.updateUI();
        profilefinder.updateUI();

        //Add Tabs
        tabbedPane.addTab("Java Profiles", profiles);
        tabbedPane.addTab("Select Java", path);
        tabbedPane.addTab("Configure", argpanel);
        tabbedPane.addTab("Presets", presets);

        javaframe.getContentPane().add(tabbedPane);

        //Profiles
        profiles.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));
        profiles.setLayout(new BoxLayout(profiles, BoxLayout.PAGE_AXIS));
        profiles.add(finderlabel);
        profiles.add(profilefinder);
        profiles.add(newprocombo);

        newprocombo.setLayout(new GridLayout(1,2));
        newprocombo.add(newproname);
        newprocombo.add(newprofile);
        newprocombo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JavaGUI.newprofile.addActionListener(e -> {
        });

        profilefinder.setApproveButtonText("Select Profile");


        profilefinder.setFileFilter(new FileFilter()
        {
            @Override
            public boolean accept(File file)
            {
                return file.getName().equalsIgnoreCase(".JSON");
            }

            @Override
            public String getDescription()
            {
                return ".json files";
            }
        });


        //Java Paths
        path.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        path.setLayout(new BoxLayout(path, BoxLayout.PAGE_AXIS));
        path.add(javalabel);
        path.add(javafinder);

        javafinder.setApproveButtonText("Select Java");


        //Args Tab
        argpanel.setLayout(new GridLayout(1, 2));
        argpanel.add(ram);
        argpanel.add(flags);

        //Ram
        ram.setBorder(border5);
        ram.add(ramlabel);
        ram.add(minjavalabel);
        ram.add(minjava);
        ram.add(maxjavalabel);
        ram.add(maxjava);
        ram.add(gclabel);
        ram.add(gcselect);
        minjava.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,
                        minjava.getPreferredSize().height));
        maxjava.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,
                        maxjava.getPreferredSize().height));
        gcselect.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,
                        gcselect.getPreferredSize().height));

        ram.setLayout(new BoxLayout(ram, BoxLayout.PAGE_AXIS));

        //Flags
        flags.setBorder(border4);
        flags.setLayout(new BoxLayout(flags, BoxLayout.PAGE_AXIS));
        flags.add(flagslabel);
        flags.add(jvmtoggles);
        flags.add(largepagescheck);
        flags.add(noexplicitcheck);
        flags.add(utf8check);

        flags.add(partition1);

        flags.add(amounts);
        flags.add(largepage);
        flags.add(largepagesize);
        largepagesize.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,
                        largepagesize.getPreferredSize().height));
        flags.add(gcthreadlabel);
        flags.add(gcthreads);
        gcthreads.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,
                        gcthreads.getPreferredSize().height));

        flags.add(partition2);

        flags.add(otherargslabel);
        flags.add(otherargs);
        otherargs.setMaximumSize(
                new Dimension(Integer.MAX_VALUE,
                        otherargs.getPreferredSize().height));

        //Presets
        presets.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        presets.setLayout(new GridLayout(1, 3));
        presets.add(g1);
        presets.add(z);
        presets.add(shen);

        //G1
        g1.setLayout(new BorderLayout());
        g1.setBorder(border1);
        g1.add(g1title,BorderLayout.PAGE_START);
        g1.add(g1text,BorderLayout.CENTER);
        g1text.setEditable(false);
        g1text.setFont(new Font("Serif", Font.BOLD, 16));
        g1text.setLineWrap(true);
        g1text.setWrapStyleWord(true);
        g1.add(g1sel,BorderLayout.PAGE_END);
        g1sel.setPreferredSize(new Dimension(300,60));

        //Z
        z.setLayout(new BorderLayout());
        z.setBorder(border2);
        z.add(ztitle,BorderLayout.PAGE_START);
        z.add(ztext,BorderLayout.CENTER);
        ztext.setEditable(false);
        ztext.setFont(new Font("Serif", Font.BOLD, 16));
        ztext.setLineWrap(true);
        ztext.setWrapStyleWord(true);
        z.add(zsel,BorderLayout.PAGE_END);
        zsel.setPreferredSize(new Dimension(300,60));

        //Shenandoah
        shen.setLayout(new BorderLayout());
        shen.setBorder(border3);
        shen.add(shentitle,BorderLayout.PAGE_START);
        shen.add(shentext,BorderLayout.CENTER);
        shentext.setEditable(false);
        shentext.setFont(new Font("Serif", Font.BOLD, 16));
        shentext.setLineWrap(true);
        shentext.setWrapStyleWord(true);
        shen.add(shensel,BorderLayout.PAGE_END);
        shensel.setPreferredSize(new Dimension(300,60));

        //Button configs
        newprofile.setPreferredSize(new Dimension(200,40));

        //Label configs
        finderlabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));
        javalabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 30));
        ramlabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 30));
        minjavalabel.setFont(new Font("Serif", Font.BOLD, 20));
        maxjavalabel.setFont(new Font("Serif", Font.BOLD, 20));
        flagslabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 30));
        gclabel.setFont(new Font("Serif", Font.BOLD, 20));
        jvmtoggles.setFont(new Font("Serif", Font.BOLD, 20));
        amounts.setFont(new Font("Serif", Font.BOLD, 20));
        otherargslabel.setFont(new Font("Serif", Font.BOLD, 20));
        otherflagslabel.setFont(new Font("Serif", Font.BOLD, 20));
        gcthreadlabel.setFont(new Font("Serif", Font.BOLD, 17));
        largepage.setFont(new Font("Serif", Font.BOLD, 17));
        g1title.setFont(new Font("Serif", Font.BOLD, 20));
        ztitle.setFont(new Font("Serif", Font.BOLD, 20));
        shentitle.setFont(new Font("Serif", Font.BOLD, 20));

        javaframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Java Frame is closing");
            }
        });

        javaframe.pack();
    }
}
