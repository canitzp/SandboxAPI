package org.sandboxpowered.api.util.text;

import org.sandboxpowered.api.util.annotation.Alpha;
import org.sandboxpowered.internal.InternalService;

@Alpha
public interface Text {

    static Text literal(String text) {
        return InternalService.getInstance().createLiteralText(text);
    }

    static Text translatable(String text) {
        return InternalService.getInstance().createTranslatedText(text);
    }

    default void append(String string) {
        this.append(literal(string));
    }

    void append(Text text);

    String asString();

    String asFormattedString();
}