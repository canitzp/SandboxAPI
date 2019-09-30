package org.sandboxpowered.sandbox.api.client;

import org.sandboxpowered.sandbox.api.util.annotation.Beta;

public interface TextRenderer {

    int getTextWidth(String text);

    int getFontHeight();

    void draw(String text, float x, float y, int color, Alignment alignment, Option... options);

    default void draw(String text, float x, float y, int color, Option... options) {
        draw(text, x, y, color, Alignment.LEFT, options);
    }

    default void draw(String text, float x, float y, int color, Alignment alignment) {
        draw(text, x, y, color, alignment, new Option[0]);
    }

    default void draw(String text, float x, float y, int color) {
        draw(text, x, y, color, Alignment.LEFT);
    }

    String trim(String text, int width, boolean reverse);

    default String trim(String text, int width) {
        return trim(text, width, false);
    }

    enum Alignment {
        LEFT,
        CENTERED,
        RIGHT
    }

    enum Option {
        SHADOW
    }
}