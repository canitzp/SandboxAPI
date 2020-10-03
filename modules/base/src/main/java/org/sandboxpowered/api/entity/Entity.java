package org.sandboxpowered.api.entity;

import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.annotation.Alpha;

@Alpha
public interface Entity {
    default <X> Mono<X> getComponent(Component<X> component) {
        return Mono.empty();
    }

    Type getType();

    boolean isSneaking();

    interface Type extends Content<Type> {
        Registry<Type> REGISTRY = Registry.getRegistryFromType(Type.class);

        @Override
        default Class<Type> getContentType() {
            return Type.class;
        }
    }
}
