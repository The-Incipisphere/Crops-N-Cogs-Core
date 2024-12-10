package io.thedogofchaos.GregicAgrifactoryCore.organic.plant;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.BushBlock;

import java.util.Set;
import java.util.function.Supplier;

/**
 * The base class for all generatable plants to inherit from.
 * @- Contains the frameworks necessary for all plants, such as adding required biomes, choosing what plant to generate, among others.
 */
public class Plant {
    private Component displayName;
    private PlantType plantType;
    private PlantTextures plantTextures;
    private Supplier<? extends BushBlock> plant;
    private Supplier<? extends Item> essence;
    private Supplier<? extends ItemNameBlockItem> seeds;
    private Set<ResourceLocation> requiredBiomes;

    public Plant(Component displayName, PlantType plantType, PlantTextures plantTextures, Supplier<? extends BushBlock> plant, Supplier<? extends Item> essence, Supplier<? extends ItemNameBlockItem> seeds, Set<ResourceLocation> requiredBiomes) {
        this.displayName = displayName;
        this.plantType = plantType;
        this.plantTextures = plantTextures;
        this.plant = plant;
        this.essence = essence;
        this.seeds = seeds;
        this.requiredBiomes = requiredBiomes;
    }

    /**
     * A {@link Set} of the biome IDs (of type {@link ResourceLocation}) that this plant can grow in.
     * @return This {@link Plant}’s {@link Set} of required biomes
     */
    public Set<ResourceLocation> getRequiredBiomes() {
        return this.requiredBiomes;
    }

    /**
     * Add a biome ID to the {@link Set} of required biomes for this plant.
     * @param id The biome ID to add.
     * @return This {@link Plant}
     */
    public Plant addRequiredBiome(ResourceLocation id) {
        this.requiredBiomes.add(id);
        return this;
    }

    /**
     * Remove a biome ID from the {@link Set} of required biomes for this plant.
     * @param id The biome ID to remove.
     * @return This {@link Plant}.
     */
    public Plant removeRequiredBiome(ResourceLocation id) { // This may never get used, but oh well.
        this.requiredBiomes.remove(id);
        return this;
    }
}
