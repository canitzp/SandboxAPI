package com.hrznstudio.sandbox.api.enchant;

public abstract class Enchantment implements IEnchantment {
    private Object wrapped;
    public Object getWrapped() {
        return wrapped;
    }

    public void setWrapped(Object wrapped) {
        this.wrapped = wrapped;
    }
}
