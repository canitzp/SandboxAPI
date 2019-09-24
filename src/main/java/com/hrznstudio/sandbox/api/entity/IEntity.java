package com.hrznstudio.sandbox.api.entity;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.component.Component;
import com.hrznstudio.sandbox.api.util.Mono;

@Beta
public interface IEntity {
    default <X> Mono<X> getComponent(Component<X> component) {
        return Mono.empty();
    }
}