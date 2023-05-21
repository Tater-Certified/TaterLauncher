package com.github.tatercertified.util;

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

public class JavaProfileGson {
    private static final String path = String.valueOf(Paths.get("TaterLauncher/java_profiles/profiles.json"));

    public static List<JavaProfile> readJavaProfilesFromFile() {
        Gson gson = new Gson();
        List<JavaProfile> javaProfiles;
        try (FileReader reader = new FileReader(path)) {
            Type listType = new TypeToken<List<JavaProfile>>() {}.getType();
            javaProfiles = gson.fromJson(reader, listType);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return javaProfiles;
    }
    public static void addJavaProfileToFile(JavaProfile javaProfile) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<JavaProfile> existingGameProfiles = readJavaProfilesFromFile();
        existingGameProfiles.add(javaProfile);
        try (FileWriter writer = new FileWriter(path)) {
            gson.toJson(existingGameProfiles, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void updateGameProfileInFile(JavaProfile updatedProfile, String original_name) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<JavaProfile> existingJavaProfiles = readJavaProfilesFromFile();

        // Find the index of the profile to update based on a unique identifier
        if (existingJavaProfiles != null) {
            int index = -1;
            for (int i = 0; i < existingJavaProfiles.size(); i++) {
                if (existingJavaProfiles.get(i).getProfileName().equals(original_name)) {
                    index = i;
                    break;
                }
            }

            if (index != -1) {
                // Update the existing profile with the updated profile
                existingJavaProfiles.set(index, updatedProfile);

                try (FileWriter writer = new FileWriter(path)) {
                    gson.toJson(existingJavaProfiles, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("Profile not found. Creating instead.");
            addJavaProfileToFile(updatedProfile);
        }
    }

    public static void writeJavaProfilePresets() {
        // Create JavaProfile presets
        List<JavaProfile> presets = new ArrayList<>();
        JavaProfile g1 = new JavaProfile();
        g1.presetG1GC();
        presets.add(g1);
        JavaProfile z = new JavaProfile();
        z.presetZGC();
        presets.add(z);
        JavaProfile shenandoah = new JavaProfile();
        shenandoah.presetShenandoahGC();
        presets.add(shenandoah);
        JavaProfile zgen = new JavaProfile();
        zgen.presetZGCGenerational();
        presets.add(zgen);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(presets);

        try (FileWriter writer = new FileWriter(path)) {
            // Write JSON to the file
            writer.write(json);
            System.out.println("JavaProfile presets written to file successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
