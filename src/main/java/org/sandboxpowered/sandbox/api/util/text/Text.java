package org.sandboxpowered.sandbox.api.util.text;

import com.google.common.annotations.Beta;
import org.sandboxpowered.sandbox.api.util.Functions;

@Beta
public interface Text {

    static Text literal(String text) {
        return Functions.literalTextFunction.apply(text);
    }

    static Text translatable(String text) {
        return Functions.translatedTextFunction.apply(text);
    }

    default void append(String string) {
        this.append(literal(string));
    }

    void append(Text text);

    String asString();

    String asFormattedString();
}