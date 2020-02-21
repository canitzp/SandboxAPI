package org.sandboxpowered.sandbox.api.addon;

import com.electronwill.nightconfig.core.Config;
import com.github.zafarkhaja.semver.Version;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.annotation.Internal;

import javax.annotation.Nullable;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.regex.Pattern;

@Internal
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
    private final URL path;
    private final Map<String, Boolean> platforms;

    private AddonSpec(String modid, Version version, @Nullable String title, String description, String mainClass, List<String> authors, String url, LoadingSide side, URL path, Map<String, Boolean> platforms) {
        this.path = path;
        this.platforms = platforms;
        if (!MODID_PREDICATE.test(modid))
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

    public static AddonSpec from(Config config, URL path) {
        String modid = config.get("modid");
        Version version = Version.valueOf(config.get("version"));
        String title = config.contains("title") ? config.get("title") : modid;
        String description = config.contains("description") ? config.get("description") : "";
        String mainClass = config.get("entrypoint");
        List<String> authors = config.get("authors");
        String url = config.contains("url") ? config.get("url") : "";
        String sideS = config.contains("side") ? config.get("side") : "COMMON";
        LoadingSide side = sideS.equalsIgnoreCase("CLIENT") ? LoadingSide.CLIENT : sideS.equalsIgnoreCase("SERVER") ? LoadingSide.SERVER : LoadingSide.COMMON;
        Map<String, Boolean> platforms = config.contains("platforms") ? config.get("platforms") : Collections.emptyMap();
        return new AddonSpec(modid, version, title, description, mainClass, authors, url, side, path, platforms);
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

    public URL getPath() {
        return path;
    }

    public Map<String, Boolean> getPlatforms() {
        return platforms;
    }

    public PlatformSupport getPlatformSupport(Identity platform) {
        return platforms.containsKey(platform.toString()) ? platforms.get(platform.toString()) ? PlatformSupport.YES : PlatformSupport.NO : PlatformSupport.MAYBE;
    }

    public enum PlatformSupport {
        YES,
        MAYBE,
        NO
    }
}