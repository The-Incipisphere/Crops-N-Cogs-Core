package io.thedogofchaos.GregicAgrifactoryCore.crop;

import net.minecraft.resources.ResourceLocation;

import java.util.Set;

public class Plant {
    private Set<ResourceLocation> requiredBiomes;

    /**
     * A set of biome IDs that this crop can grow in.
     * @return this crop's required biomes
     */
    public Set<ResourceLocation> getRequiredBiomes() {
        return this.requiredBiomes;
    }

    /**
     * Add a biome ID to the list of required biomes for this crop.
     * @param id the biome ID
     * @return this crop
     */
    public Plant addRequiredBiome(ResourceLocation id) {
        this.requiredBiomes.add(id);
        return this;
    }
}
