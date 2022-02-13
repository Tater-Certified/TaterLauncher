package io.github.qpcrummer.launch;

public class ArgPresets {
    //G1GC
    public static String g1gc = "-Xmn384m -XX:+AggressiveOpts -XX:+AlwaysPreTouch -XX:+DisableExplicitGC -XX:+ParallelRefProcEnabled -XX:+PerfDisableSharedMem -XX:+UseCompressedOops -XX:-UsePerfData -XX:MaxGCPauseMillis=200 -XX:ParallelGCThreads=4 -XX:ConcGCThreads=2 -XX:+UseG1GC -XX:+UseTransparentHugePages -XX:LargePageSizeInBytes=2M -XX:+UseLargePages -XX:+UseNUMA -XX:InitiatingHeapOccupancyPercent=50 -XX:G1HeapRegionSize=1 -XX:G1HeapWastePercent=5 -XX:G1MixedGCCountTarget=8 -Dfile.encoding=UTF-8";
    //ZGC
    public static String zgc = "-Xmn384m -XX:+UnlockExperimentalVMOptions -XX:+IgnoreUnrecognizedVMOptions -XX:+UnlockDiagnosticVMOptions -XX:-OmitStackTraceInFastThrow -XX:+ShowCodeDetailsInExceptionMessages -XX:-UseParallelGC -XX:-UseParallelOldGC -XX:+PerfDisableSharedMem -XX:-ZUncommit -XX:ZUncommitDelay=300 -XX:ZCollectionInterval=5 -XX:ZAllocationSpikeTolerance=2.0 -XX:+UseZGC -XX:+UseTransparentHugePages -XX:LargePageSizeInBytes=2M -XX:+UseLargePages -XX:+ParallelRefProcEnabled -XX:+UseNUMA -XX:+AlwaysPreTouch -XX:-UseBiasedLocking -XX:+DisableExplicitGC -Dfile.encoding=UTF-8";
    //Shenandoah
    public static String shen = "-Xmn384m -XX:+UnlockExperimentalVMOptions -XX:+UseShenandoahGC -XX:ShenandoahGCMode=iu -XX:+UseTransparentHugePages -XX:LargePageSizeInBytes=2M -XX:+UseLargePages -XX:+UseNUMA -XX:+AlwaysPreTouch -XX:-UseBiasedLocking -XX:+DisableExplicitGC -Dfile.encoding=UTF-8";
}
