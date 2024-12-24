package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.PlantRegistry;
import net.minecraft.resources.ResourceLocation;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;

public class ModCrops {
    public static final Crop GOLD = new Crop.Builder(id("gold"))
            .setTextures(CropTextures.DEBUG)
            .setFlowerColor(0xfdf55f)
            .setPistilColor(0xf25833)
            .setRequiredBiomes(new ResourceLocation("minecraft", "plains"))
            .build();

    public static void onRegisterCrops(PlantRegistry registry){
        registry.register(GOLD);
    }
}
