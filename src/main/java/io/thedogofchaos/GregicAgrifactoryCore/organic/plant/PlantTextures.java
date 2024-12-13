package io.thedogofchaos.GregicAgrifactoryCore.organic.plant;

import io.thedogofchaos.GregicAgrifactoryCore.util.ResLocUtils;
import net.minecraft.resources.ResourceLocation;

public class PlantTextures {
    public static final ResourceLocation CROP_FLOWERS = ResLocUtils.id("block/crop/flower");
    public static final ResourceLocation ITEM_FLOWERS = ResLocUtils.id("block/item/flower");

    public static final PlantTextures FLOWERS = PlantTextures(CROP_FLOWERS,ITEM_FLOWERS);


}
