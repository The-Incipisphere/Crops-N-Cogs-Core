package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.*;

public class VanillaCrops {
    public static void init() {
        // Vanilla
        Gold = new Crop.Builder(id("gold"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xfdf55f)
                .setPistilColor(0xf25833)
                .buildAndRegister();
        Coal = new Crop.Builder(id("coal"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x393e41)
                .setPistilColor(0x101015)
                .buildAndRegister();
        Redstone = new Crop.Builder(id("redstone"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xff0000)
                .setPistilColor(0x340605)
                .buildAndRegister();
        Diamond = new Crop.Builder(id("diamond"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xc8ffff)
                .buildAndRegister();
        Emerald = new Crop.Builder(id("emerald"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x17ff6c)
                .setPistilColor(0x003f00)
                .buildAndRegister();
        Amethyst = new Crop.Builder(id("amethyst"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xcfa0f3)
                .setPistilColor(0x734fbc)
                .buildAndRegister();
        Quartz = new Crop.Builder(id("quartz"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xf8efe3)
                .setPistilColor(0xe6c1bb)
                .buildAndRegister();

    }
}
