package com.github.tatercertified;

import java.nio.file.Path;

public class GameProfile {
    private String profileName;
    private String version;
    private JavaProfile javaProfile;
    private String loader;
    private Path path;

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
