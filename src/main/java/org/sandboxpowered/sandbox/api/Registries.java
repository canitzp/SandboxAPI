package org.sandboxpowered.sandbox.api;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.container.ContainerFactory;
import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.enchantment.Enchantment;
import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.fluid.Fluid;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.util.Functions;

public class Registries {
    public static final Registry<Block> BLOCK = get(Block.class);
    public static final Registry<Item> ITEM = get(Item.class);
    public static final Registry<Entity.Type> ENTITY = get(Entity.Type.class);
    public static final Registry<BlockEntity.Type> BLOCK_ENTITY = get(BlockEntity.Type.class);
    public static final Registry<Fluid> FLUID = get(Fluid.class);
    public static final Registry<Enchantment> ENCHANTMENT = get(Enchantment.class);
    public static final Registry<ContainerFactory> CONTAINER = get(ContainerFactory.class);

    private static <T extends Content<T>> Registry<T> get(Class<T> tClass) {
        return Functions.getInstance().registryFunction(tClass);
    }

    public static <T extends Content<T>> Registry<T> getRegistry(Class<T> tClass) {
        return Functions.getInstance().registryTypeFunction(tClass);
    }
}