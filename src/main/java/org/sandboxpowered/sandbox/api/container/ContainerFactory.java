package org.sandboxpowered.sandbox.api.container;

import org.sandboxpowered.sandbox.api.client.screen.ContainerScreen;
import org.sandboxpowered.sandbox.api.component.Inventory;
import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.nbt.ReadableCompoundTag;

public interface ContainerFactory<C extends Container> extends Content<ContainerFactory<C>> {
    C create(Identity identity, Inventory playerInventory, ReadableCompoundTag tag);

    ContainerScreen create(C container);

    @Override
    @SuppressWarnings("unchecked")
    default Class getContentType() {
        return ContainerFactory.class;
    }
}