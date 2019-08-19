package com.hrznstudio.sandbox.api.item;

public class Item implements IItem {
    private Object wrapped;
    public Object getWrapped() {
        return wrapped;
    }

    public void setWrapped(Object wrapped) {
        this.wrapped = wrapped;
    }
}
