package io.thedogofchaos.GregicAgrifactoryCore.common.data.plants;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.data.tag.TagPrefix;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.*;
import io.thedogofchaos.GregicAgrifactoryCore.util.ResLocUtils;
import net.minecraft.resources.ResourceLocation;

import static io.thedogofchaos.GregicAgrifactoryCore.common.data.plants.Plants.*;

public class CommonOrePlants {
    public static void register() {
        Magnetite = new Plant.PlantBuilder("Magnetite", PlantType.CROP) // TODO: Define 'PlantBuilder(String, PlantType)'
                .setPlantTextures(PlantTextures.FLOWERS) // TODO: Define 'setPlantTextures(PlantTextures)'
                .setRequiredBiomes(new ResourceLocation("minecraft", "plains")) // TODO: Define 'setRequiredBiomes(ResourceLocation...)'
                .build(); // TODO: Define 'build()'
    }
}
