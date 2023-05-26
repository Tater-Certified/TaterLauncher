package com.github.tatercertified.launch;

import com.github.tatercertified.auth.MSAuth;
import com.github.tatercertified.guis.MSAccountGUI;
import com.github.tatercertified.tatertester.DownloadLoaders;
import com.github.tatercertified.tatertester.DownloadMCV2;
import com.github.tatercertified.util.GameProfile;
import com.github.tatercertified.util.JavaProfile;

import javax.swing.*;
import java.io.IOException;

public class LaunchMinecraft {
    public static void launchMC(GameProfile launch, JButton startbutton) {
        if (!MSAuth.isAuthenticated) {
            startbutton.setText("Please Authenticate With Microsoft");
            return;
        }
        checkForPrelaunchTasks(launch);
        String auth_token = MSAuth.loginMicrosoft(MSAccountGUI.username.getText(), MSAccountGUI.password.getText());
        String version = launch.getVersion();
        JavaProfile jvm = launch.getJavaProfile();

        // TODO Add Java Profile Argument Builder
        String[] command = {String.valueOf(jvm.getJavaPath()), "-Xms6G -Xmx6G -XX:+UseG1GC -XX:+DisableExplicitGC", "-Dlog4j2.formatMsgNoLookups=true", "-Dlog4j.configurationFile=assets/log_configs/client-1.12.xml", "-Djava.library.path=versions/"+version+"/natives", "-cp", "libraries/io/netty/netty-all/4.1.68.Final/netty-all-4.1.68.Final.jar;libraries/com/google/code/gson/gson/2.8.9/gson-2.8.9.jar;libraries/org/apache/httpcomponents/httpclient/4.5.13/httpclient-4.5.13.jar;libraries/org/apache/commons/commons-compress/1.21/commons-compress-1.21.jar;libraries/org/lwjgl/lwjgl-glfw/3.2.2/lwjgl-glfw-3.2.2.jar;libraries/ca/weblite/java-objc-bridge/1.0.0/java-objc-bridge-1.0.0.jar;libraries/com/google/guava/failureaccess/1.0.1/failureaccess-1.0.1.jar;libraries/net/sf/jopt-simple/jopt-simple/5.0.4/jopt-simple-5.0.4.jar;libraries/commons-logging/commons-logging/1.2/commons-logging-1.2.jar;libraries/org/lwjgl/lwjgl-openal/3.2.2/lwjgl-openal-3.2.2.jar;libraries/org/slf4j/slf4j-api/1.8.0-beta4/slf4j-api-1.8.0-beta4.jar;libraries/com/mojang/logging/1.0.0/logging-1.0.0.jar;libraries/org/lwjgl/lwjgl/3.2.2/lwjgl-3.2.2.jar;libraries/org/lwjgl/lwjgl-opengl/3.2.2/lwjgl-opengl-3.2.2.jar;libraries/com/mojang/patchy/2.2.10/patchy-2.2.10.jar;libraries/org/apache/logging/log4j/log4j-core/2.17.0/log4j-core-2.17.0.jar;libraries/org/apache/logging/log4j/log4j-api/2.17.0/log4j-api-2.17.0.jar;libraries/org/lwjgl/lwjgl-stb/3.2.2/lwjgl-stb-3.2.2.jar;libraries/net/java/dev/jna/jna/5.10.0/jna-5.10.0.jar;libraries/com/mojang/text2speech/1.12.4/text2speech-1.12.4.jar;libraries/com/github/oshi/oshi-core/5.8.5/oshi-core-5.8.5.jar;libraries/org/lwjgl/lwjgl-jemalloc/3.2.2/lwjgl-jemalloc-3.2.2.jar;libraries/com/ibm/icu/icu4j/70.1/icu4j-70.1.jar;libraries/commons-io/commons-io/2.11.0/commons-io-2.11.0.jar;libraries/it/unimi/dsi/fastutil/8.5.6/fastutil-8.5.6.jar;libraries/commons-codec/commons-codec/1.15/commons-codec-1.15.jar;libraries/com/mojang/authlib/3.3.39/authlib-3.3.39.jar;libraries/com/mojang/brigadier/1.0.18/brigadier-1.0.18.jar;libraries/net/java/dev/jna/jna-platform/5.10.0/jna-platform-5.10.0.jar;libraries/com/mojang/javabridge/1.2.24/javabridge-1.2.24.jar;libraries/com/google/guava/guava/31.0.1-jre/guava-31.0.1-jre.jar;libraries/org/apache/commons/commons-lang3/3.12.0/commons-lang3-3.12.0.jar;libraries/com/mojang/blocklist/1.0.10/blocklist-1.0.10.jar;libraries/org/apache/logging/log4j/log4j-slf4j18-impl/2.17.0/log4j-slf4j18-impl-2.17.0.jar;libraries/org/lwjgl/lwjgl-tinyfd/3.2.2/lwjgl-tinyfd-3.2.2.jar;libraries/com/mojang/datafixerupper/4.1.27/datafixerupper-4.1.27.jar;libraries/org/lwjgl/lwjgl-jemalloc/3.2.2/lwjgl-jemalloc-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl-opengl/3.2.2/lwjgl-opengl-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl-stb/3.2.2/lwjgl-stb-3.2.2-natives-windows.jar;libraries/com/mojang/text2speech/1.12.4/text2speech-1.12.4-natives-windows.jar;libraries/org/lwjgl/lwjgl-glfw/3.2.2/lwjgl-glfw-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl-tinyfd/3.2.2/lwjgl-tinyfd-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl/3.2.2/lwjgl-3.2.2-natives-windows.jar;libraries/org/lwjgl/lwjgl-openal/3.2.2/lwjgl-openal-3.2.2-natives-windows.jar;versions/"+version+"/"+version+".jar", "net.minecraft.client.main.Main", "--username", "Name", "--version", version, "--gameDir", ".", "--assetsDir", "assets", "--assetIndex", version, "--uuid", "0f28983a46ce33b1aed45cdc95bf44c3", "--accessToken", auth_token, "--clientId", "0000", "--xuid", "0000", "--userType", "mojang", "--versionType", "release"};
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.directory(launch.getPath().toFile());
        boolean launched;
        try {
            builder.start();
            launched = true;
        } catch (IOException ex) {
            ex.printStackTrace();
            launched = false;
        }
        if (launched) {
            System.exit(0);
        } else {
            startbutton.setText("Minecraft Launch Failed");
        }
    }

    private static void checkForPrelaunchTasks(GameProfile profile) {
        if (profile.needsInstallations()) {
            DownloadMCV2.downloadMojankJar(profile.getVersion(), profile.getPath().toString(), profile.getLoader() + "-" + profile.getVersion(), profile.isFullInstall());
            DownloadLoaders.downloadLoader(profile.getLoader(), profile.getLoaderVer(), null, profile.isFullInstall());

            profile.setFullInstall(false);
            profile.setNeedsInstallations(false);
        }
    }
}
