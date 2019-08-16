package com.hrznstudio.sandbox.api.util;

import com.hrznstudio.sandbox.api.block.IBlock;
import com.hrznstudio.sandbox.api.block.Material;
import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.item.Item;
import com.hrznstudio.sandbox.api.item.Stack;
import com.hrznstudio.sandbox.api.registry.Registry;

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
    public static final Function<String, Material> materialFunction = s -> {
        throw new RuntimeException("No Material Function Loaded, Report this as a bug!");
    };
    public static BiFunction<Supplier<? extends IBlockEntity>, IBlock[], IBlockEntity.Type<? extends IBlockEntity>> blockEntityTypeFunction = (s, v) -> {
        throw new RuntimeException("No IBlock Entity Type Function Loaded, Report this as a bug!");
    };
    public static BiFunction<Item, Integer, Stack> itemStackFunction = (s, v) -> {
        throw new RuntimeException("No Stack Function Loaded, Report this as a bug!");
    };
    public static Function<Class<?>, Registry<?>> registryFunction = (c) -> {
        throw new RuntimeException("No Registry Function Loaded, Report this as a bug!");
    };
}