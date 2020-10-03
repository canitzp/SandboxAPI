package org.sandboxpowered.api.resources;

import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.item.Item;

import java.util.Map;
import java.util.function.Supplier;

public final class ResourceRequest {
    private final String resourceName;
    private final Map<ResourceType, Supplier<Item>> items;
    private final Map<ResourceType, Supplier<Block>> blocks;
    private final Map<ResourceType, Supplier<Fluid>> fluids;

    public ResourceRequest(String resourceName, Map<ResourceType, Supplier<Item>> items, Map<ResourceType, Supplier<Block>> blocks, Map<ResourceType, Supplier<Fluid>> fluids) {
        this.resourceName = resourceName;
        this.items = items;
        this.blocks = blocks;
        this.fluids = fluids;
    }

    public String getName() {
        return resourceName;
    }

    public Map<ResourceType, Supplier<Item>> getItems() {
        return items;
    }

    public Map<ResourceType, Supplier<Block>> getBlocks() {
        return blocks;
    }

    public Map<ResourceType, Supplier<Fluid>> getFluids() {
        return fluids;
    }
}
