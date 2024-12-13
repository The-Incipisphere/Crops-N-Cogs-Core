package io.thedogofchaos.GregicAgrifactoryCore.organic.plant;

import io.thedogofchaos.GregicAgrifactoryCore.registry.PlantRegistry;
import lombok.*;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Set;

/**
 * The base class for all generatable plants to inherit from.
 * @- Contains the frameworks necessary for all plants, such as adding required biomes, choosing what plant to generate, among others.
 */
public class Plant {
    @NotNull
    @Getter
    private final PlantInfo plantInfo;

    public Plant(@NotNull PlantInfo plantInfo) {
        this.plantInfo = plantInfo;
    }

    protected Plant(ResourceLocation resourceLocation) {
        plantInfo = new PlantInfo(resourceLocation, PlantType.BUSH /*!: NOT DEFINED YET */);
        plantInfo.plantTextures = PlantTextures.DEFAULT /*!: NOT DEFINED YET */;
    }

    protected void registerPlant() {
        // pluh
    }

    public static class PlantBuilder {
        private final PlantInfo plantInfo;

        public PlantBuilder(ResourceLocation resourceLocation, PlantType plantType) {
            String name = resourceLocation.getPath();
            plantInfo = new PlantInfo(resourceLocation, plantType);
        }

        /** Set the set of textures that this plant & its harvested items has.
         * @param plantTextures
         */
        public PlantBuilder setPlantTextures(PlantTextures plantTextures) {
            plantInfo.plantTextures = plantTextures;
            return this;
        }

        /** Set the required biomes for this plant to be able to grow in.
         * @param biomes
         */
        public PlantBuilder setRequiredBiomes(ResourceLocation... biomes){
            plantInfo.requiredBiomes.addAll(Arrays.asList(biomes));
            return this;
        }

        public PlantBuilder color(int color) {
            plantInfo.color = color;
            return this;
        }

        public Plant buildAndRegister(){
            var plant = new Plant(plantInfo);
            plant.registerPlant();
            return plant;
        }
    }
    
    public static class PlantInfo {

        private final ResourceLocation plantName;

        @Getter
        @Setter
        private final PlantType plantType;

        @Getter
        @Setter
        private PlantTextures plantTextures;

        @Getter
        @Setter
        private int color;

        @Getter
        @Setter
        private Set<ResourceLocation> requiredBiomes;

        public PlantInfo(ResourceLocation plantName, PlantType plantType) {
            this.plantName = plantName;
            this.plantType = plantType;
        }
    }
}
