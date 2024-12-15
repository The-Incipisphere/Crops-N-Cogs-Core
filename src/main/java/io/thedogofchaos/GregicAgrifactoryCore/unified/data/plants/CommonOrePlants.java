package io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Plant;
import io.thedogofchaos.GregicAgrifactoryCore.organic.PlantTextures;
import io.thedogofchaos.GregicAgrifactoryCore.organic.PlantType;
import io.thedogofchaos.GregicAgrifactoryCore.util.ResLocUtils;
import net.minecraft.resources.ResourceLocation;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants.*;

public class CommonOrePlants {
    public static void register() {
        Magnetite = new Plant.PlantBuilder(ResLocUtils.id("magnetite"), PlantType.CROP)
                .setPlantTextures(PlantTextures.FLOWERS)
                .setColour(0x9d9d9d)
                .setRequiredBiomes(new ResourceLocation("minecraft", "plains"))
                .buildAndRegister();
    }
}
