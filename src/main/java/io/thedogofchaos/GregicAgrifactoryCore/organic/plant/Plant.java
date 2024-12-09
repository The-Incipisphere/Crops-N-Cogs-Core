package io.thedogofchaos.GregicAgrifactoryCore.organic.plant;

import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public class Plant {
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
