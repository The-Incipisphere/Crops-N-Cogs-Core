package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;
import net.minecraft.resources.ResourceLocation;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.Gold;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.Magnetite;

public class MetalCrops {
    public static void init() {
        Gold = new Crop.Builder(id("gold"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xfdf55f)
                .setPistilColor(0xf25833)
                .setRequiredBiomes(
                        new ResourceLocation("minecraft", "plains")
                )
                .buildAndRegister();
        Magnetite = new Crop.Builder(id("magnetite"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x9d9d9d)
                .setPistilColor(0x06070e)
                .setRequiredBiomes(
                        new ResourceLocation("minecraft", "plains")
                )
                .buildAndRegister();
    }
}
