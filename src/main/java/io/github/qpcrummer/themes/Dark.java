package io.github.qpcrummer.themes;

import javax.swing.*;
import java.awt.*;

import static io.github.qpcrummer.guis.ConfigGUI.*;
import static io.github.qpcrummer.guis.GUI.*;
import static io.github.qpcrummer.guis.JavaGUI.*;
import static io.github.qpcrummer.guis.UtilGUI.*;
import static io.github.qpcrummer.guis.VersionGUI.*;

public class Dark {
    //Defaults
    public static Color darkpanel = new Color(44, 47, 51);
    public static Color darkbutton = new  Color(0, 140, 0);
    public static Color darktextbox = new Color(128,128,128);
    public static Color darkcheck = new Color(44, 47, 51);
    public static Color darktabs = new Color(44, 47, 51);
    public static Color darkcombo = new Color(128,128,128);
    public static Color darklabelforebig = new Color(153, 170, 181);
    public static Color darkbuttongreen = new Color(0, 140, 0);

    public static void initdark() {
        mainguidark();
        javaguidark();
        utilguidark();
        verguidark();
        configguidark();
    }
    //Main GUI
    public static void mainguidark() {
        panel.setBackground(new Color(153, 170, 181));

        buttonsubpanel.setBackground(new Color(44, 47, 51));
        topsubpanel.setBackground(new Color(35, 39, 42));
        leftsubpanel.setBackground(new Color(35, 39, 42));
        rightsubpanel.setBackground(new Color(35, 39, 42));

        launchername.setForeground(new Color(153, 170, 181));

        startbutton.setForeground(Color.WHITE);
        startbutton.setBackground(new Color(0, 100, 0));

        settingsbutton.setForeground(Color.WHITE);
        settingsbutton.setBackground(new Color(35, 39, 42));

        versionbutton.setForeground(Color.WHITE);
        versionbutton.setBackground(new Color(35, 39, 42));

        javabutton.setForeground(Color.WHITE);
        javabutton.setBackground(new Color(35, 39, 42));

        utilsbutton.setForeground(Color.WHITE);
        utilsbutton.setBackground(new Color(35, 39, 42));
    }
    //Java GUI
    public static void javaguidark() {
        UIManager.put( "control", new Color( 128, 128, 128) );
        UIManager.put( "info", new Color(128,128,128) );
        UIManager.put( "nimbusBase", new Color(44, 47, 51));
        UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
        UIManager.put( "nimbusDisabledText", new Color( 128, 128, 128) );
        UIManager.put( "nimbusFocus", new Color(115,164,209) );
        UIManager.put( "nimbusGreen", new Color(176,179,50) );
        UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
        UIManager.put( "nimbusLightBackground", new Color(44, 47, 51) );
        UIManager.put( "nimbusOrange", new Color(191,98,4) );
        UIManager.put( "nimbusRed", new Color(169,46,34) );
        UIManager.put( "nimbusSelectedText", Color.WHITE );
        UIManager.put( "nimbusSelectionBackground", new Color( 104, 93, 156) );
        UIManager.put( "text", Color.WHITE );
        javafinder.updateUI();
        profilefinder.updateUI();

        profiles.setBackground(darkpanel);
        finderlabel.setForeground(darklabelforebig);
        newpro.setBackground(darkpanel);
        newprocombo.setBackground(darkpanel);

        newprofile.setForeground(Color.WHITE);
        newproname.setForeground(Color.WHITE);
        newprofile.setBackground(darkbutton);
        newproname.setBackground(darktextbox);

        path.setBackground(darkpanel);
        javalabel.setForeground(darklabelforebig);
        ram.setBackground(darkpanel);

        ramlabel.setForeground(darklabelforebig);
        minjava.setBackground(darktextbox);
        maxjava.setBackground(darktextbox);
        minjavalabel.setForeground(darklabelforebig);
        maxjavalabel.setForeground(darklabelforebig);

        flags.setBackground(darkpanel);

        flagslabel.setForeground(darklabelforebig);
        gclabel.setForeground(darklabelforebig);
        gcthreadlabel.setForeground(darklabelforebig);
        otherargslabel.setForeground(darklabelforebig);
        largepagescheck.setBackground(darkcheck);
        noexplicitcheck.setBackground(darkcheck);
        utf8check.setBackground(darkcheck);
        gcselect.setBackground(darkcombo);
        gcthreads.setBackground(darktextbox);
        largepagesize.setBackground(darktextbox);
        otherargs.setBackground(darktextbox);
        largepagescheck.setForeground(Color.WHITE);
        noexplicitcheck.setForeground(Color.WHITE);
        utf8check.setForeground(Color.WHITE);
        largepage.setForeground(darklabelforebig);
        jvmtoggles.setForeground(darklabelforebig);
        amounts.setForeground(darklabelforebig);

        tabbedPane.setBackground(darktabs);
        tabbedPane.setForeground(Color.WHITE);

        //Default JVM Profiles
        presets.setBackground(darkpanel);
        g1.setBackground(darkpanel);
        z.setBackground(darkpanel);
        shen.setBackground(darkpanel);
        g1title.setForeground(darklabelforebig);
        ztitle.setForeground(darklabelforebig);
        shentitle.setForeground(darklabelforebig);
        g1text.setForeground(Color.WHITE);
        ztext.setForeground(Color.WHITE);
        shentext.setForeground(Color.WHITE);
        g1text.setBackground(darktextbox);
        ztext.setBackground(darktextbox);
        shentext.setBackground(darktextbox);
        g1sel.setBackground(new Color(0, 100, 0));
        zsel.setBackground(new Color(0, 100, 0));
        shensel.setBackground(new Color(0, 100, 0));
        g1sel.setForeground(Color.WHITE);
        zsel.setForeground(Color.WHITE);
        shensel.setForeground(Color.WHITE);
    }
    //Utils GUI
    public static void utilguidark() {
        togglespanel.setBackground(darkpanel);
        tatercape.setBackground(darkcheck);
        tatershoulder.setBackground(darkcheck);
        resourceusage.setBackground(darkcheck);
        tatertube.setBackground(darkcheck);
        rpc.setBackground(darkcheck);
        toggles.setForeground(darklabelforebig);
        tatercape.setForeground(Color.WHITE);
        tatershoulder.setForeground(Color.WHITE);
        resourceusage.setForeground(Color.WHITE);
        tatertube.setForeground(Color.WHITE);
        rpc.setForeground(Color.WHITE);

        appspanel.setBackground(darkpanel);
        apps.setForeground(darklabelforebig);
        noapps.setForeground(darklabelforebig);

        tabs.setBackground(darktabs);
        tabs.setForeground(Color.WHITE);

        //Linux Warning
        warnpanel.setBackground(darkpanel);
        warnlabel.setForeground(darklabelforebig);
        warnconfirm.setBackground(new Color(100,0,0));
        warnconfirm.setForeground(Color.WHITE);
    }
    //Version GUI
    public static void verguidark() {
        masterpanel.setBackground(darkpanel);
        versionpanel.setBackground(darkpanel);

        newverpanel.setBackground(darkpanel);
        verlabel.setForeground(darklabelforebig);
        newverlabel.setForeground(darklabelforebig);
        namever.setBackground(darktextbox);
        namever.setForeground(Color.WHITE);
        createver.setBackground(darkbutton);
        createver.setForeground(Color.WHITE);

        profile0.setBackground(darkpanel);
        select0.setBackground(darkbuttongreen);
        select0.setForeground(Color.WHITE);
        label0.setForeground(Color.WHITE);
        ver0.setBackground(darkcombo);
        dir0.setBackground(darktextbox);
        dir0.setForeground(Color.WHITE);
        java0.setBackground(darkcombo);
        loader0.setBackground(darkcombo);

        profile1.setBackground(darkpanel);
        select1.setBackground(darkbuttongreen);
        select1.setForeground(Color.WHITE);
        label1.setForeground(Color.WHITE);
        ver1.setBackground(darkcombo);
        dir1.setBackground(darktextbox);
        dir1.setForeground(Color.WHITE);
        java1.setBackground(darkcombo);
        loader1.setBackground(darkcombo);
    }
    //Config GUI
    public static void configguidark() {
        authpanel.setBackground(darkpanel);

        user.setForeground(darklabelforebig);
        pass.setForeground(darklabelforebig);
        username.setBackground(darktextbox);
        password.setBackground(darktextbox);
        username.setForeground(Color.WHITE);
        password.setForeground(Color.WHITE);

        themepanel.setBackground(darkpanel);
        themelabel.setForeground(darklabelforebig);
        dark.setBackground(darkcheck);
        dark.setForeground(Color.WHITE);

        tabPane.setBackground(darktabs);
        tabPane.setForeground(Color.WHITE);
    }
}
