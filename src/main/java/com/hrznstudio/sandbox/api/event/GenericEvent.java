package com.hrznstudio.sandbox.api.event;

import java.lang.reflect.Type;

public class GenericEvent<T> {
    private Class<T> type;

    public GenericEvent(Class<T> type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}
