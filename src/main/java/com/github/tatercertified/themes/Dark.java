package com.github.tatercertified.themes;

import com.github.tatercertified.guis.ConfigGUI;
import com.github.tatercertified.guis.UtilGUI;
import com.github.tatercertified.guis.profiles.VersionGUI;

import javax.swing.*;
import java.awt.*;

import static com.github.tatercertified.guis.GUI.*;
import static com.github.tatercertified.guis.JavaGUI.*;

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
        UtilGUI.togglespanel.setBackground(darkpanel);
        UtilGUI.tatercape.setBackground(darkcheck);
        UtilGUI.tatershoulder.setBackground(darkcheck);
        UtilGUI.resourceusage.setBackground(darkcheck);
        UtilGUI.tatertube.setBackground(darkcheck);
        UtilGUI.rpc.setBackground(darkcheck);
        UtilGUI.loading.setBackground(darkcheck);
        UtilGUI.toggles.setForeground(darklabelforebig);
        UtilGUI.tatercape.setForeground(Color.WHITE);
        UtilGUI.tatershoulder.setForeground(Color.WHITE);
        UtilGUI.resourceusage.setForeground(Color.WHITE);
        UtilGUI.tatertube.setForeground(Color.WHITE);
        UtilGUI.rpc.setForeground(Color.WHITE);
        UtilGUI.loading.setForeground(Color.WHITE);

        UtilGUI.appspanel.setBackground(darkpanel);
        UtilGUI.apps.setForeground(darklabelforebig);
        UtilGUI.noapps.setForeground(darklabelforebig);

        UtilGUI.tabs.setBackground(darktabs);
        UtilGUI.tabs.setForeground(Color.WHITE);
    }
    //Version GUI
    public static void verguidark() {
        VersionGUI.masterpanel.setBackground(darkpanel);
        VersionGUI.versionpanel.setBackground(darkpanel);

        VersionGUI.newverpanel.setBackground(darkpanel);
        VersionGUI.verlabel.setForeground(darklabelforebig);
        VersionGUI.newverlabel.setForeground(darklabelforebig);
        VersionGUI.namever.setBackground(darktextbox);
        VersionGUI.namever.setForeground(Color.WHITE);
        VersionGUI.createver.setBackground(darkbutton);
        VersionGUI.createver.setForeground(Color.WHITE);

        VersionGUI.profile0.setBackground(darkpanel);
        VersionGUI.select0.setBackground(darkbuttongreen);
        VersionGUI.select0.setForeground(Color.WHITE);
        VersionGUI.label0.setForeground(Color.WHITE);
        VersionGUI.ver0.setBackground(darkcombo);
        VersionGUI.dir0.setBackground(darktextbox);
        VersionGUI.dir0.setForeground(Color.WHITE);
        VersionGUI.java0.setBackground(darkcombo);
        VersionGUI.loader0.setBackground(darkcombo);

        VersionGUI.profile1.setBackground(darkpanel);
        VersionGUI.select1.setBackground(darkbuttongreen);
        VersionGUI.select1.setForeground(Color.WHITE);
        VersionGUI.label1.setForeground(Color.WHITE);
        VersionGUI.ver1.setBackground(darkcombo);
        VersionGUI.dir1.setBackground(darktextbox);
        VersionGUI.dir1.setForeground(Color.WHITE);
        VersionGUI.java1.setBackground(darkcombo);
        VersionGUI.loader1.setBackground(darkcombo);
    }
    //Config GUI
    public static void configguidark() {
        ConfigGUI.authpanel.setBackground(darkpanel);

        ConfigGUI.user.setForeground(darklabelforebig);
        ConfigGUI.pass.setForeground(darklabelforebig);
        ConfigGUI.username.setBackground(darktextbox);
        ConfigGUI.password.setBackground(darktextbox);
        ConfigGUI.username.setForeground(Color.WHITE);
        ConfigGUI.password.setForeground(Color.WHITE);

        ConfigGUI.themepanel.setBackground(darkpanel);
        ConfigGUI.themelabel.setForeground(darklabelforebig);
        ConfigGUI.dark.setBackground(darkcheck);
        ConfigGUI.dark.setForeground(Color.WHITE);

        ConfigGUI.tabPane.setBackground(darktabs);
        ConfigGUI.tabPane.setForeground(Color.WHITE);
    }
}
