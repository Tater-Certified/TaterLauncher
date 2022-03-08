package io.github.qpcrummer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Path;

public class ProfileManagers {
    private static final Path GAME_PROFILE_PATH = Path.of("TaterLauncher/game_profiles");
    private static final Path JAVA_PROFILE_PATH = Path.of("TaterLauncher/java_profiles");

    public static void createGameProfile(GameProfile profile) {
        try {
            String profileName = profile.getProfileName();
            Writer writer = new FileWriter(GAME_PROFILE_PATH + "/" + profileName + ".json");

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            String jsonString = gson.toJson(profile);

            writer.write(jsonString);
            writer.close();

            loadGameProfile(profileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static GameProfile loadGameProfile(String profileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(GAME_PROFILE_PATH + "/" + profileName + ".json"));
            return new Gson().fromJson(reader, GameProfile.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void createJavaProfile(JavaProfile profile) {
        try {
            String profileName = profile.getProfileName();
            Writer writer = new FileWriter(GAME_PROFILE_PATH + "/" + profileName + ".json");

            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            String jsonString = gson.toJson(profile);

            writer.write(jsonString);
            writer.close();

            loadGameProfile(profileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JavaProfile loadJavaProfile(String profileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(GAME_PROFILE_PATH + "/" + profileName + ".json"));
            return new Gson().fromJson(reader, JavaProfile.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
