package org.sandboxpowered.api.entity.module;

public abstract class SingletonEntityModule extends EntityModule.Type<EntityModule> implements EntityModule {
    public SingletonEntityModule() {
        super(type -> (SingletonEntityModule) type);
    }

    @Override
    public Type<?> getType() {
        return this;
    }
}
