package io.thedogofchaos.GregicAgrifactoryCore.organic;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.CropBlock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Supplier;
import java.util.Set;

public class Crop {
    @Getter private final ResourceLocation id;
    @Getter @Setter private int flowerColor;
    @Getter @Setter private int pistilColor;
    @Getter @Setter private int stemColor;
    @Getter private CropTextures textures;
    private Supplier<? extends CropBlock> cropBlock;
    private Supplier<? extends Item> harvestedItem;
    private Supplier<? extends ItemNameBlockItem> seedItem;
    @Getter private Set<ResourceLocation> requiredBiomes;

    public Crop(ResourceLocation id) {
        this(id, CropTextures.DEFAULT, 0x808080, 0xc0c0c0, 0x177b04);
    }

    public Crop(ResourceLocation id, int flowerColor){
        this(id, CropTextures.DEFAULT, flowerColor, 0xc0c0c0, 0x177b04);
    }

    public Crop(ResourceLocation id, CropTextures textures, int flowerColor, int pistilColor, int stemColor){
        this.id = id;
        this.textures = textures;
        this.flowerColor = flowerColor;
        this.pistilColor = pistilColor;
        this.stemColor = stemColor;
        this.requiredBiomes = new HashSet<>();
    }

    /**
     * The internal name of this crop.
     * This is used for registration, so it MUST be all lowercase with underscores for spaces
     * @return The internal name of this crop
     */
    public String getName() {
        return this.getId().getPath();
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

    // Biomes
    public Crop setRequiredBiomes(ResourceLocation... biomeIds) {
        this.requiredBiomes.addAll(Arrays.asList(biomeIds));
        return this;
    }
}
