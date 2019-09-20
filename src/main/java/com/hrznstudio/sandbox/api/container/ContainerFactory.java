package com.hrznstudio.sandbox.api.container;

import com.hrznstudio.sandbox.api.client.screen.ContainerScreen;
import com.hrznstudio.sandbox.api.component.Inventory;
import com.hrznstudio.sandbox.api.network.ReadableBuffer;
import com.hrznstudio.sandbox.api.util.Identity;
import com.hrznstudio.sandbox.api.util.nbt.ReadableCompoundTag;

public interface ContainerFactory<C extends IContainer> {
    C create(Identity identity, Inventory playerInventory, ReadableCompoundTag tag);

    ContainerScreen create(C container);
}