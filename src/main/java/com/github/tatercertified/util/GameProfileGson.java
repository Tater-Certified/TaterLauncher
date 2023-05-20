package com.github.tatercertified.util;

import com.github.tatercertified.GameProfile;
import com.github.tatercertified.JavaProfile;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GameProfileGson {
    private static final String path = String.valueOf(Paths.get("TaterLauncher/game_profiles/profiles.json"));

    public static List<GameProfile> readGameProfilesFromFile() {
        Gson gson = new Gson();
        List<GameProfile> gameProfiles;
        try (FileReader reader = new FileReader(path)) {
            Type listType = new TypeToken<List<GameProfile>>() {}.getType();
            gameProfiles = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return gameProfiles;
    }
    public static void addGameProfileToFile(GameProfile gameProfile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<GameProfile> existingGameProfiles = readGameProfilesFromFile();
        existingGameProfiles.add(gameProfile);
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(existingGameProfiles, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateGameProfileInFile(GameProfile updatedProfile, String original_name) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<GameProfile> existingGameProfiles = readGameProfilesFromFile();

        // Find the index of the profile to update based on a unique identifier
        if (existingGameProfiles != null) {
            int index = -1;
            for (int i = 0; i < existingGameProfiles.size(); i++) {
                if (existingGameProfiles.get(i).getProfileName().equals(original_name)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                // Update the existing profile with the updated profile
                existingGameProfiles.set(index, updatedProfile);

                try (FileWriter writer = new FileWriter(path)) {
                    gson.toJson(existingGameProfiles, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Profile not found. Creating instead.");
            addGameProfileToFile(updatedProfile);
        }
    }

    public static void writeSampleGameProfile() {
        // Create a sample GameProfile
        GameProfile gameProfile = new GameProfile();
        gameProfile.setLoader("Vanilla");
        gameProfile.setLoaderSnapshot(false);
        gameProfile.setJavaProfile(new JavaProfile());
        gameProfile.setPath(Paths.get("Example"));
        gameProfile.setProfileName("Example");
        gameProfile.setVersion("1.19.4");
        gameProfile.setSnapshot(false);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<GameProfile> example = new ArrayList<>();

        example.add(gameProfile);

        String json = gson.toJson(example);

        try (FileWriter writer = new FileWriter(path)) {
            // Write JSON to the file
            writer.write(json);
            System.out.println("Sample GameProfile written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
