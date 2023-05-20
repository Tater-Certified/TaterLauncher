package com.github.tatercertified;

import java.nio.file.Path;

public class GameProfile {
    private String profileName;
    private String version;
    private JavaProfile javaProfile;
    private String loader;
    private String loaderVer;
    private Path path;
    private boolean isSnapshot;
    private boolean isLoaderSnapshot;

    public GameProfile() {
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
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
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public String toString() {
        return "{ profileName: " + profileName + ", version: " + version + ", javaProfile: " + javaProfile + ", loader: " + loader + ", path: " + path + " }";
    }
}
