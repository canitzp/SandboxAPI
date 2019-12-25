package org.sandboxpowered.sandbox.api.entity;

import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

@Alpha
public interface Entity {
    default <X> Mono<X> getComponent(Component<X> component) {
        return Mono.empty();
    }

    Type getType();

    boolean isSneaking();

    interface Type extends Content<Type> {
        @Override
        default Class<Type> getContentType() {
            return Type.class;
        }
    }
}