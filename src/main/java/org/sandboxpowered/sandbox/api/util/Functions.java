package org.sandboxpowered.sandbox.api.util;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.block.Material;
import org.sandboxpowered.sandbox.api.block.entity.BlockEntity;
import org.sandboxpowered.sandbox.api.client.Client;
import org.sandboxpowered.sandbox.api.client.render.RenderUtil;
import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.entity.Entity;
import org.sandboxpowered.sandbox.api.fluid.Fluid;
import org.sandboxpowered.sandbox.api.fluid.FluidStack;
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

import javax.annotation.Nonnull;
import java.util.function.Supplier;

@Internal
public interface Functions {

    @Nonnull
    static Functions getInstance() {
        return null;
    }

    Identity createIdentityFromString(String name, String path);

    Text createLiteralText(String text);

    Text createTranslatedText(String translation);

    Material getMaterial(String material);

    <T extends BlockEntity> BlockEntity.Type<T> blockEntityTypeFunction(Supplier<T> supplier, Block[] blocks);

    ItemStack createItemStack(Item item, int amount);

    ItemStack createItemStackFromTag(ReadableCompoundTag tag);

    <T extends Content> Registry<T> registryFunction(Class<T> c);

    <T extends Content> Registry<T> registryTypeFunction(Class<T> c);

    CompoundTag createCompoundTag();

    Property getProperty(String property);

    Client clientInstance();

    Server serverInstance();

    Vec3i createVec3i(int x, int y, int z);

    Position createPosition(int x, int y, int z);

    Position.Mutable createMutablePosition(int x, int y, int z);

    RenderUtil renderUtilInstance();

    <T> Component<T> componentFunction(Class<T> c);

    Entity.Type entityTypeEntityFunction(Entity e);

    FluidStack fluidStackFunction(Fluid fluid, int amount);

    FluidStack fluidStackFromTagFunction(ReadableCompoundTag tag);
}
