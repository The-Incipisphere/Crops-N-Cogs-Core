package io.thedogofchaos.GregicAgrifactoryCore.organic;

import lombok.Getter;
import net.minecraft.resources.ResourceLocation;

public class Plant {
    @Getter
    private final ResourceLocation id;
    @Getter
    private int flowerColor;
    @Getter
    private int pistilColor;
    @Getter
    private int stemColor;
    @Getter
    private PlantTextures textures;

    public Plant(ResourceLocation id) {
        this(id, new PlantTextures(), 0x808080, 0xc0c0c0, 0x177b04);
    }

    public Plant(ResourceLocation id, PlantTextures textures, int flowerColor, int pistilColor, int stemColor){
        this.id = id;
        this.textures = textures;
        this.flowerColor = flowerColor;
        this.pistilColor = pistilColor;
        this.stemColor = stemColor;
    }
}
