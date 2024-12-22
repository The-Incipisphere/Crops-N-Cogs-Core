package io.thedogofchaos.GregicAgrifactoryCore.organic;

import lombok.Getter;

public class PlantColorPalette {
    @Getter
    private final int stemColor;
    @Getter
    private final int flowerColor;

    public PlantColorPalette(int flowerColor){
        this(flowerColor, 0x177b04);
    }
    public PlantColorPalette(int flowerColor, int stemColor) {
        this.flowerColor = flowerColor;
        this.stemColor = stemColor;
    }
}
