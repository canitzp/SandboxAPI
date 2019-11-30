package org.sandboxpowered.sandbox.api.entity;

import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

@Alpha
public interface Entity {
    default <X> Mono<X> getComponent(Component<X> component) {
        return Mono.empty();
    }

    Type getType();

    interface Type {

    }
}