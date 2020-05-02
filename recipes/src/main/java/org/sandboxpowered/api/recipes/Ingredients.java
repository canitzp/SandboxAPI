package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.fluid.FluidStack;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.WorldReader;

public class Ingredients {
    public static final Ingredient<ItemStack> ITEM = null;
    public static final Ingredient<FluidStack> FLUID = null;
    public static final Ingredient<WorldReader> WORLD = null;
    public static final Ingredient<Position> POSITION = null;
    public static final Ingredient<Entity> ENTITY = null;
    public static final Ingredient<PlayerEntity> PLAYER = null;
    public static final Ingredient<Hand> HAND = null;
}