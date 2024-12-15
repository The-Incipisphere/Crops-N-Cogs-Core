package io.thedogofchaos.GregicAgrifactoryCore.organic;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import lombok.*;
import net.minecraft.resources.ResourceLocation;

public class PlantTextures {

    @Getter
    private final ResourceLocation plantBlockTexture;
    @Getter
    private final ResourceLocation harvestedItemTexture;

    // TODO: Not sure how reliable this will be in its current state, given that I need many different textures for many different blocks.
    public PlantTextures(ResourceLocation plantBlockTexture, ResourceLocation harvestedItemTexture) {
        this.plantBlockTexture = plantBlockTexture;
        this.harvestedItemTexture = harvestedItemTexture;
    }

    public static PlantTextures of(String textureName) {
        return new PlantTextures(
            GregicAgrifactoryCore.id("block/plant/" + textureName),
            GregicAgrifactoryCore.id("item/plant" + textureName)
        );
    }

    /** Default texture set.<br> Contains placeholder textures for everything.*/
    public static final PlantTextures DEFAULT = of("default");
    /** This set of PlantTextures is intended for Crops specifically.<br> Use for other plants at your own risk! */
    public static final PlantTextures FLOWER = of("flowers");
}
