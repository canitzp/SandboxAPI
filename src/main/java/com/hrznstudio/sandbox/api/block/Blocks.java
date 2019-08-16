package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.util.Functions;

public class Blocks {

    public static final IBlock STONE = get("stone");
    public static final IBlock IRON_ORE = get("iron_ore");

    private static IBlock get(String name) {
        return Functions.blockFunction.apply(name);
    }
}
