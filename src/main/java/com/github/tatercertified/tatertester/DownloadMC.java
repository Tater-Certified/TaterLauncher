package com.github.tatercertified.tatertester;

import com.github.tatercertified.guis.profiles.LoaderInstaller;
import com.google.gson.Gson;
import net.lingala.zip4j.ZipFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import static com.github.tatercertified.guis.profiles.LoaderInstaller.*;
import static com.github.tatercertified.guis.profiles.VersionGUI.namever;

public class DownloadMC {

    public static String[] versions;

    public static String profile_name = namever.getText();
    public static String profile_path = "TaterLauncher/game_profiles/";

    static {
        try {
            versions = Arrays.stream(getVersions()).toList().toArray(new String[0]);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static String lateststableversion = getLatestStableVersion(List.of(versions));
    static String currentloader;



    public static void download() throws IOException {
        String url;
        if (Objects.equals(loader, "Fabric")) {
            currentloader = "fabric-loader";
            url = "https://meta.fabricmc.net/v2/versions/loader/" + minecraftversion.getSelectedItem().toString() + "/" + loaderversion.getSelectedItem().toString() + "/profile/zip";
            try {
                download(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (Objects.equals(loader, "Quilt")) {
            currentloader = "quilt-loader";
            url = "https://meta.quiltmc.org/v3/versions/loader/" + minecraftversion.getSelectedItem().toString() + "/" + loaderversion.getSelectedItem().toString() + "/profile/zip";
            try {
                download(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else if (Objects.equals(loader, "Vanilla")){
            currentloader = "minecraft";
        }

        if (!Objects.equals(currentloader, "minecraft")) {
            System.out.println("You are downloading " + loader + " Launcher " + Objects.requireNonNull(loaderversion.getSelectedItem()) + " for Minecraft " + Objects.requireNonNull(minecraftversion.getSelectedItem()));
        } else {
            System.out.println("You are downloading Vanilla Minecraft " + Objects.requireNonNull(minecraftversion.getSelectedItem()));
        }

        extractFile();
        removeUnneededFiles();
        renameProfile();
        //System.out.println(locateVanillaJar(minecraftversion.getSelectedItem().toString()));
        namever.setText("Name");
        mainframe.setVisible(false);
    }

    private static void extractFile() {
        if (!Objects.equals(currentloader, "minecraft")) {
            try (ZipFile zipFile = new ZipFile(profile_path + currentloader + "-" + Objects.requireNonNull(loaderversion.getSelectedItem()) + "-" + Objects.requireNonNull(minecraftversion.getSelectedItem()) + ".zip")) {
                zipFile.extractAll(profile_path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try (ZipFile zipFile = new ZipFile(profile_path + currentloader + "-" + Objects.requireNonNull(minecraftversion.getSelectedItem()) + ".zip")) {
                zipFile.extractAll(profile_path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static Object[] getVersions() throws IOException {
        Gson gson = new Gson();
        ArrayList<String> out = new ArrayList<>();
        VersionFromJsonButInAClass versionMetaFromJson = gson.fromJson(getVersionsFromMojank(), VersionFromJsonButInAClass.class);
        for (VersionFromJsonButInAClass.Version v: versionMetaFromJson.versions) {
            out.add(v.id);
        }
        return out.toArray();
    }

    public static List<String> getURLs() throws IOException {
        Gson gson = new Gson();
        ArrayList<String> out = new ArrayList<>();
        VersionFromJsonButInAClass versionMetaFromJson = gson.fromJson(getVersionsFromMojank(), VersionFromJsonButInAClass.class);
        for (VersionFromJsonButInAClass.Version v: versionMetaFromJson.versions) {
            out.add(String.valueOf(v.url));
        }
        return out.stream().toList();
    }

    public static Object[] getJars(String version) throws IOException {
        Gson gson = new Gson();
        ArrayList<String> out = new ArrayList<>();
        ComprehendMojankVersionJson jarsMetaFromJson = gson.fromJson(getURLsFromMojank(version), ComprehendMojankVersionJson.class);
        for (ComprehendMojankVersionJson.Jar v: jarsMetaFromJson.jars) {
            out.add(String.valueOf(v.url));
        }
        return out.toArray();
    }

    public static String getVersionsFromMojank() throws IOException {
        InputStream in = new URL("https://piston-meta.mojang.com/mc/game/version_manifest_v2.json").openConnection().getInputStream();
        Scanner jsonScanner = new Scanner(in).useDelimiter("\\A");
        return jsonScanner.hasNext() ? jsonScanner.next() : "";
    }

    public static String getURLsFromMojank(String version) throws IOException {
        String url = null;
        for (String element : getURLs()){
            if (element.contains(version + ".json")){
                System.out.println(element);
                url = element;
            }
        }
        assert url != null;
        InputStream in = new URL(url).openConnection().getInputStream();
        Scanner jsonScanner = new Scanner(in).useDelimiter("\\A");
        return jsonScanner.hasNext() ? jsonScanner.next() : "";
    }

    public static String locateVanillaJar(String version) throws IOException {
        System.out.println(getURLsFromMojank(version));
        System.out.println(Arrays.toString(getJars(version)));
        return version;
    }

    static class VersionFromJsonButInAClass {
        Latest latest;
        Version[] versions;

        public VersionFromJsonButInAClass(Latest a, Version[] b) {
            latest = a;
            versions = b;
        }

        public static class Latest {
            static String release;
            String snapshot;

            public static String getRelease() {
                return release;
            }

            public String getSnapshot() {
                return snapshot;
            }
        }

        static class Version {
            String id;
            String type;
            URL url;
            String time;
            String releaseTime;

            public String getId() {
                return id;
            }

            public String getReleaseTime() {
                return releaseTime;
            }

            public String getTime() {
                return time;
            }

            public String getType() {
                return type;
            }

            public URL getUrl() {
                return url;
            }
        }
    }

    static class ComprehendMojankVersionJson {

        Jar[] jars;

        public ComprehendMojankVersionJson(Jar[] a) {
            jars = a;
        }

        static class Jar {
          URL url;

          public URL getUrl() {
              return url;
          }
        }

        static class Downloads {

        }
    }


    public static String getLatestStableVersion(List<String> versions) {
        List<String> snapshots = Arrays.asList("w", "b", "a", "inf", "c", "r");
        List<String> filtered = versions.stream().filter(word -> snapshots.stream().noneMatch(word::contains)).toList();
        return filtered.get(0);
    }

    public static String[] getStableVersions(List<String> versions) {
        List<String> snapshots = Arrays.asList("w", "b", "a", "inf", "c", "r");
        List<String> filtered = versions.stream().filter(word -> snapshots.stream().noneMatch(word::contains)).toList();
        return filtered.toArray(new String[0]);
    }

    public static String getLatestDevVersion(List<String> versions) {
        List<String> stable = List.of("1.");
        List<String> filtered = versions.stream().filter(word -> stable.stream().noneMatch(word::contains)).toList();
        return filtered.get(0);
    }

    private static void download(String urlStr) throws IOException {
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos;
        if (Files.notExists(Path.of(profile_path))) {
            Files.createDirectory(Path.of(profile_path));
        }
        if (!Objects.equals(currentloader, "minecraft")) {
            fos = new FileOutputStream(profile_path + currentloader + "-" + Objects.requireNonNull(loaderversion.getSelectedItem()) + "-" + Objects.requireNonNull(minecraftversion.getSelectedItem()) + ".zip");
        } else {
            fos = new FileOutputStream(profile_path + currentloader + "-" + Objects.requireNonNull(minecraftversion.getSelectedItem()) + ".zip");
        }
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

    private static void removeUnneededFiles() {
        Path path1 = Path.of(profile_path);
        if(!path1.toFile().isDirectory()) throw new IllegalStateException("Not Valid Directory");
        for(File file : Objects.requireNonNull(path1.toFile().listFiles())) {
            if(file.getName().startsWith(currentloader) && file.getName().contains(".zip")) {
                file.delete();
            }
        }
    }

    public static void renameProfile() {
        File file = new File(profile_path + currentloader + "-" + Objects.requireNonNull(loaderversion.getSelectedItem()) + "-" + Objects.requireNonNull(minecraftversion.getSelectedItem()));
        if (file.isDirectory()) {
            file.renameTo(new File(profile_path + profile_name));
        }
    }
}
