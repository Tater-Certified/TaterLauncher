package io.github.qpcrummer;

import java.nio.file.Path;

public class JavaProfile {
    private String profileName;
    private Path path;
    private int startingRam;
    private int maxRam;
    private String gc;
    private int gcThreads;
    private boolean useLargePages;
    private int gcPageSize;
    private boolean disableExplicitGC;
    private boolean fastEncoder;
    private String otherArgs;

    public JavaProfile() {
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public int getStartingRam() {
        return startingRam;
    }

    public void setStartingRam(int startingRam) {
        this.startingRam = startingRam;
    }

    public int getMaxRam() {
        return maxRam;
    }

    public void setMaxRam(int maxRam) {
        this.maxRam = maxRam;
    }

    public String getGc() {
        return gc;
    }

    public void setGc(String gc) {
        this.gc = gc;
    }

    public int getGcThreads() {
        return gcThreads;
    }

    public void setGcThreads(int gcThreads) {
        this.gcThreads = gcThreads;
    }

    public boolean isUseLargePages() {
        return useLargePages;
    }

    public void setUseLargePages(boolean useLargePages) {
        this.useLargePages = useLargePages;
    }

    public int getGcPageSize() {
        return gcPageSize;
    }

    public void setGcPageSize(int gcPageSize) {
        this.gcPageSize = gcPageSize;
    }

    public boolean isDisableExplicitGC() {
        return disableExplicitGC;
    }

    public void setDisableExplicitGC(boolean disableExplicitGC) {
        this.disableExplicitGC = disableExplicitGC;
    }

    public boolean isFastEncoder() {
        return fastEncoder;
    }

    public void setFastEncoder(boolean fastEncoder) {
        this.fastEncoder = fastEncoder;
    }

    public String getOtherArgs() {
        return otherArgs;
    }

    public void setOtherArgs(String otherArgs) {
        this.otherArgs = otherArgs;
    }

    public String toString() {
        return "{name: " + profileName + ", path: " + path + ", startingRam: " + startingRam + ", maxRam: " + maxRam + ", gc: " + gc + ", gcThreads: " + gcThreads + ", useLargePages: " + useLargePages + ", gcPageSize: " + gcPageSize + ", disableExplicitGC: " + disableExplicitGC + ", fastEncoder: " + fastEncoder + ", otherArgs: " + otherArgs + "}";
    }
}
