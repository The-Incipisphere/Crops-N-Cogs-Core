package io.thedogofchaos.GregicAgrifactoryCore.crops;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;

import java.util.function.Supplier;

public class Crop {
    // leave this class as-is until I formulate a way to dynamically generate crops.
    private ResourceLocation id;
    private Component displayName;
    private int maxCropAge;
    private int flowerColor;
    private int essenceColor;
    private int seedColor;
    private Supplier<? extends CropBlock> crop;
    private Supplier<? extends Item> essence;
    private Supplier<? extends ItemNameBlockItem> seeds;
    private Supplier<? extends Block> crux;
    private boolean enabled;


    private Crop() {

    }

    public ItemLike getId() {
        return null;
    }

    public static class Builder {
        public Builder(){

        }
    }
}
