package org.sandboxpowered.sandbox.api.util;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.block.Material;
import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.client.Client;
import org.sandboxpowered.sandbox.api.client.render.RenderUtil;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.enchant.Enchantment;
import org.sandboxpowered.sandbox.api.fluid.Fluid;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.item.ItemStack;
import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.server.Server;
import org.sandboxpowered.sandbox.api.state.Property;
import org.sandboxpowered.sandbox.api.util.annotation.Internal;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.math.Vec3i;
import org.sandboxpowered.sandbox.api.util.nbt.CompoundTag;
import org.sandboxpowered.sandbox.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.sandbox.api.util.text.Text;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Internal
public class Functions {
    public static final Function<String, Identity> identityFunction = s -> {
        throw new RuntimeException("No Identity Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Block> blockFunction = s -> {
        throw new RuntimeException("No IBlock Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Fluid> fluidFunction = s -> {
        throw new RuntimeException("No IFluid Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Item> itemFunction = s -> {
        throw new RuntimeException("No IItem Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Text> literalTextFunction = s -> {
        throw new RuntimeException("No Literal Text Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Text> translatedTextFunction = s -> {
        throw new RuntimeException("No Translated Text Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Enchantment> enchantmentFunction = s -> {
        throw new RuntimeException("No IEnchantment Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Material> materialFunction = s -> {
        throw new RuntimeException("No Material Function Loaded, Report this as a bug!");
    };
    public static final BiFunction<Supplier<? extends BlockEntity>, Block[], BlockEntity.Type<? extends BlockEntity>> blockEntityTypeFunction = (s, v) -> {
        throw new RuntimeException("No IBlock Entity Type Function Loaded, Report this as a bug!");
    };
    public static final BiFunction<Item, Integer, ItemStack> itemStackFunction = (s, v) -> {
        throw new RuntimeException("No ItemStack Function Loaded, Report this as a bug!");
    };
    public static final Function<Class<?>, Registry<?>> registryFunction = (c) -> {
        throw new RuntimeException("No Registry Function Loaded, Report this as a bug!");
    };
    public static final Supplier<CompoundTag> compoundTagCreator = () -> {
        throw new RuntimeException("No CompoundTag Creator Loaded, Report this as a bug!");
    };
    public static final Function<String, Property> propertyFunction = s -> {
        throw new RuntimeException("No Property Function Loaded, Report this as a bug!");
    };
    public static final Supplier<Client> clientInstance = () -> {
        throw new RuntimeException("No Client Instance Getter Loaded, Report this as a bug!");
    };
    public static final Supplier<Server> serverInstance = () -> {
        throw new RuntimeException("No Server Instance Getter Loaded, Report this as a bug!");
    };
    public static final Function<int[], Vec3i> vec3iFunction = (arr) -> {
        throw new RuntimeException("No Vec3i Function Loaded, Report this as a bug!");
    };
    public static final Function<int[], Position> positionFunction = (arr) -> {
        throw new RuntimeException("No Position Function Loaded, Report this as a bug!");
    };
    public static final Function<int[], Position.Mutable> mutablePositionFunction = (arr) -> {
        throw new RuntimeException("No Position Function Loaded, Report this as a bug!");
    };
    public static final Supplier<RenderUtil> renderUtil = () -> {
        throw new RuntimeException("No Render Util Loaded, Report this as a bug!");
    };
    public static final Function<Class, Component> componentFunction = xClass -> {
        throw new RuntimeException("No Component Function Loaded, Report this as a bug!");
    };
    public static final Function<ReadableCompoundTag, ItemStack> itemStackFromTagFunction = tag -> {
        throw new RuntimeException("No ItemStack Tag Function Loaded, Report this as a bug!");
    };
}