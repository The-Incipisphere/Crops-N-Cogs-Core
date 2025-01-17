package io.thedogofchaos.CropsNCogsCore.unified.data.plants;

import io.thedogofchaos.CropsNCogsCore.organic.Crop;
import io.thedogofchaos.CropsNCogsCore.organic.CropTextures;

import static io.thedogofchaos.CropsNCogsCore.CropsNCogsCore.id;
import static io.thedogofchaos.CropsNCogsCore.unified.data.ModPlants.*;

public class VanillaCrops {
    public static void init() {
        // Vanilla
        Gold = new Crop.Builder(id("gold"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xFDF55F)
                .setPistilColor(0xF25833)
                .buildAndRegister();
        Coal = new Crop.Builder(id("coal"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x393E41)
                .setPistilColor(0x101015)
                .buildAndRegister();
        Redstone = new Crop.Builder(id("redstone"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xFF0000)
                .setPistilColor(0x340605)
                .buildAndRegister();
        Diamond = new Crop.Builder(id("diamond"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xC8FFFF)
                .buildAndRegister();
        Emerald = new Crop.Builder(id("emerald"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x17FF6C)
                .setPistilColor(0x003F00)
                .buildAndRegister();
        Amethyst = new Crop.Builder(id("amethyst"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xCFA0F3)
                .setPistilColor(0x734FBC)
                .buildAndRegister();
        Quartz = new Crop.Builder(id("quartz"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xF8EFE3)
                .setPistilColor(0xE6C1BB)
                .buildAndRegister();

    }
}
