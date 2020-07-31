package org.sandboxpowered.api.entity.data;

//This should be implemented by classes that hold the entity's data, for example TameableEntityData implements EntityDataHolder
//TODO Maybe just use the array inside directly instead of having this holder
public interface EntityDataHolder {
    SyncedData<?>[] getEntityData();
}
