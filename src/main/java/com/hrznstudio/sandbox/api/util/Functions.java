package com.hrznstudio.sandbox.api.util;

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
import com.hrznstudio.sandbox.api.state.Property;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3i;
import com.hrznstudio.sandbox.api.util.nbt.CompoundTag;
import com.hrznstudio.sandbox.api.util.text.Text;

import javax.management.AttributeValueExp;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

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
    public static BiFunction<Supplier<? extends IBlockEntity>, IBlock[], IBlockEntity.Type<? extends IBlockEntity>> blockEntityTypeFunction = (s, v) -> {
        throw new RuntimeException("No IBlock Entity Type Function Loaded, Report this as a bug!");
    };
    public static BiFunction<IItem, Integer, ItemStack> itemStackFunction = (s, v) -> {
        throw new RuntimeException("No ItemStack Function Loaded, Report this as a bug!");
    };
    public static Function<Class<?>, Registry<?>> registryFunction = (c) -> {
        throw new RuntimeException("No Registry Function Loaded, Report this as a bug!");
    };
    public static Supplier<CompoundTag> compoundTagCreator = () -> {
        throw new RuntimeException("No CompoundTag Creator Loaded, Report this as a bug!");
    };
    public static Function<String, Property> propertyFunction = s -> {
        throw new RuntimeException("No Property Function Loaded, Report this as a bug!");
    };
    public static Supplier<Client> clientInstance = () -> {
        throw new RuntimeException("No Client Instance Getter Loaded, Report this as a bug!");
    };
    public static Function<int[], Vec3i> vec3iFunction = (arr) -> {
        throw new RuntimeException("No Vec3i Function Loaded, Report this as a bug!");
    };
    public static Function<int[], Position> positionFunction = (arr) -> {
        throw new RuntimeException("No Position Function Loaded, Report this as a bug!");
    };
    public static Function<int[], Position.Mutable> mutablePositionFunction = (arr) -> {
        throw new RuntimeException("No Position Function Loaded, Report this as a bug!");
    };
    public static Supplier<RenderUtil> renderUtil = () -> {
        throw new RuntimeException("No Render Util Loaded, Report this as a bug!");
    };
    public static Function<Class, Component> componentFunction = xClass -> {
        throw new RuntimeException("No Component Function Loaded, Report this as a bug!");
    };
}