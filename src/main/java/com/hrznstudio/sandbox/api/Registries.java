package com.hrznstudio.sandbox.api;

import com.hrznstudio.sandbox.api.block.IBlock;
import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.enchant.IEnchantment;
import com.hrznstudio.sandbox.api.fluid.IFluid;
import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.registry.Registry;
import com.hrznstudio.sandbox.api.util.Functions;

public interface Registries {

    Registry<IBlock> BLOCK = get(IBlock.class);
    Registry<IItem> ITEM = get(IItem.class);
    Registry<IBlockEntity.Type> BLOCK_ENTITY = get(IBlockEntity.Type.class);
    Registry<IFluid> FLUID = get(IFluid.class);
    Registry<IEnchantment> ENCHANTMENT = get(IEnchantment.class);

    static <T> Registry<T> get(Class<T> tClass) {
        return (Registry<T>) Functions.registryFunction.apply(tClass);
    }
}