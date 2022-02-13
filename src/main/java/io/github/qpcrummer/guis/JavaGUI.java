package io.github.qpcrummer.guis;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static io.github.qpcrummer.guis.GUI.icon;

public class JavaGUI {
    //Frames
    public static final JFrame javaframe = new JFrame();
    //Panels
    public static final JPanel master = new JPanel();
    public static final JPanel profiles = new JPanel();
    public static final JPanel newpro = new JPanel();
    public static final JPanel path = new JPanel();
    public static final JPanel ram = new JPanel();
    public static final JPanel flags = new JPanel();
    //Buttons
    public static final JButton newprofile = new JButton("Create Profile");
    //File Explorers
    public static final JFileChooser profilefinder = new JFileChooser();
    public static final JFileChooser javafinder = new JFileChooser();
    //Labels
    public static final JLabel finderlabel = new JLabel("Java Profiles");
    public static final JLabel javalabel = new JLabel("Select your Java");
    public static final JLabel ramlabel = new JLabel("Configure Ram Usage");
    public static final JLabel minjavalabel = new JLabel("Insert your starting ram");
    public static final JLabel maxjavalabel = new JLabel("Insert your maximum ram");
    public static final JLabel flagslabel = new JLabel("Set your JVM flags");
    public static final JLabel gclabel = new JLabel("Select your Garbage Collector");
    public static final JLabel jvmflaglabel = new JLabel("Select Additional Arguments");
    public static final JLabel largepage = new JLabel("Set LargePages size");
    public static final JLabel gcthreadlabel = new JLabel("Set number of GC threads");
    public static final JLabel otherargslabel = new JLabel("Add other arguments");
    public static final JLabel newprolabel = new JLabel("Create A New Profile");
    //Scroll Panes
    public static final JScrollPane scroll = new JScrollPane(master);
    //Separators
    public static final JSeparator divider1 = new JSeparator();
    public static final JSeparator divider2 = new JSeparator();
    public static final JSeparator divider3 = new JSeparator();
    public static final JSeparator divider4 = new JSeparator();
    //Text Boxes
    public static final JTextField minjava = new JTextField("Use M for megabytes and G for gigabytes");
    public static final JTextField maxjava = new JTextField("Use M for megabytes and G for gigabytes");
    public static final JTextField largepagesize = new JTextField("Use M for megabytes");
    public static final JTextField gcthreads = new JTextField("If set to 0, it will use as many as needed");
    public static final JTextField otherargs = new JTextField();
    public static final JTextField newproname = new JTextField();
    //CheckBoxes
    public static final JCheckBox noexplicitcheck = new JCheckBox("DisableExplicitGC - Disables this GC to stop slowdowns");
    public static final JCheckBox largepagescheck = new JCheckBox("UseLargePages");
    public static final JCheckBox utf8check = new JCheckBox("Dfile.encoding=UTF-8 - Fast Encoder");
    //DropDownMenus
    static String[] optionsToChoose = {"Parallel", "G1", "Z", "Shenandoah"};
    public static final JComboBox<String> gcselect = new JComboBox<>(optionsToChoose);

    public static void initializejavaui() {
        //Java Frame
        javaframe.setLayout(new BorderLayout());
        javaframe.setTitle("Java Settings");
        javaframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        javaframe.pack();
        javaframe.setMinimumSize(new Dimension(555, 500));
        javaframe.setIconImage(icon);

        //Add components
        master.setLayout(new BoxLayout(master, BoxLayout.PAGE_AXIS));
        master.add(profiles);
        master.add(divider4);
        master.add(newpro);
        master.add(divider1);
        master.add(path);
        master.add(divider2);
        master.add(ram);
        master.add(divider3);
        master.add(flags);
        master.add(Box.createVerticalGlue());
        javaframe.getContentPane().add(scroll);

        //Profiles
        profiles.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        profiles.setLayout(new BoxLayout(profiles, BoxLayout.PAGE_AXIS));
        profiles.add(finderlabel);
        profiles.add(profilefinder);

        //New Profiles
        newpro.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        newpro.setLayout(new BoxLayout(newpro, BoxLayout.PAGE_AXIS));
        newpro.add(newprolabel);
        newpro.add(newproname);
        newpro.add(newprofile);

        //Java Paths
        path.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        path.setLayout(new BoxLayout(path, BoxLayout.PAGE_AXIS));
        path.add(javalabel);
        path.add(javafinder);

        //Ram
        ram.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        ram.setLayout(new BoxLayout(ram, BoxLayout.PAGE_AXIS));
        ram.add(ramlabel);
        ram.add(minjavalabel);
        ram.add(minjava);
        ram.add(maxjavalabel);
        ram.add(maxjava);

        //Flags
        flags.setBorder(BorderFactory.createEmptyBorder(10, 10, 30, 10));
        flags.setLayout(new BoxLayout(flags, BoxLayout.PAGE_AXIS));
        flags.add(flagslabel);
        flags.add(gclabel);
        flags.add(gcselect);
        flags.add(jvmflaglabel);
        flags.add(gcthreadlabel);
        flags.add(gcthreads);
        flags.add(largepagescheck);
        flags.add(largepage);
        flags.add(largepagesize);
        flags.add(noexplicitcheck);
        flags.add(utf8check);
        flags.add(otherargslabel);
        flags.add(otherargs);

        //Button configs
        newprofile.setPreferredSize(new Dimension(200,40));

        //Label configs
        finderlabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 30));
        javalabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));
        ramlabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));
        minjavalabel.setFont(new Font("Serif", Font.BOLD, 15));
        maxjavalabel.setFont(new Font("Serif", Font.BOLD, 15));
        flagslabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));
        gclabel.setFont(new Font("Serif", Font.BOLD, 18));
        jvmflaglabel.setFont(new Font("Serif", Font.BOLD, 18));
        gcthreadlabel.setFont(new Font("Serif", Font.BOLD, 12));
        largepage.setFont(new Font("Serif", Font.BOLD, 12));
        otherargslabel.setFont(new Font("Serif", Font.BOLD, 18));
        newprolabel.setFont(new Font("Serif", Font.HANGING_BASELINE, 20));

        //Scroll config
        scroll.getVerticalScrollBar().setUnitIncrement(16);

        javaframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Java Frame is closing");
            }
        });
    }
}
