package io.github.qpcrummer;

import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;

import static io.github.qpcrummer.guis.JavaGUI.*;


public class JavaProfile {
    //Variables
    public static String jvmpathVar = String.valueOf(javafinder.getSelectedFile());
    public static String minRamVar = minjava.getText();
    public static String maxRamVar = maxjava.getText();
    public static String threadVar = gcthreads.getText();
    public static String argotherVar = otherargs.getText();
    public static String lrgpgsizeVar = largepagesize.getText();
    public static String gcVar = (String) gcselect.getSelectedItem();
    public static String lrgpgVar = String.valueOf(largepagescheck.isSelected());
    public static String explicitVar = String.valueOf(noexplicitcheck.isSelected());
    public static String utf8Var = String.valueOf(utf8check.isSelected());


    public static String profileName = newproname.getText();

    public static YamlFile JAVA_FILE = new YamlFile("TaterLauncher/java_profiles/"+profileName+".yml");

    public static void javaProfileCreate() {
        YamlFile JAVA_FILE = new YamlFile("TaterLauncher/java_profiles/"+profileName+".yml");
        try {
            if (!JAVA_FILE.exists()) {
                System.out.println("Creating Profile");
                JAVA_FILE.createNewFile(false);
                System.out.println("Profile created!");
            } else {
                System.out.println("Profile Already Exists");
            }
        } catch (final Exception e) {
            System.out.println("Error while creating profile: " + e.getMessage());
        }
        //Data
        JAVA_FILE.addDefault("jvm.path", jvmpathVar);
        JAVA_FILE.addDefault("jvm.minram", minRamVar);
        JAVA_FILE.addDefault("jvm.maxram", maxRamVar);
        JAVA_FILE.addDefault("jvm.gc", gcVar);
        JAVA_FILE.addDefault("arg.lrgpg", lrgpgVar);
        JAVA_FILE.addDefault("arg.lrgpgsize", lrgpgsizeVar);
        JAVA_FILE.addDefault("arg.explicit", explicitVar);
        JAVA_FILE.addDefault("arg.utf8", utf8Var);
        JAVA_FILE.addDefault("arg.threads", threadVar);
        JAVA_FILE.addDefault("arg.other", argotherVar);

        // Saving
        try {
            JAVA_FILE.save();
        } catch (IOException e) {
            System.out.println("Error saving profile: " + e.getMessage());
        }
    }

    //Use for other classes to save

    public static YamlFile getConfig() {
        return JAVA_FILE;
    }

    public static void getJavaSelection() {
        jvmpathVar = String.valueOf(javafinder.getSelectedFile());
        minRamVar = minjava.getText();
        maxRamVar = maxjava.getText();
        threadVar = gcthreads.getText();
        argotherVar = otherargs.getText();
        gcVar = (String) gcselect.getSelectedItem();
        lrgpgVar = String.valueOf(largepagescheck.isSelected());
        lrgpgsizeVar = largepagesize.getText();
        explicitVar = String.valueOf(noexplicitcheck.isSelected());
        utf8Var = String.valueOf(utf8check.isSelected());
    }
    public static void saveJavaProfile() {
        JavaProfile.getConfig().set("jvm.path", jvmpathVar);
        JavaProfile.getConfig().set("jvm.minram", minRamVar);
        JavaProfile.getConfig().set("jvm.maxram", maxRamVar);
        JavaProfile.getConfig().set("jvm.gc", gcVar);
        JavaProfile.getConfig().set("arg.lrgpg", lrgpgVar);
        JavaProfile.getConfig().set("arg.lrgpgsize", lrgpgsizeVar);
        JavaProfile.getConfig().set("arg.explicit", explicitVar);
        JavaProfile.getConfig().set("arg.utf8", utf8Var);
        JavaProfile.getConfig().set("arg.threads", threadVar);
        JavaProfile.getConfig().set("arg.other", argotherVar);

        try {
            JavaProfile.getConfig().save();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JavaProfile.getConfig();
    }
    public static void defaultJavaProfile() {
        minjava.setText("Use M for megabytes and G for gigabytes");
        maxjava.setText("Use M for megabytes and G for gigabytes");
        gcthreads.setText("If set to 0, it will use as many as needed");
        otherargs.setText("");
        largepagesize.setText("Use M for megabytes");
        gcselect.setSelectedItem("Parallel");
        largepagescheck.setSelected(false);
        noexplicitcheck.setSelected(false);
        utf8check.setSelected(false);
    }
    public static void g1JavaProfile() {
        minjava.setText("2G");
        maxjava.setText("4G");
        gcthreads.setText("0");
        otherargs.setText("-Xmn384m -XX:+AggressiveOpts -XX:+AlwaysPreTouch -XX:+ParallelRefProcEnabled -XX:+PerfDisableSharedMem -XX:+UseCompressedOops -XX:-UsePerfData -XX:MaxGCPauseMillis=200 -XX:ParallelGCThreads=4 -XX:ConcGCThreads=2 -XX:+UseTransparentHugePages -XX:+UseNUMA -XX:InitiatingHeapOccupancyPercent=50 -XX:G1HeapRegionSize=1 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=8");
        largepagesize.setText("2M");
        gcselect.setSelectedItem("G1");
        largepagescheck.setSelected(true);
        noexplicitcheck.setSelected(true);
        utf8check.setSelected(true);
        getJavaSelection();
        saveJavaProfile();
    }
    public static void zJavaProfile() {
        minjava.setText("2G");
        maxjava.setText("4G");
        gcthreads.setText("0");
        otherargs.setText("-Xmn384m -XX:+UnlockExperimentalVMOptions -XX:+IgnoreUnrecognizedVMOptions -XX:+UnlockDiagnosticVMOptions -XX:-OmitStackTraceInFastThrow -XX:+ShowCodeDetailsInExceptionMessages -XX:-UseParallelGC -XX:-UseParallelOldGC -XX:+PerfDisableSharedMem -XX:-ZUncommit -XX:ZUncommitDelay=300 -XX:ZCollectionInterval=5 -XX:ZAllocationSpikeTolerance=2.0 -XX:+UseTransparentHugePages -XX:+ParallelRefProcEnabled -XX:+UseNUMA -XX:+AlwaysPreTouch -XX:-UseBiasedLocking");
        largepagesize.setText("2M");
        gcselect.setSelectedItem("Z");
        largepagescheck.setSelected(true);
        noexplicitcheck.setSelected(true);
        utf8check.setSelected(true);
        getJavaSelection();
        saveJavaProfile();
    }
    public static void shenJavaProfile() {
        minjava.setText("2G");
        maxjava.setText("4G");
        gcthreads.setText("0");
        otherargs.setText("-Xmn384m -XX:+UnlockExperimentalVMOptions -XX:ShenandoahGCMode=iu -XX:+UseTransparentHugePages -XX:+UseNUMA -XX:+AlwaysPreTouch -XX:-UseBiasedLocking");
        largepagesize.setText("2M");
        gcselect.setSelectedItem("Shenandoah");
        largepagescheck.setSelected(true);
        noexplicitcheck.setSelected(true);
        utf8check.setSelected(true);
        getJavaSelection();
        saveJavaProfile();
    }
}
