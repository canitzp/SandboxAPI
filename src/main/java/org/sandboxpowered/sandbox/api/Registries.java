package org.sandboxpowered.sandbox.api;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.container.ContainerFactory;
import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.enchant.Enchantment;
import org.sandboxpowered.sandbox.api.fluid.Fluid;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.util.Functions;

public interface Registries {
    Registry<Block> BLOCK = get(Block.class);
    Registry<Item> ITEM = get(Item.class);
    Registry<BlockEntity.Type> BLOCK_ENTITY = get(BlockEntity.Type.class);
    Registry<Fluid> FLUID = get(Fluid.class);
    Registry<Enchantment> ENCHANTMENT = get(Enchantment.class);
    Registry<ContainerFactory> CONTAINER = get(ContainerFactory.class);

    static <T extends Content<T>> Registry<T> get(Class<T> tClass) {
        return (Registry<T>) Functions.registryFunction.apply(tClass);
    }

    static <T extends Content<T>> Registry<T> getRegistry(Class<T> tClass) {
        return (Registry<T>) Functions.registryTypeFunction.apply(tClass);
    }
}