package io.github.qpcrummer.themes;

import javax.swing.*;
import java.awt.*;

import static io.github.qpcrummer.guis.ConfigGUI.*;
import static io.github.qpcrummer.guis.GUI.*;
import static io.github.qpcrummer.guis.JavaGUI.*;
import static io.github.qpcrummer.guis.UtilGUI.*;
import static io.github.qpcrummer.guis.VersionGUI.*;

public class Light {
    public static void initlight() {
        mainguilight();
        javaguilight();
        utilguilight();
        verguilight();
        configguilight();
    }

    public static void mainguilight() {
        panel.setBackground(Color.WHITE);

        buttonsubpanel.setBackground(Color.WHITE);
        topsubpanel.setBackground(Color.WHITE);
        leftsubpanel.setBackground(Color.WHITE);
        rightsubpanel.setBackground(Color.WHITE);

        launchername.setBackground(Color.BLACK);

        startbutton.setForeground(Color.BLACK);
        startbutton.setBackground(new Color(0, 200, 0));

        settingsbutton.setForeground(Color.BLACK);
        settingsbutton.setBackground(Color.WHITE);

        versionbutton.setForeground(Color.BLACK);
        versionbutton.setBackground(Color.LIGHT_GRAY);

        javabutton.setForeground(Color.BLACK);
        javabutton.setBackground(Color.LIGHT_GRAY);

        utilsbutton.setForeground(Color.BLACK);
        utilsbutton.setBackground(Color.WHITE);
    }

    public static void javaguilight() {
        UIManager.put( "control", new Color(209, 209, 209));
        UIManager.put( "info", new Color(128,128,128) );
        UIManager.put( "nimbusBase", new Color(209, 209, 209));
        UIManager.put( "nimbusAlertYellow", new Color( 248, 187, 0) );
        UIManager.put( "nimbusDisabledText", new Color( 128, 128, 128) );
        UIManager.put( "nimbusFocus", new Color(115,164,209) );
        UIManager.put( "nimbusGreen", new Color(176,179,50) );
        UIManager.put( "nimbusInfoBlue", new Color( 66, 139, 221) );
        UIManager.put( "nimbusLightBackground", new Color(209, 209, 209));
        UIManager.put( "nimbusOrange", new Color(191,98,4) );
        UIManager.put( "nimbusRed", new Color(169,46,34) );
        UIManager.put( "nimbusSelectedText", Color.WHITE );
        UIManager.put( "nimbusSelectionBackground", new Color( 104, 93, 156) );
        UIManager.put( "text", Color.BLACK );
        javafinder.updateUI();
        profilefinder.updateUI();

        profiles.setBackground(Color.WHITE);
        finderlabel.setForeground(Color.BLACK);
        newpro.setBackground(Color.WHITE);
        newprocombo.setBackground(Color.WHITE);

        newprofile.setForeground(Color.BLACK);
        newproname.setForeground(Color.BLACK);
        newprofile.setBackground(new Color(0, 200, 0));
        newproname.setBackground(new Color(209, 209, 209));

        path.setBackground(Color.WHITE);
        javalabel.setForeground(Color.BLACK);
        ram.setBackground(Color.WHITE);

        ramlabel.setForeground(Color.BLACK);
        minjava.setBackground(new Color(209, 209, 209));
        maxjava.setBackground(new Color(209, 209, 209));
        minjavalabel.setForeground(Color.BLACK);
        maxjavalabel.setForeground(Color.BLACK);

        flags.setBackground(Color.WHITE);

        flagslabel.setForeground(Color.BLACK);
        gclabel.setForeground(Color.BLACK);
        gcthreadlabel.setForeground(Color.BLACK);
        otherargslabel.setForeground(Color.BLACK);
        largepagescheck.setBackground(Color.WHITE);
        noexplicitcheck.setBackground(Color.WHITE);
        utf8check.setBackground(Color.WHITE);
        gcselect.setForeground(Color.BLACK);
        gcselect.setBackground(new Color(209, 209, 209));
        gcthreads.setForeground(Color.BLACK);
        gcthreads.setBackground(new Color(209, 209, 209));
        largepagesize.setBackground(new Color(209, 209, 209));
        otherargs.setBackground(new Color(209, 209, 209));
        largepagescheck.setForeground(Color.BLACK);
        noexplicitcheck.setForeground(Color.BLACK);
        utf8check.setForeground(Color.BLACK);
        largepage.setForeground(Color.BLACK);
        toggles.setForeground(Color.BLACK);
        amounts.setForeground(Color.BLACK);

        tabbedPane.setBackground(Color.WHITE);
        tabbedPane.setForeground(Color.BLACK);
        //Default JVM Profiles
        g1.setBackground(Color.WHITE);
        z.setBackground(Color.WHITE);
        shen.setBackground(Color.WHITE);
        g1title.setForeground(Color.BLACK);
        ztitle.setForeground(Color.BLACK);
        shentitle.setForeground(Color.BLACK);
        g1text.setForeground(Color.BLACK);
        ztext.setForeground(Color.BLACK);
        shentext.setForeground(Color.BLACK);
        g1text.setBackground(new Color(209, 209, 209));
        ztext.setBackground(new Color(209, 209, 209));
        shentext.setBackground(new Color(209, 209, 209));
        g1sel.setBackground(new Color(0, 200, 0));
        zsel.setBackground(new Color(0, 200, 0));
        shensel.setBackground(new Color(0, 200, 0));
        g1sel.setForeground(Color.BLACK);
        zsel.setForeground(Color.BLACK);
        shensel.setForeground(Color.BLACK);
    }

