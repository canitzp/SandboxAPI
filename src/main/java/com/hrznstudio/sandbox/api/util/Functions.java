package com.hrznstudio.sandbox.api.util;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.block.IBlock;
import com.hrznstudio.sandbox.api.block.Material;
import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.client.Client;
import com.hrznstudio.sandbox.api.client.render.RenderUtil;
import com.hrznstudio.sandbox.api.component.Component;
import com.hrznstudio.sandbox.api.enchant.IEnchantment;
import com.hrznstudio.sandbox.api.fluid.IFluid;
import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.item.ItemStack;
import com.hrznstudio.sandbox.api.registry.Registry;
import com.hrznstudio.sandbox.api.server.Server;
import com.hrznstudio.sandbox.api.state.Property;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3i;
import com.hrznstudio.sandbox.api.util.nbt.CompoundTag;
import com.hrznstudio.sandbox.api.util.nbt.ReadableCompoundTag;
import com.hrznstudio.sandbox.api.util.text.Text;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Beta
public class Functions {
    public static final Function<String, Identity> identityFunction = s -> {
        throw new RuntimeException("No Identity Function Loaded, Report this as a bug!");
    };
    public static final Function<String, IBlock> blockFunction = s -> {
        throw new RuntimeException("No IBlock Function Loaded, Report this as a bug!");
    };
    public static final Function<String, IFluid> fluidFunction = s -> {
        throw new RuntimeException("No IFluid Function Loaded, Report this as a bug!");
    };
    public static final Function<String, IItem> itemFunction = s -> {
        throw new RuntimeException("No IItem Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Text> literalTextFunction = s -> {
        throw new RuntimeException("No Literal Text Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Text> translatedTextFunction = s -> {
        throw new RuntimeException("No Translated Text Function Loaded, Report this as a bug!");
    };
    public static final Function<String, IEnchantment> enchantmentFunction = s -> {
        throw new RuntimeException("No IEnchantment Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Material> materialFunction = s -> {
        throw new RuntimeException("No Material Function Loaded, Report this as a bug!");
    };
    public static final BiFunction<Supplier<? extends IBlockEntity>, IBlock[], IBlockEntity.Type<? extends IBlockEntity>> blockEntityTypeFunction = (s, v) -> {
        throw new RuntimeException("No IBlock Entity Type Function Loaded, Report this as a bug!");
    };
    public static final BiFunction<IItem, Integer, ItemStack> itemStackFunction = (s, v) -> {
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