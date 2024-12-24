package io.thedogofchaos.GregicAgrifactoryCore.organic;

import lombok.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class CropTextures {

    @Getter
    @Setter
    private ResourceLocation plantBlockTextures;
    @Getter
    @Setter
    private ResourceLocation harvestedItemTexture;
    @Getter
    @Setter
    private ResourceLocation seedItemTexture;

    public CropTextures() {
        this(null, null, null);
    }

    public CropTextures(@NotNull ResourceLocation plantBlockTextures, ResourceLocation harvestedItemTexture, ResourceLocation seedItemTexture) {
        this.plantBlockTextures = plantBlockTextures;
        this.harvestedItemTexture = harvestedItemTexture;
        this.seedItemTexture = seedItemTexture;
    }
}
