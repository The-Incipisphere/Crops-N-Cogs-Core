package io.thedogofchaos.GregicAgrifactoryCore.organic;

import lombok.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.MOD_ID;

public class CropTextures {

    public static final ResourceLocation SEED_BLANK = new ResourceLocation(MOD_ID, "item/mystical_seeds");

    public static final CropTextures NONE = new CropTextures(null, null, null);

    @Getter @Setter private ResourceLocation plantBlockTextures;
    @Getter @Setter private ResourceLocation harvestedItemTexture;
    @Getter @Setter private ResourceLocation seedItemTexture;

    public CropTextures(ResourceLocation plantBlockTextures, ResourceLocation harvestedItemTexture, ResourceLocation seedItemTexture) {
        this.plantBlockTextures = plantBlockTextures;
        this.harvestedItemTexture = harvestedItemTexture;
        this.seedItemTexture = seedItemTexture;
    }
}
