package io.thedogofchaos.GregicAgrifactoryCore.organic;

import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Supplier;
import java.util.Set;

public class Crop {

    @NotNull @Getter private final CropInfo cropInfo;

    @Setter private Supplier<? extends CropBlock> cropBlock;
    @Setter private Supplier<? extends Item> harvestedItem;
    @Setter private Supplier<? extends ItemNameBlockItem> seedItem;

    protected Crop(ResourceLocation id) {
        cropInfo = new CropInfo(id);
    }
    public Crop(@NotNull CropInfo cropInfo){
        this.cropInfo = cropInfo;
    }

    public String getCropName(){
        return this.cropInfo.id.getPath();
    }
    public String getCropNameWithSuffix(String suffix) {
        return String.format("%s_%s", this.getCropName(), suffix);
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

    protected void registerCrop() {
        CropRegistry.getInstance().register(this);
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
            cropInfo.requiredBiomes.addAll(Arrays.asList(biomeIds)); // hnnngh, i wish i could validate this but biomes are datapacks
            return this;
        }

        public Crop buildAndRegister() {
            Crop crop = new Crop(cropInfo);
            crop.registerCrop();
            return crop;
        }
    }

    public static class CropInfo {
        @Getter private final ResourceLocation id;
        @Getter private int flowerColor = 0x808080;
        @Getter private int pistilColor = 0xc0c0c0;
        @Getter private int stemColor = 0x177b04;
        @Getter private CropTextures textures;
        @Getter private Set<ResourceLocation> requiredBiomes;

        private CropInfo(ResourceLocation id) {
            this.id = id;
            requiredBiomes = new HashSet<>();
        }
    }
}
