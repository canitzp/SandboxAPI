package org.sandboxpowered.api.resources;

import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.item.Item;

import java.util.Map;
import java.util.function.Consumer;

public class VanillaResource extends Resource {
    private final Map<ResourceType, Item> vanillaItems;
    private final Map<ResourceType, Block> vanillaBlocks;

    public VanillaResource(String baseName, Map<ResourceType, Item> vanillaItems, Map<ResourceType, Block> vanillaBlocks) {
        super(baseName);
        this.vanillaItems = vanillaItems;
        this.vanillaBlocks = vanillaBlocks;
        items.putAll(vanillaItems);
        blocks.putAll(vanillaBlocks);
        addedItems.put("minecraft", vanillaItems.keySet());
        addedBlocks.put("minecraft", vanillaBlocks.keySet());
    }

    @Override
    public String getFullNameFor(ResourceType type) {
        if (vanillaItems.containsKey(type)) return Item.REGISTRY.getIdentity(vanillaItems.get(type)).getPath();
        if (vanillaBlocks.containsKey(type)) return Block.REGISTRY.getIdentity(vanillaBlocks.get(type)).getPath();
        return super.getFullNameFor(type);
    }

    @Override
    public void forEachItem(Consumer<ResourceType> consumer) {
        getItemTypes().forEach(type -> {
            if (!vanillaItems.containsKey(type)) consumer.accept(type);
        });
    }

    @Override
    public void forEachBlock(Consumer<ResourceType> consumer) {
        getBlockTypes().forEach(type -> {
            if (!vanillaBlocks.containsKey(type)) consumer.accept(type);
        });
    }
}
