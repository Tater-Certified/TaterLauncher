package com.github.tatercertified.tatertester;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DownloadMCV2 {
    private static final String url = "https://piston-meta.mojang.com/mc/game/version_manifest_v2.json";
    public static List<String> getAllMojankVersions(boolean snapshots) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            reader.close();

            // Parse the JSON data using GSON
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonContent.toString(), JsonObject.class);
            JsonArray versionsArray = jsonObject.getAsJsonArray("versions");
            List<String> versionList = new ArrayList<>();
            for (JsonElement element : versionsArray) {
                JsonObject versionObject = element.getAsJsonObject();
                String type = versionObject.get("type").getAsString();
                if (!snapshots && Objects.equals(type, "snapshot")) {
                    continue;
                }
                String version = versionObject.get("id").getAsString();
                versionList.add(version);
            }
            return versionList;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean downloadMojankJar(String version, String directory, String file_name) {
        try {
            URL json = new URL(getVersionJson(version));

            // Open a connection to the URL and read the JSON data
            BufferedReader reader = new BufferedReader(new InputStreamReader(json.openStream()));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            reader.close();

            // Parse the JSON data using GSON
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonContent.toString(), JsonObject.class);
            JsonObject downloadsObject = jsonObject.getAsJsonObject("downloads");
            JsonObject clientObject = downloadsObject.getAsJsonObject("client");
            String clientJarUrl = clientObject.get("url").getAsString();

            return downloadClient(clientJarUrl, directory, file_name, version);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getVersionJson(String version) {
        try {
            // Open a connection to the URL and read the JSON data
            BufferedReader reader = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            StringBuilder jsonContent = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonContent.append(line);
            }
            reader.close();

            // Parse the JSON data using GSON
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonContent.toString(), JsonObject.class);
            JsonArray versionsArray = jsonObject.getAsJsonArray("versions");
            for (JsonElement element : versionsArray) {
                JsonObject versionObject = element.getAsJsonObject();
                String version1 = versionObject.get("id").getAsString();
                if (version1.equals(version)) {
                    return versionObject.get("url").getAsString();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static boolean downloadClient(String fileUrl, String directory, String fileName, String version) {
        prepareMinecraftDirectoryFolders(directory);
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(directory + "/versions/" + fileName + ".jar")) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            return DownloadLibraries.downloadRequiredLibraries(getVersionJson(version));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    private static void prepareMinecraftDirectoryFolders(String directory) {
        Path main = Paths.get(directory);

        if (Files.notExists(main)) {
            try {
                Files.createDirectories(main);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Files.createDirectories(Path.of(main + "/versions"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
