package com.hrznstudio.sandbox.api.addon;

import com.electronwill.nightconfig.core.Config;
import com.github.zafarkhaja.semver.Version;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class AddonSpec {
    private static final Pattern MODID_PATTERN = Pattern.compile("[a-z0-9-_]{4,15}");
    private static final Predicate<String> MODID_PREDICATE = MODID_PATTERN.asPredicate();
    private final String modid;
    private final Version version;
    private final String title;
    private final String description;
    private final String mainClass;
    private final List<String> authors;
    private final String url;
    private final LoadingSide side;

    public AddonSpec(String modid, Version version, @Nullable String title, String description, String mainClass, List<String> authors, String url, LoadingSide side) {
        if (MODID_PREDICATE.test(modid))
            throw new IllegalArgumentException(String.format("modid '%s' does not match regex requirement '%s'", modid, MODID_PATTERN.pattern()));
        this.modid = modid;
        this.version = version;
        if (title == null || title.isEmpty())
            title = modid;
        this.title = title;
        this.description = description;
        this.mainClass = mainClass;
        if (authors.isEmpty())
            throw new IllegalArgumentException("authors does not meet minimum list requirement of 1");
        this.authors = authors;
        this.url = url;
        this.side = side;
    }

    public static AddonSpec from(Config config) {
        String modid = config.get("modid");
        Version version = Version.valueOf(config.get("version"));
        String title = config.contains("title") ? config.get("title") : modid;
        String description = config.contains("description") ? config.get("description") : "";
        String mainClass = config.get("entrypoint");
        List<String> authors = config.get("authors");
        String url = config.contains("url") ? config.get("url") : "";
        String sideS = config.contains("side") ? config.get("side") : "COMMON";
        LoadingSide side = sideS.equalsIgnoreCase("CLIENT") ? LoadingSide.CLIENT : sideS.equalsIgnoreCase("SERVER") ? LoadingSide.SERVER : LoadingSide.COMMON;
        return new AddonSpec(modid, version, title, description, mainClass, authors, url, side);
    }

    public String getModid() {
        return modid;
    }

    public Version getVersion() {
        return version;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getMainClass() {
        return mainClass;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public String getUrl() {
        return url;
    }

    public LoadingSide getSide() {
        return side;
    }
}