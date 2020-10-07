package org.sandboxpowered.api.entity.module;

public abstract class BaseEntityModule implements EntityModule {
    private final Type<?> type;

    protected BaseEntityModule(Type<?> type) {
        this.type = type;
    }

    @Override
    public Type<?> getType() {
        return type;
    }
}
