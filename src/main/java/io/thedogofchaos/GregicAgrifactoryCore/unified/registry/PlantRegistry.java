package io.thedogofchaos.GregicAgrifactoryCore.unified.registry;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.resources.ResourceLocation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PlantRegistry implements IPlantRegistry {
    private static final PlantRegistry INSTANCE = new PlantRegistry();

    private Map<ResourceLocation, Crop> crops = new LinkedHashMap<>();
    @Getter
    @Setter private boolean allowRegistration = false;

    public void register(Crop crop) {
        if (this.allowRegistration) {
            if (this.crops.values().stream().noneMatch(c -> c.getCropName().equals(crop.getCropName()))) {
                this.crops.put(crop.getCropId(), crop);
            }
        }
    }

    @Override
    public List<Crop> getCrops() {
        return List.of();
    }

    @Override
    public Crop getCropById(ResourceLocation id) {
        return null;
    }

    @Override
    public Crop getCropByName(String name) {
        return this.crops.values().stream().filter(
                c -> name.equals(
                        c.getCropName()
                )
        ).findFirst().orElse(null);
    }

    public static PlantRegistry getInstance() {
        return INSTANCE;
    }
}
