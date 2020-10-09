package org.sandboxpowered.api.entity.module;

public class EntityModules {
    public static final EntityModule.Type<TamingEntityModule> TAMING = new EntityModule.Type.Singleton<>(TamingEntityModule::new);
    public static final EntityModule.Type<BreedingEntityModule> BREEDING = new EntityModule.Type<>(BreedingEntityModule::new);
    public static final EntityModule.Type<AgingEntityModule> AGING = new EntityModule.Type<>(AgingEntityModule::new);
    public static final EntityModule.Type<DrowningEntityModule> DROWNING = new EntityModule.Type<>(DrowningEntityModule::new);
    public static final EntityModule.Type<SoundEntityModule> SOUND = new EntityModule.Type<>(SoundEntityModule::new);
}
