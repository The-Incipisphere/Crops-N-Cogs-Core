package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.*;

public class MetalCrops {
    public static void init() {
        // GregTech
        Magnetite = new Crop.Builder(id("magnetite"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x9d9d9d)
                .setPistilColor(0x06070e)
                .buildAndRegister();
        Chalcopyrite = new Crop.Builder(id("chalcopyrite"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x96c185)
                .setPistilColor(0xe3af1a)
                .buildAndRegister();
        Cassiterite = new Crop.Builder(id("cassiterite"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x89847e)
                .setPistilColor(0x3b3b35)
                .buildAndRegister();
        Nickel = new Crop.Builder(id("nickel"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xccdff5)
                .setPistilColor(0x59563a)
                .buildAndRegister();
        Silver = new Crop.Builder(id("silver"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xdcdcff)
                .setPistilColor(0x5a4705)
                .buildAndRegister();
        Cobalt = new Crop.Builder(id("cobalt"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0x5050fa)
                .setPistilColor(0x2d2d7a)
                .buildAndRegister();
        Galena = new Crop.Builder(id("galena"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xf3e8fa)
                .setPistilColor(0x331d42)
                .buildAndRegister();
        Sphalerite = new Crop.Builder(id("sphalerite"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xffdc88)
                .setPistilColor(0x0f1605)
                .buildAndRegister();
        Bauxite = new Crop.Builder(id("bauxite"))
                .setTextures(CropTextures.DEBUG)
                .setFlowerColor(0xcfb853)
                .setPistilColor(0xe6220c)
                .buildAndRegister();
    }
}
