package io.github.qpcrummer.launch;

import java.io.File;
import java.io.IOException;

public class MinecraftLaunch {
    public static void launchmc() {
        String[] command = {"E:\\Minecraft\\Java\\Corretto 17\\bin\\javaw.exe\" -Xmx700M -Xss1M -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:G1NewSizePercent=20 -XX:G1ReservePercent=20 -XX:MaxGCPauseMillis=50 -XX:G1HeapRegionSize=32M -Dlog4j2.formatMsgNoLookups=true -Dlog4j.configurationFile=assets\\log_configs\\client-1.12.xml \"-Djava.library.path=versions\\1.18.1\\natives\"   \"-cp\" \"libraries\\com\\mojang\\blocklist\\1.0.6\\blocklist-1.0.6.jar;libraries\\com\\mojang\\patchy\\2.1.6\\patchy-2.1.6.jar;libraries\\com\\github\\oshi\\oshi-core\\5.8.2\\oshi-core-5.8.2.jar;libraries\\net\\java\\dev\\jna\\jna\\5.9.0\\jna-5.9.0.jar;libraries\\net\\java\\dev\\jna\\jna-platform\\5.9.0\\jna-platform-5.9.0.jar;libraries\\org\\slf4j\\slf4j-api\\1.8.0-beta4\\slf4j-api-1.8.0-beta4.jar;libraries\\org\\apache\\logging\\log4j\\log4j-slf4j18-impl\\2.14.1\\log4j-slf4j18-impl-2.14.1.jar;libraries\\com\\ibm\\icu\\icu4j\\69.1\\icu4j-69.1.jar;libraries\\com\\mojang\\javabridge\\1.2.24\\javabridge-1.2.24.jar;libraries\\net\\sf\\jopt-simple\\jopt-simple\\5.0.4\\jopt-simple-5.0.4.jar;libraries\\io\\netty\\netty-all\\4.1.68.Final\\netty-all-4.1.68.Final.jar;libraries\\com\\google\\guava\\failureaccess\\1.0.1\\failureaccess-1.0.1.jar;libraries\\com\\google\\guava\\guava\\31.0.1-jre\\guava-31.0.1-jre.jar;libraries\\org\\apache\\commons\\commons-lang3\\3.12.0\\commons-lang3-3.12.0.jar;libraries\\commons-io\\commons-io\\2.11.0\\commons-io-2.11.0.jar;libraries\\commons-codec\\commons-codec\\1.15\\commons-codec-1.15.jar;libraries\\com\\mojang\\brigadier\\1.0.18\\brigadier-1.0.18.jar;libraries\\com\\mojang\\datafixerupper\\4.0.26\\datafixerupper-4.0.26.jar;libraries\\com\\google\\code\\gson\\gson\\2.8.8\\gson-2.8.8.jar;libraries\\com\\mojang\\authlib\\3.2.38\\authlib-3.2.38.jar;libraries\\org\\apache\\commons\\commons-compress\\1.21\\commons-compress-1.21.jar;libraries\\org\\apache\\httpcomponents\\httpclient\\4.5.13\\httpclient-4.5.13.jar;libraries\\commons-logging\\commons-logging\\1.2\\commons-logging-1.2.jar;libraries\\org\\apache\\httpcomponents\\httpcore\\4.4.14\\httpcore-4.4.14.jar;libraries\\it\\unimi\\dsi\\fastutil\\8.5.6\\fastutil-8.5.6.jar;libraries\\org\\apache\\logging\\log4j\\log4j-api\\2.14.1\\log4j-api-2.14.1.jar;libraries\\org\\apache\\logging\\log4j\\log4j-core\\2.14.1\\log4j-core-2.14.1.jar;libraries\\org\\lwjgl\\lwjgl\\3.2.2\\lwjgl-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-jemalloc\\3.2.2\\lwjgl-jemalloc-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-openal\\3.2.2\\lwjgl-openal-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-opengl\\3.2.2\\lwjgl-opengl-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-glfw\\3.2.2\\lwjgl-glfw-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-stb\\3.2.2\\lwjgl-stb-3.2.2.jar;libraries\\org\\lwjgl\\lwjgl-tinyfd\\3.2.2\\lwjgl-tinyfd-3.2.2.jar;libraries\\com\\mojang\\text2speech\\1.11.3\\text2speech-1.11.3.jar;versions\\1.18.1\\1.18.1.jar\" net.minecraft.client.main.Main --username Name --version 1.18.1 --gameDir . --assetsDir assets --assetIndex 1.18 --uuid 0f28983a46ce33b1aed45cdc95bf44c3 --accessToken 00000000000000000000000000000000 --clientId 0000 --xuid 0000 --userType mojang --versionType release"};
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.directory(new File("C:\\Users\\qpcru\\Downloads"));
        try {
            Process process = builder.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.exit(0);
    }
}
