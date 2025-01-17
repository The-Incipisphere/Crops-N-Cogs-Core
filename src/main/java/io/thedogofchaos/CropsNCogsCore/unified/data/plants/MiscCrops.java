package io.thedogofchaos.CropsNCogsCore.unified.data.plants;

import io.thedogofchaos.CropsNCogsCore.organic.Crop;
import io.thedogofchaos.CropsNCogsCore.organic.CropTextures;

import static io.thedogofchaos.CropsNCogsCore.CropsNCogsCore.id;
import static io.thedogofchaos.CropsNCogsCore.unified.data.ModPlants.*;

public class MiscCrops {
    public static void init() {
        // GregTech
        Saltpetre = new Crop.Builder(id("saltpetre"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xE6E6E6)
                .buildAndRegister();
        Sulphur = new Crop.Builder(id("sulphur"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xfdff31)
                .setPistilColor(0xffb400)
                .buildAndRegister();
        // Other
        Becquerellium = new Crop.Builder(id("becquerellium"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xC0FFC0)
                .setPistilColor(0x00FF00)
                .setRequiredBiomes(id("nullzone")) // NOTE: BIOME IS NOT IN THE PACK YET
                .buildButDontRegister();
    }
}
