package com.hrznstudio.sandbox.api.util;

import com.hrznstudio.sandbox.api.block.Block;
import com.hrznstudio.sandbox.api.block.Material;
import com.hrznstudio.sandbox.api.block.entity.BlockEntity;
import com.hrznstudio.sandbox.api.item.Item;
import com.hrznstudio.sandbox.api.item.Stack;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class Functions {
    public static final Function<String, Identity> identityFunction = s -> {
        throw new RuntimeException("No Identity Function Loaded, Report this as a bug!");
    };
    public static final Function<String, Material> materialFunction = s -> {
        throw new RuntimeException("No Material Function Loaded, Report this as a bug!");
    };
    public static BiFunction<Supplier<? extends BlockEntity>, Block[], BlockEntity.Type<? extends BlockEntity>> blockEntityTypeFunction = (s, v) -> {
        throw new RuntimeException("No Block Entity Type Function Loaded, Report this as a bug!");
    };
    public static BiFunction<Item, Integer, Stack> itemStackFunction = (s, v) -> {
        throw new RuntimeException("No Sack Function Loaded, Report this as a bug!");
    };
}