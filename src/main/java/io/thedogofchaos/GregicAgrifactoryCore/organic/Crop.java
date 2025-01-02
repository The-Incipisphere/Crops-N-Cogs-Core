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
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class Crop {

    @NotNull
    @Getter
    private final CropInfo cropInfo;

    // do not lombok these three fields
    private Supplier<? extends CropBlock> cropBlock;
    private Supplier<? extends Item> harvestedItem;
    private Supplier<? extends ItemNameBlockItem> seedItem;

    protected Crop(ResourceLocation id) {
        cropInfo = new CropInfo(id);
    }

    public Crop(@NotNull CropInfo cropInfo) {
        this.cropInfo = cropInfo;
    }

    public String getCropName() {
        return this.cropInfo.id.getPath();
    }

    public String getCropNameWithSuffix(String suffix) {
        return String.format("%s_%s", this.getCropName(), suffix);
    }

    /**
     * Retrieves the ARGB color value for a specified layer index from the crop's color data.
     *
     * <p>This method calculates the appropriate layer index if the provided index is below -100.
     * If the calculated or provided index is out of bounds, it returns -1 as an invalid color value.
     * For valid indices, the method attempts to fetch the ARGB color value from the {@code colors} {@link IntList}.
     * If the color at the specified index is invalid (-1) and the index is not 0, it falls back
     * to the color of the first layer (index 0).
     * <p><b>In simpler terms:</b> This method gives you the color of a specific layer. If the
     * index is too low, it fixes it. If the index is out of range or the layer doesn't have a
     * valid color, it either uses the first layer's color or says there's no valid color (-1).
     *
     * @param layerIndex the index of the layer whose color value is to be retrieved. If the index is
     *                   less than -100, it is normalized to a valid index by using
     *                   {@code (Math.abs(layerIndex) % 100) / 10}.
     * @return the ARGB color value of the specified layer. If the index is out of bounds or the
     *         specified color is invalid, returns -1.
     */
    public int getLayerARGB(int layerIndex) {
        if (layerIndex < -100) {
            layerIndex = (Math.abs(layerIndex) % 100) / 10;
        }
        if (layerIndex > cropInfo.colors.size() - 1 || layerIndex < 0) return -1;
        int layerColor = cropInfo.colors.getInt(layerIndex);
        if (layerColor != -1 || layerIndex == 0) return layerColor;
        else return cropInfo.colors.getInt(0);
    }

    /**
     * Directly gets the crop block of the given crop (NOT the supplier containing it)
     * @return The crop block (of type {@link CropBlock}) assigned to this crop, or <b>{@link null}</b> if it is not present.
     */
    public CropBlock getCropBlock() {
        return this.cropBlock == null ? null : this.cropBlock.get();
    }

    /**
     * Sets the crop block of the {@link Crop} object that this method was called on.
     * @param cropBlock Anything extending from {@link CropBlock} that you wish to set as the crop block of this crop.
     * @return The {@link Crop} object that this method was called on.
     */
    public Crop setCropBlock(Supplier<? extends CropBlock> cropBlock) {
        this.cropBlock = cropBlock;
        return this;
    }

    /**
     * Directly gets the harvested item of the given crop (NOT the supplier containing it)
     * @return The harvested item (of type {@link Item}) assigned to this crop, or <b>{@link null}</b> if it is not present.
     */
    public Item getHarvestedItem() {
        return this.harvestedItem == null ? null : this.harvestedItem.get();
    }

    /**
     * Sets the harvested item of the {@link Crop} object that this method was called on.
     * @param harvestedItem Anything extending from {@link Item} that you wish to set as the harvested item of this crop.
     * @return The {@link Crop} object that this method was called on.
     */
    public Crop setHarvestedItem(Supplier<? extends Item> harvestedItem) {
        this.harvestedItem = harvestedItem;
        return this;
    }

    /**
     * Directly gets the seed item of the given crop (NOT the supplier containing it)
     * @return The seed item (of type {@link ItemNameBlockItem}) assigned to this crop, or <b>{@link null}</b> if it is not present.
     */
    public ItemNameBlockItem getSeedItem() {
        return this.seedItem == null ? null : this.seedItem.get();
    }

    /**
     * Sets the seed item of the {@link Crop} object that this method was called on.
     * @param seedItem Anything extending from {@link ItemNameBlockItem} that you wish to set as the seed item of this crop.
     * @return The {@link Crop} object that this method was called on.
     */
    public Crop setSeedItem(Supplier<? extends ItemNameBlockItem> seedItem) {
        this.seedItem = seedItem;
        return this;
    }

    protected void registerCrop() {
        CropRegistry.getInstance().register(this);
    }


    public static class Builder {
        private final CropInfo cropInfo;

        public Builder(ResourceLocation id) {
            if (id.getPath().charAt(id.getPath().length() - 1) == '_')
                throw new IllegalArgumentException("Plant name cannot end with a '_'!");
            cropInfo = new CropInfo(id);
        }

        public Builder setTextures(CropTextures textures) {
            cropInfo.textures = textures;
            return this;
        }

        public Builder setFlowerColor(int flowerColor) {
            this.cropInfo.colors.set(0, flowerColor);
            return this;
        }

        public Builder setPistilColor(int pistilColor) {
            this.cropInfo.colors.set(1, pistilColor);
            return this;
        }

        public Builder setStemColor(int stemColor) {
            this.cropInfo.colors.set(2, stemColor);
            return this;
        }

        public Builder setSeedColor(int stemColor) {
            this.cropInfo.colors.set(3, stemColor);
            return this;
        }

        public Builder setRequiredBiomes(ResourceLocation... biomeIds) {
            cropInfo.requiredBiomes.addAll(Arrays.asList(biomeIds)); // I wish I could validate this, but biomes are datapacks.
            return this;
        }

        public Crop buildAndRegister() {
            var crop = new Crop(cropInfo);
            crop.registerCrop();
            return crop;
        }

        public Crop buildButDontRegister() {
            return new Crop(cropInfo);
        }
    }

    public static class CropInfo {
        @Getter
        private final ResourceLocation id;
        @Getter
        private final Set<ResourceLocation> requiredBiomes;
        @Getter
        @Setter
        private IntList colors = new IntArrayList(List.of(-1, -1));
        @Getter
        private CropTextures textures;

        private CropInfo(ResourceLocation id) {
            this.id = id;
            requiredBiomes = new HashSet<>();
            colors.set(0, 0x808080); // DEFAULT FLOWER COLOR
            colors.set(0, 0xc0c0c0); // DEFAULT PISTIL COLOR
            colors.set(0, 0x177b04); // DEFAULT SEED COLOR
        }
    }
}
