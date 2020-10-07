package org.sandboxpowered.api.entity.module;

public class EntityModules {
    public static final TameableEntityModule TAMEABLE = new TameableEntityModule();
    public static final EntityModule.Type<BreedableEntityModule> BREEDABLE = new EntityModule.Type<>(BreedableEntityModule::new);
    public static final EntityModule.Type<AgeableEntityModule> AGEABLE = new EntityModule.Type<>(AgeableEntityModule::new);
    public static final EntityModule.Type<DrowningEntityModule> DROWNING = new EntityModule.Type<>(DrowningEntityModule::new);
    public static final EntityModule.Type<SoundEntityModule> SOUND = new EntityModule.Type<>(SoundEntityModule::new);
}
