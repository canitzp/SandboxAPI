package com.hrznstudio.sandbox.api;

import com.hrznstudio.sandbox.api.block.Block;
import com.hrznstudio.sandbox.api.block.entity.BlockEntity;
import com.hrznstudio.sandbox.api.item.Item;
import com.hrznstudio.sandbox.api.registry.Registry;

public interface Registries {
    Registry<Block> getBlockRegistry();

    Registry<Item> getItemRegistry();

    Registry<BlockEntity.Type<?>> getBlockEntityTypeRegistry();
}