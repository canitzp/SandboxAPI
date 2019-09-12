package com.hrznstudio.sandbox.api.component;

public class Component<T> {
    private final Class<T> tClass;

    public Component(Class<T> tClass) {
        this.tClass = tClass;
    }
}