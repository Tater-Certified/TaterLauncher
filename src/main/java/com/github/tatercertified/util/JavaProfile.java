package com.github.tatercertified.util;

import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaProfile {
    private String profile_name;
    private String java_path;
    private int min_ram_mb;
    private int max_ram_mb;
    private int max_gc_threads;
    private int huge_pages_size;
    private boolean huge_pages;
    private boolean transparent_huge_pages;
    private boolean use_NUMA;
    private String gc;
    private String other_args;

    public String getProfileName() {
        return profile_name;
    }

    public void setProfileName(String name) {
        profile_name = name;
    }

    public Path getJavaPath() {
        return Paths.get(java_path);
    }

    public void setJavaPath(Path path) {
        java_path = path.toString();
    }

    public int getMinRam() {
        return min_ram_mb;
    }

    public void setMinRam(int megabytes) {
        min_ram_mb = megabytes;
    }

    public int getMaxRam() {
        return max_ram_mb;
    }

    public void setMaxRam(int megabytes) {
        max_ram_mb = megabytes;
    }

    public int getGCThreads() {
        return max_gc_threads;
    }

    public void setMaxGCThreads(int threads) {
        max_gc_threads = threads;
    }

    public int getHugePagesSize() {
        return huge_pages_size;
    }

    public void setHugePagesSize(int megabytes) {
        huge_pages_size = megabytes;
    }

    public boolean isHugePagesEnabled() {
        return huge_pages;
    }

    public void setHugePagesEnabled(boolean bool) {
        huge_pages = bool;
    }

    public boolean isTransparentHugePages() {
        return transparent_huge_pages;
    }

    public void setTransparentHugePages(boolean bool) {
        transparent_huge_pages = bool;
    }

    public boolean isNUMAEnabled() {
        return use_NUMA;
    }

    public void setNUMAEnabled(boolean bool) {
        use_NUMA = bool;
    }

    public String getGC() {
        return gc;
    }

    public void setGC(String gc) {
        this.gc = gc;
    }

    public String getOtherArgs() {
        return other_args;
    }

    public void setOtherArgs(String args) {
        other_args = args;
    }

    // Presets
    public void presetG1GC() {
        setMinRam(2048);
        setMaxRam(4096);
        setTransparentHugePages(true);
        setHugePagesSize(2048);
        setNUMAEnabled(true);
        setGC("g1");
        setOtherArgs("-Xmn384m -XX:+AggressiveOpts -XX:+AlwaysPreTouch -XX:+ParallelRefProcEnabled -XX:+PerfDisableSharedMem -XX:+UseCompressedOops -XX:-UsePerfData -XX:MaxGCPauseMillis=200 -XX:ParallelGCThreads=4 -XX:ConcGCThreads=2 -XX:InitiatingHeapOccupancyPercent=50 -XX:G1HeapRegionSize=1 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=8");
    }

    public void presetZGC() {
        setMinRam(2048);
        setMaxRam(4096);
        setTransparentHugePages(true);
        setHugePagesSize(2048);
        setNUMAEnabled(true);
        setGC("z");
        setOtherArgs("-Xmn384m -XX:+UnlockExperimentalVMOptions -XX:+IgnoreUnrecognizedVMOptions -XX:+UnlockDiagnosticVMOptions -XX:-OmitStackTraceInFastThrow -XX:+ShowCodeDetailsInExceptionMessages -XX:-UseParallelGC -XX:-UseParallelOldGC -XX:+PerfDisableSharedMem -XX:-ZUncommit -XX:ZUncommitDelay=300 -XX:ZCollectionInterval=5 -XX:ZAllocationSpikeTolerance=2.0 -XX:+ParallelRefProcEnabled -XX:+AlwaysPreTouch -XX:-UseBiasedLocking");
    }

    public void presetShenandoahGC() {
        setMinRam(2048);
        setMaxRam(4096);
        setTransparentHugePages(true);
        setHugePagesSize(2048);
        setNUMAEnabled(true);
        setGC("shenandoah");
        setOtherArgs("-Xmn384m -XX:+UnlockExperimentalVMOptions -XX:ShenandoahGCMode=iu -XX:+AlwaysPreTouch -XX:-UseBiasedLocking");
    }

    public void presetZGCGenerational() {
        setMinRam(2048);
        setMaxRam(4096);
        setTransparentHugePages(true);
        setHugePagesSize(2048);
        setNUMAEnabled(true);
        setGC("z");
        setOtherArgs("-Xmn384m -XX:+UnlockExperimentalVMOptions -XX:+ZGenerational");
    }
}
