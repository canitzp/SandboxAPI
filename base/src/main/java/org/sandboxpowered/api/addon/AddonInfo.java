package org.sandboxpowered.api.addon;

import com.github.zafarkhaja.semver.Version;
import org.sandboxpowered.api.util.Identity;

import java.net.URL;
import java.util.List;

public interface AddonInfo {
    String getId();

    Version getVersion();

    String getTitle();

    String getDescription();

    String getMainClass();

    List<String> getAuthors();

    String getUrl();

    LoadingSide getSide();

    URL getPath();

    PlatformSupport getPlatformSupport(Identity platform);

    enum PlatformSupport {
        YES,
        MAYBE,
        NO
    }
}
