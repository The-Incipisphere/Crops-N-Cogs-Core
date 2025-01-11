package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;
import net.minecraft.resources.ResourceLocation;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.*;

public class GemCrops {
    public static void init() {
        Diamond = new Crop.Builder(id("diamond"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xc8ffff)
                .buildAndRegister();
    }
}
