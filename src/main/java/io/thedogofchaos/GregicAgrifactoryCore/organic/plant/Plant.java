package io.thedogofchaos.GregicAgrifactoryCore.organic.plant;

import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.plants.Bush;
import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.plants.Crop;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.BushBlock;

import java.util.Set;
import java.util.function.Supplier;

/**
 * This is the base class for all the ore plants to extend from.
 * Contains everything necessary for a functional plant, but individual builders will be delegated to the classes they need to be created for.
 * ({@link Crop.CropBuilder} in {@link Crop}, {@link Bush.BushBuilder} in {@link Bush}, etc.)
 */
public class Plant {
    private Component displayName;
    private PlantType plantType;
    private PlantTextures plantTextures;
    private Supplier<? extends BushBlock> plant;
    private Supplier<? extends Item> essence;
    private Supplier<? extends ItemNameBlockItem> seeds;
    private Set<ResourceLocation> requiredBiomes;

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
    public Plant removeRequiredBiome(ResourceLocation id) {
        this.requiredBiomes.remove(id);
        return this;
    }
}
