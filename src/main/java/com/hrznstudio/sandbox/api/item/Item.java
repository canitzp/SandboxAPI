package com.hrznstudio.sandbox.api.item;

public abstract class Item implements IItem {
    private Object wrapped;

    public final Object getWrapped() {
        return wrapped;
    }

    public final void setWrapped(Object wrapped) {
        this.wrapped = wrapped;
    }
}
