package io.thedogofchaos.GregicAgrifactoryCore.organic;

import lombok.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.MOD_ID;

public class CropTextures {
    // TODO: Now that I've gotten crops working, I gotta get at least uncolored textures working next.

    public static final ResourceLocation SEED_BLANK = new ResourceLocation(MOD_ID, "");

    public static final CropTextures NONE = new CropTextures(null, null, null);
    public static final CropTextures NULLZONE = new CropTextures(id("nulled"),id("nulled"),id("nulled"));
    public static final CropTextures DEBUG = new CropTextures(id("debug"),id("debyg"),id("debug"));

    @Getter @Setter private ResourceLocation plantBlockTextures;
    @Getter @Setter private ResourceLocation harvestedItemTexture;
    @Getter @Setter private ResourceLocation seedItemTexture;

    public CropTextures(ResourceLocation plantBlockTextures, ResourceLocation harvestedItemTexture, ResourceLocation seedItemTexture) {
        this.plantBlockTextures = plantBlockTextures;
        this.harvestedItemTexture = harvestedItemTexture;
        this.seedItemTexture = seedItemTexture;
    }
}
