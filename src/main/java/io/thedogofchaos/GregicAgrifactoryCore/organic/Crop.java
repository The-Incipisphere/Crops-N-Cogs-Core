package io.thedogofchaos.GregicAgrifactoryCore.organic;

import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntList;
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
import java.util.List;
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

    public String getCropName(){
        return this.cropInfo.id.getPath();
    }
    public String getCropNameWithSuffix(String suffix) {
        return String.format("%s_%s", this.getCropName(), suffix);
    }

    public int getLayerARGB(int layerIndex) {
        if (layerIndex < -100) {
            layerIndex = (Math.abs(layerIndex) % 100) / 10;
        }
        if (layerIndex > cropInfo.colors.size() - 1 || layerIndex < 0) return -1;
        int layerColor = cropInfo.colors.getInt(layerIndex);
        if (layerColor != -1 || layerIndex == 0) return layerColor;
        else return cropInfo.colors.getInt(0);
    }

    // can't lombok my way out of these three methods
    public CropBlock getCropBlock() {
        return this.cropBlock == null ? null : this.cropBlock.get();
    }
    public Crop setCropBlock(Supplier<? extends CropBlock> cropBlock) {
        this.cropBlock = cropBlock;
        return this;
    }
    public Item getHarvestedItem() {
        return this.harvestedItem == null ? null : this.harvestedItem.get();
    }
    public Crop setHarvestedItem(Supplier<? extends Item> harvestedItem) {
        this.harvestedItem = harvestedItem;
        return this;
    }
    public ItemNameBlockItem getSeedItem() {
        return this.seedItem == null ? null : this.seedItem.get();
    }
    public Crop setSeedItem( Supplier<? extends ItemNameBlockItem> seedItem) {
        this.seedItem = seedItem;
        return this;
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
            this.cropInfo.colors.set(0, flowerColor);
            return this;
        }

        public Builder setPistilColor(int pistilColor){
            this.cropInfo.colors.set(1, pistilColor);
            return this;
        }

        public Builder setStemColor(int stemColor){
            this.cropInfo.colors.set(2, stemColor);
            return this;
        }

        public Builder setRequiredBiomes(ResourceLocation... biomeIds) {
            cropInfo.requiredBiomes.addAll(Arrays.asList(biomeIds)); // I wish I could validate this, but biomes are datapacks.
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

        @Getter @Setter private IntList colors = new IntArrayList(List.of(-1, -1));
        @Getter private CropTextures textures;
        @Getter private final Set<ResourceLocation> requiredBiomes;

        private CropInfo(ResourceLocation id) {
            this.id = id;
            requiredBiomes = new HashSet<>();
            colors.set(0, 0x808080); // DEFAULT FLOWER COLOR
            colors.set(0, 0xc0c0c0); // DEFAULT PISTIL COLOR
            colors.set(0, 0x177b04); // DEFAULT SEED COLOR
        }
    }
}
