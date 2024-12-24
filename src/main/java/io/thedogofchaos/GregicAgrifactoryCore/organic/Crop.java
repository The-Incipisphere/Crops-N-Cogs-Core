package io.thedogofchaos.GregicAgrifactoryCore.organic;

import lombok.Getter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.CropBlock;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.Set;

public class Crop {

    @NotNull @Getter private final CropInfo cropInfo;

    private Supplier<? extends CropBlock> cropBlock;
    private Supplier<? extends Item> harvestedItem;
    private Supplier<? extends ItemNameBlockItem> seedItem;

    protected Crop(ResourceLocation id) {
        cropInfo = new CropInfo(id);
    }
    public Crop(@NotNull CropInfo cropInfo){
        this.cropInfo = cropInfo;
    }

    public ResourceLocation getCropId(){
        return this.cropInfo.id;
    }
    public String getCropName(){
        return this.cropInfo.id.getPath();
    }

    // can't lombok my way out of these three methods
    public CropBlock getCropBlock() {
        return this.cropBlock == null ? null : this.cropBlock.get();
    }
    public Item getHarvestedItem() {
        return this.harvestedItem == null ? null : this.harvestedItem.get();
    }
    public ItemNameBlockItem getSeedItem() {
        return this.seedItem == null ? null : this.seedItem.get();
    }


    public static class Builder {
        private final CropInfo cropInfo;

        public Builder(ResourceLocation id) {
            if (id.getPath().charAt(id.getPath().length() - 1) == '_') throw new IllegalArgumentException("Plant name cannot end with a '_'!");
            cropInfo = new CropInfo(id);
        }

        public Builder setTextures(CropTextures textures){
            cropInfo.textures = textures;
            return this;
        }

        public Builder setFlowerColor(int flowerColor){
            cropInfo.flowerColor = flowerColor;
            return this;
        }

        public Builder setPistilColor(int pistilColor){
            cropInfo.pistilColor = pistilColor;
            return this;
        }

        public Builder setStemColor(int stemColor){
            cropInfo.stemColor = stemColor;
            return this;
        }

        public Builder setRequiredBiomes(ResourceLocation... biomeIds) {
            cropInfo.requiredBiomes.addAll(Arrays.asList(biomeIds));
            return this;
        }

        public Crop build() {
            return new Crop(cropInfo);
        }
    }

    private static class CropInfo {
        @Getter private final ResourceLocation id;
        @Getter private int flowerColor;
        @Getter private int pistilColor;
        @Getter private int stemColor;
        @Getter private CropTextures textures;
        @Getter private Set<ResourceLocation> requiredBiomes;

        private CropInfo(ResourceLocation id) {
            this.id = id;
        }
    }
}
