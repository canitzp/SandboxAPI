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
    public static final Registry<Block> BLOCK = getRegistry(Block.class);
    public static final Registry<Item> ITEM = getRegistry(Item.class);
    public static final Registry<Entity.Type> ENTITY = getRegistry(Entity.Type.class);
    public static final Registry<BlockEntity.Type> BLOCK_ENTITY = getRegistry(BlockEntity.Type.class);
    public static final Registry<Fluid> FLUID = getRegistry(Fluid.class);
    public static final Registry<Enchantment> ENCHANTMENT = getRegistry(Enchantment.class);
    public static final Registry<ContainerFactory> CONTAINER = getRegistry(ContainerFactory.class);

    public static <T extends Content<T>> Registry<T> getRegistry(Class<T> tClass) {
        return Functions.getInstance().registryFunction(tClass);
    }
}