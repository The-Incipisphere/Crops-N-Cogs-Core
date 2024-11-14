package io.thedogofchaos.GregicAgrifactoryCore.registry.registrate;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

// I have no idea what this does, but I stole it from GTCEu Modern anyway.
public abstract class BuilderBase<T> implements Supplier<T> {

    public ResourceLocation id;
    protected T value = null;

    public BuilderBase(ResourceLocation id, Object... args) {
        this.id = id;
    }

    public abstract T register();

    @Override
    public T get() {
        return value;
    }
}