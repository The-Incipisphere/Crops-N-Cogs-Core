package io.thedogofchaos.GregicAgrifactoryCore.unified.registry;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.resources.ResourceLocation;

public interface ICropRegistry {
    void register(Crop crop);

    Crop getCropById(ResourceLocation id);

    Crop getCropByName(String name);
}
