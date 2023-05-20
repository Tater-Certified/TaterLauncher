package com.github.tatercertified;

import java.nio.file.Path;
import java.nio.file.Paths;

public class GameProfile {
    private String profileName;
    private String version;
    private JavaProfile javaProfile;
    private String loader;
    private String loaderVer;
    private String path;
    private boolean isSnapshot;
    private boolean isLoaderSnapshot;

    private boolean isSelected;

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean bool) {
        isSelected = bool;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isSnapshot() {
        return isSnapshot;
    }

    public void setSnapshot(boolean bool) {
        isSnapshot = bool;
    }

    public JavaProfile getJavaProfile() {
        return javaProfile;
    }

    public void setJavaProfile(JavaProfile javaProfile) {
        this.javaProfile = javaProfile;
    }

    public String getLoader() {
        return loader;
    }

    public void setLoader(String loader) {
        this.loader = loader;
    }

    public String getLoaderVer() {
        return loaderVer;
    }

    public void setLoaderVer(String version) {
        loaderVer = version;
    }

    public boolean isLoaderSnapshot() {
        return isLoaderSnapshot;
    }

    public void setLoaderSnapshot(boolean bool) {
        isLoaderSnapshot = bool;
    }

    public Path getPath() {
        return Paths.get(path);
    }

    public void setPath(Path path) {
        this.path = path.toString();
    }

    public String toString() {
        return "{ profileName: " + profileName + ", version: " + version + ", javaProfile: " + javaProfile + ", loader: " + loader + ", path: " + path + " }";
    }
}
