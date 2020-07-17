package org.sandboxpowered.api.client.rendering.texture;

import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.PreAlpha;

@PreAlpha
public interface Atlas {
    Identity getIdentity();

    Sprite getSprite(Identity identity);

    int getMaxTextureSize();

    interface Sprite {
        Identity getIdentity();

        Atlas getAtlas();

        int getX();

        int getY();

        int getWidth();

        int getHeight();

        default boolean isSquare() {
            return getWidth() == getHeight();
        }

        float getMinU();

        float getMinV();

        float getMaxU();

        float getMaxV();
    }
}