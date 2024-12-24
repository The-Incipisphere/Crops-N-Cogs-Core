package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.LOGGER;
import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.*;

public class MetalCrops {
    public static void init() {
        Gold = new Crop.Builder(id("gold"))
                .setTextures(CropTextures.NONE)
                .setFlowerColor(0xfdf55f)
                .setPistilColor(0xf25833)
                .setRequiredBiomes(
                        new ResourceLocation("minecraft", "plains")
                )
                .buildAndRegister();
    }
}
