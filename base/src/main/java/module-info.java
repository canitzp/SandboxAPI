module sandbox.base {
    requires org.apache.commons.lang3;
    //Night config has dumb name
    requires static core;
    requires static org.jetbrains.annotations;
    requires java.semver;
    requires guava;

    uses org.sandboxpowered.internal.Functions;

    exports org.sandboxpowered.api;
    exports org.sandboxpowered.api.addon;
    exports org.sandboxpowered.api.block;
    exports org.sandboxpowered.api.block.entity;
    exports org.sandboxpowered.api.client.render;
    exports org.sandboxpowered.api.component;
    exports org.sandboxpowered.api.component.fluid;
    exports org.sandboxpowered.api.component.inventory;
    exports org.sandboxpowered.api.content;
    exports org.sandboxpowered.api.content.resource;
    exports org.sandboxpowered.api.content.resource.supplier;
    exports org.sandboxpowered.api.enchantment;
    exports org.sandboxpowered.api.entity;
    exports org.sandboxpowered.api.entity.player;
    exports org.sandboxpowered.api.fluid;
    exports org.sandboxpowered.api.item;
    exports org.sandboxpowered.api.registry;
    exports org.sandboxpowered.api.server;
    exports org.sandboxpowered.api.state;
    exports org.sandboxpowered.api.util;
    exports org.sandboxpowered.api.util.annotation;
    exports org.sandboxpowered.api.util.math;
    exports org.sandboxpowered.api.util.nbt;
    exports org.sandboxpowered.api.util.text;
    exports org.sandboxpowered.api.world;

    exports org.sandboxpowered.internal to
            sandbox.rendering,
            sandbox.rendering.opengl,
            sandbox.rendering.vulkan;
}