package io.thedogofchaos.GregicAgrifactoryCore.organic;

import io.thedogofchaos.GregicAgrifactoryCore.util.ResLocUtils;
import lombok.*;
import net.minecraft.resources.ResourceLocation;

public class PlantTextures {
    @Getter
    private final ResourceLocation plantBlockTexture;
    @Getter
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

    /** This set of PlantTextures is intended for Crops specifically.<br> Use for other plants at your own risk! */
    public static final PlantTextures FLOWERS = of("flowers");
    public static final PlantTextures DEFAULT = of("default");
}
