package io.thedogofchaos.GregicAgrifactoryCore.organic.plant;

import lombok.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
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
        // TODO: figure out how to register plants and their items
    }

    public static class PlantBuilder {
        private final PlantInfo plantInfo;

        public PlantBuilder(ResourceLocation resourceLocation, PlantType plantType) {
            String name = resourceLocation.getPath();
            plantInfo = new PlantInfo(resourceLocation, plantType);
        }

        /** Set the set of textures that this plant & its harvested items has.
         * <br>
         * <b>!!- THIS METHOD IS REQUIRED -!!</b>
         * @param plantTextures
         */
        public PlantBuilder setPlantTextures(PlantTextures plantTextures) {
            plantInfo.plantTextures = plantTextures;
            return this;
        }

        /** Set the required biomes for this plant to be able to grow in.
         * @param biomes Any amount of {@link ResourceLocation}s.
         */
        public PlantBuilder setRequiredBiomes(ResourceLocation... biomes){
            var biomesToAdd = Arrays.asList(biomes);
            biomesToAdd.forEach(ResourceLocationToTest -> {
                if (!ForgeRegistries.BIOMES.containsKey(ResourceLocationToTest)) throw new IllegalStateException("Tried to set "+ResourceLocationToTest.toString()+" as a required biome for "+plantInfo.plantName.toString());
            });
            plantInfo.requiredBiomes.addAll(biomesToAdd);
            return this;
        }

        /** Sets the colour that this plant’s texture set will be tinted by.
         * <br>
         * If you don't call this method with your own colour, it will default to {@code 0xFFFFFF}.
         * @param colour The colour to set
         */
        public PlantBuilder setColour(int colour) {
            plantInfo.colour = colour;
            return this;
        }

        /**
         * Builds and registers the plant.
         * <br>
         * <b>!!- THIS METHOD IS REQUIRED -!!</b>
         * @return The {@link Plant} that you’re trying to register.
         */
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
        private int colour;

        @Getter
        @Setter
        private Set<ResourceLocation> requiredBiomes;

        public PlantInfo(ResourceLocation plantName, PlantType plantType) {
            this.plantName = plantName;
            this.plantType = plantType;
        }
    }
}
