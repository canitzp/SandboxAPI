package org.sandboxpowered.sandbox.api.util.text;

import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

@Alpha
public interface Text {

    static Text literal(String text) {
        return Functions.getInstance().createLiteralText(text);
    }

    static Text translatable(String text) {
        return Functions.getInstance().createTranslatedText(text);
    }

    default void append(String string) {
        this.append(literal(string));
    }

    void append(Text text);

    String asString();

    String asFormattedString();
}