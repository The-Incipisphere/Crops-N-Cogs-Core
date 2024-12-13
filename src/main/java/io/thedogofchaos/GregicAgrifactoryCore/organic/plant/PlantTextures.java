package io.thedogofchaos.GregicAgrifactoryCore.organic.plant;

import io.thedogofchaos.GregicAgrifactoryCore.util.ResLocUtils;
import net.minecraft.resources.ResourceLocation;

public class PlantTextures {
    private final ResourceLocation plantBlockTexture;
    private final ResourceLocation harvestedItemTexture;

    public PlantTextures(ResourceLocation plantBlockTexture, ResourceLocation harvestedItemTexture) {
        this.plantBlockTexture = plantBlockTexture;
        this.harvestedItemTexture = harvestedItemTexture;
    }

    public static PlantTextures of(String textureName) {
        return new PlantTextures(
            ResLocUtils.id("block/plant/" + textureName),
            ResLocUtils.id("item/plant" + textureName)
        );
    }

    public ResourceLocation getPlantBlockTexture() {
        return plantBlockTexture;
    }

    public ResourceLocation getHarvestedItemTexture() {
        return harvestedItemTexture;
    }

    /** This set of PlantTextures is intended for Crops specifically.<br> Use for other plants at your own risk! */
    public static final PlantTextures FLOWERS = of("flowers");
}
