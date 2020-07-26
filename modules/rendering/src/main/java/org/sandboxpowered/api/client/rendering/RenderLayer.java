package org.sandboxpowered.api.client.rendering;

import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.PreAlpha;

@PreAlpha
public interface RenderLayer {
    static RenderLayer getSolid() {
        return null;
    }

    static RenderLayer getCutout() {
        return null;
    }

    static RenderLayer getTranslucent() {
        return null;
    }

    static RenderLayer getCustomSolid(Identity texture) {
        return null;
    }

    static RenderLayer getCustomCutout(Identity texture) {
        return null;
    }

    static RenderLayer getCustomTranslucent(Identity texture) {
        return null;
    }
}