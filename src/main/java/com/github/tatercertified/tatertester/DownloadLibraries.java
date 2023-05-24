package com.github.tatercertified.tatertester;

import com.github.tatercertified.Startup;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DownloadLibraries {
    static boolean downloadRequiredLibraries(String jsonURL) {
        try {
            // Fetch the JSON data from the URL
            URL url = new URL(jsonURL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            JsonObject jsonObject = JsonParser.parseReader(reader).getAsJsonObject();
            reader.close();

            // Retrieve the libraries array
            JsonArray librariesArray = jsonObject.getAsJsonArray("libraries");

            // Determine the OS name
            String osName = System.getProperty("os.name").toLowerCase();
            boolean isWindows = osName.contains("win");
            boolean isMac = osName.contains("mac");
            boolean isLinux = osName.contains("nix") || osName.contains("nux");

            // Iterate through the libraries
            for (int i = 0; i < librariesArray.size(); i++) {
                JsonObject libraryObject = librariesArray.get(i).getAsJsonObject();

                // Retrieve the artifact object
                JsonObject downloadsObject = libraryObject.getAsJsonObject("downloads");
                JsonObject artifactObject = downloadsObject.getAsJsonObject("artifact");

                // Retrieve the URL and path for the library
                String libraryUrl = artifactObject.get("url").getAsString();
                String libraryPath = artifactObject.get("path").getAsString();
                String fileName = libraryPath.replace(".jar", "");

                // Skip native and non-required libraries
                if (fileName.contains("native") || fileName.contains("unix")) {
                    continue;
                }

                // Check the next libraries for natives
                boolean fileDownloaded = false;
                for (int j = i + 1; j < librariesArray.size(); j++) {
                    JsonObject nextLibraryObject = librariesArray.get(j).getAsJsonObject();
                    JsonObject nextDownloadsObject = nextLibraryObject.getAsJsonObject("downloads");
                    JsonObject nextArtifactObject = nextDownloadsObject.getAsJsonObject("artifact");
                    String nextLibraryPath = nextArtifactObject.get("path").getAsString();

                    if (nextLibraryPath.contains(fileName)) {
                        // TODO: Check CPU specs
                        if (nextLibraryPath.contains("arm") || nextLibraryPath.contains("x86")) {
                            continue;
                        }

                        boolean isNativeLibrary = nextLibraryPath.contains("natives");
                        boolean isSameOS = (isWindows && nextLibraryPath.contains("windows")) ||
                                (isMac && nextLibraryPath.contains("macos")) ||
                                (isLinux && nextLibraryPath.contains("linux"));

                        if (isNativeLibrary && isSameOS) {
                            String nextLibraryUrl = nextArtifactObject.get("url").getAsString();
                            libraryDownloader(nextLibraryPath, nextLibraryUrl, Startup.global_libraries_path);
                            fileDownloaded = true;
                        }
                    } else {
                        break;
                    }
                }

                if (!fileDownloaded) {
                    libraryDownloader(libraryPath, libraryUrl, Startup.global_libraries_path);
                }
            }

            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void libraryDownloader(String libraryPath, String libraryUrl, String global_libraries_path) {
        String fullPath = global_libraries_path + "/" + libraryPath;
        File file = new File(fullPath);

        // Check if the library file already exists
        if (file.exists()) {
            System.out.println("Library file already exists: " + file.getName());
            return;
        }

        // Create the required directories
        try {
            Path directoryPath = Paths.get(fullPath).getParent();
            if (directoryPath != null) {
                Files.createDirectories(directoryPath);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Download the library file
        System.out.println("Downloading library: " + libraryPath);
        try {
            URL libraryURL = new URL(libraryUrl);
            URLConnection connection = libraryURL.openConnection();
            try (InputStream inputStream = connection.getInputStream();
                 BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
                 FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = bufferedInputStream.read(buffer, 0, buffer.length)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
