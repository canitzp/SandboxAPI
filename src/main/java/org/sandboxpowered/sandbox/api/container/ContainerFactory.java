package org.sandboxpowered.sandbox.api.container;

import org.sandboxpowered.sandbox.api.client.screen.ContainerScreen;
import org.sandboxpowered.sandbox.api.component.Inventory;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.nbt.ReadableCompoundTag;

public interface ContainerFactory<C extends Container> {
    C create(Identity identity, Inventory playerInventory, ReadableCompoundTag tag);

    ContainerScreen create(C container);
}