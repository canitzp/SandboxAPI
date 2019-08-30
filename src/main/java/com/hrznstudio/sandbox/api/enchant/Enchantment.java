package com.hrznstudio.sandbox.api.enchant;

public abstract class Enchantment implements IEnchantment {
    private Object wrapped;

    public final Object getWrapped() {
        return wrapped;
    }

    public final void setWrapped(Object wrapped) {
        this.wrapped = wrapped;
    }
}
