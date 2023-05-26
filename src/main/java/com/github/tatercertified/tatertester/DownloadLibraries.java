package com.github.tatercertified.tatertester;

import com.github.tatercertified.Startup;
import com.google.gson.*;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

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

        // Download the library file
        System.out.println("Downloading library: " + libraryPath);
        try {
            FileUtils.copyURLToFile(new URL(libraryUrl), file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void downloadLoaderLibraries(String loader, String loader_version) {
        URL main_url = null;
        try {
            if (Objects.equals(loader, "Fabric")) {
                main_url = new URL("https://maven.fabricmc.net/net/fabricmc/fabric-loader/" + loader_version + "/fabric-loader-" + loader_version + "-launchwrapper.json");
            } else if (Objects.equals(loader, "Quilt")) {
                main_url = new URL("https://maven.quiltmc.org/repository/release/org/quiltmc/quilt-loader/" + loader_version + "/quilt-loader-" + loader_version + ".json");
            }
            assert main_url != null;
            BufferedReader reader = new BufferedReader(new InputStreamReader(main_url.openStream()));

            JsonObject jsonObject = new Gson().fromJson(reader, JsonObject.class);
            JsonObject librariesObject = jsonObject.getAsJsonObject("libraries");
            JsonArray commonArray = librariesObject.getAsJsonArray("common");

            for (JsonElement element : commonArray) {
                JsonObject libraryObject = element.getAsJsonObject();
                String name = libraryObject.get("name").getAsString();

                String[] nameParts = name.split(":");
                String libraryPath = nameParts[0].replace(".", "/") + "/" + nameParts[1] + "/" + nameParts[2] + "/" + nameParts[1] + "-" + nameParts[2] + ".jar";

                JsonElement urlElement = libraryObject.get("url");
                if (urlElement == null || urlElement.isJsonNull()) {
                    System.out.println("Skipping library: " + name + " (URL not found)");
                    continue;
                }
                String libraryUrl = urlElement.getAsString();

                String downloadUrl = libraryUrl + libraryPath;
                Path libraryFilePath = Path.of(Startup.global_libraries_path, libraryPath);

                if (Files.notExists(libraryFilePath)) {
                    System.out.println("Downloading: " + downloadUrl);
                    FileUtils.copyURLToFile(new URL(downloadUrl), libraryFilePath.toFile());
                } else {
                    System.out.println("Already exists: " + downloadUrl);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
