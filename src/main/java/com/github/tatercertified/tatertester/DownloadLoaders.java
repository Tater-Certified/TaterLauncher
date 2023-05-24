package com.github.tatercertified.tatertester;

import org.quiltmc.installer.QuiltMeta;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.github.tatercertified.Main.LOADER_META;

public class DownloadLoaders {

    // Fabric
    public static String[] fabricVersions() {
        List<String> versions = new ArrayList<>();
        int fabricmaxversions = LOADER_META.getVersions().size();
        for (int i = 0; i < fabricmaxversions; i++) {
            versions.add(LOADER_META.getVersions().get(i).getVersion());
        }
        return versions.toArray(new String[0]);
    }

    public static boolean downloadFabricMC(String loader_version, String minecraft_version) {
        return false;
    }

    // Quilt
    public static String[] quiltVersions() {
        Set<QuiltMeta.Endpoint<?>> endpoints = new HashSet<>();
        endpoints.add(QuiltMeta.LOADER_VERSIONS_ENDPOINT);
        endpoints.add(QuiltMeta.INTERMEDIARY_VERSIONS_ENDPOINT);

        QuiltMeta quiltMeta = QuiltMeta.create(QuiltMeta.DEFAULT_META_URL, QuiltMeta.DEFAULT_FABRIC_META_URL, endpoints).join();
        List<String> versions = quiltMeta.getEndpoint(QuiltMeta.LOADER_VERSIONS_ENDPOINT);

        return versions.toArray(new String[0]);
    }

    public static String[] quiltVersionsStable() {
        List<String> versions = new ArrayList<>();
        for (int i = 0; i < quiltVersions().length; i++) {
            String current = quiltVersions()[i];
            if (!current.contains("-")) {
                versions.add(current);
            }
        }
        return versions.toArray(new String[0]);
    }
}
