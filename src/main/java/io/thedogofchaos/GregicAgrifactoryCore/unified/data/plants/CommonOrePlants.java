package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Plant;
import io.thedogofchaos.GregicAgrifactoryCore.organic.PlantTextures;
import io.thedogofchaos.GregicAgrifactoryCore.organic.PlantType;
import net.minecraft.resources.ResourceLocation;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.*;

public class CommonOrePlants {
    public static void register() {
        Magnetite = new Plant.PlantBuilder(GregicAgrifactoryCore.id("magnetite"), PlantType.CROP)
                .setPlantTextures(PlantTextures.FLOWER)
                .setColour(0x9d9d9d)
                .setRequiredBiomes(new ResourceLocation("minecraft", "plains"))
                .buildAndRegister();
        Chalcopyrite = new Plant.PlantBuilder(GregicAgrifactoryCore.id("chalcopyrite"), PlantType.CROP)
                .setPlantTextures(PlantTextures.FLOWER)
                .setColour(0x96c185)
                .setRequiredBiomes(new ResourceLocation("minecraft", "plains"))
                .buildAndRegister();
    }
}