    public static void utilguilight() {
        togglespanel.setBackground(Color.WHITE);
        tatercape.setBackground(Color.WHITE);
        tatershoulder.setBackground(Color.WHITE);
        resourceusage.setBackground(Color.WHITE);
        tatertube.setBackground(Color.WHITE);
        rpc.setBackground(Color.WHITE);
        toggles.setForeground(Color.BLACK);
        tatercape.setForeground(Color.BLACK);
        tatershoulder.setForeground(Color.BLACK);
        resourceusage.setForeground(Color.BLACK);
        tatertube.setForeground(Color.BLACK);
        rpc.setForeground(Color.BLACK);

        appspanel.setBackground(Color.WHITE);
        apps.setForeground(Color.BLACK);
        noapps.setForeground(Color.BLACK);

        tabs.setBackground(Color.WHITE);
        tabs.setForeground(Color.BLACK);
    }

    public static void verguilight() {
        masterpanel.setBackground(Color.WHITE);
        versionpanel.setBackground(Color.WHITE);

        newverpanel.setBackground(Color.WHITE);
        verlabel.setForeground(Color.BLACK);
        newverlabel.setForeground(Color.BLACK);
        namever.setBackground(new Color(209, 209, 209));
        namever.setForeground(Color.BLACK);
        createver.setBackground(new Color(0, 200, 0));
        createver.setForeground(Color.BLACK);

        profile0.setBackground(Color.WHITE);
        select0.setBackground(new Color(0, 200, 0));
        select0.setForeground(Color.BLACK);
        label0.setForeground(Color.BLACK);
        ver0.setBackground(new Color(209, 209, 209));
        dir0.setBackground(new Color(209, 209, 209));
        dir0.setForeground(Color.BLACK);
        java0.setBackground(new Color(209, 209, 209));
        loader0.setBackground(new Color(209, 209, 209));

        profile1.setBackground(Color.WHITE);
        select1.setBackground(new Color(0, 200, 0));
        select1.setForeground(Color.BLACK);
        label1.setForeground(Color.BLACK);
        ver1.setBackground(new Color(209, 209, 209));
        dir1.setBackground(new Color(209, 209, 209));
        dir1.setForeground(Color.BLACK);
        java1.setBackground(new Color(209, 209, 209));
        loader1.setBackground(new Color(209, 209, 209));
    }

    public static void configguilight() {
        authpanel.setBackground(Color.WHITE);

        user.setForeground(Color.BLACK);
        pass.setForeground(Color.BLACK);
        username.setBackground(new Color(209, 209, 209));
        password.setBackground(new Color(209, 209, 209));
        username.setForeground(Color.BLACK);
        password.setForeground(Color.BLACK);

        themepanel.setBackground(Color.WHITE);
        themelabel.setForeground(Color.BLACK);
        dark.setBackground(Color.WHITE);
        dark.setForeground(Color.BLACK);

        tabPane.setBackground(Color.WHITE);
        tabPane.setForeground(Color.BLACK);
    }
}
