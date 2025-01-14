package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.*;

public class MiscCrops {
    public static void init() {
        // GregTech
        /*...*/
        // Other
        Becquerellium = new Crop.Builder(id("becquerellium"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xc0ffc0)
                .setPistilColor(0x00ff00)
                .setRequiredBiomes(id("nullzone")) // NOTE: BIOME IS NOT IN THE PACK YET
                .buildButDontRegister();
    }
}
