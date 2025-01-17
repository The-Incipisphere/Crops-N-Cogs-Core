package io.thedogofchaos.CropsNCogsCore.unified.registry;

import io.thedogofchaos.CropsNCogsCore.organic.Crop;
import net.minecraft.resources.ResourceLocation;

public interface ICropRegistry {
    void register(Crop crop);

    Crop getCropById(ResourceLocation id);

    Crop getCropByName(String name);
}
