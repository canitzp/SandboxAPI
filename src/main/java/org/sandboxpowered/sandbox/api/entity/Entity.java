package org.sandboxpowered.sandbox.api.entity;

import com.google.common.annotations.Beta;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.util.Mono;

@Beta
public interface Entity {
    default <X> Mono<X> getComponent(Component<X> component) {
        return Mono.empty();
    }
}