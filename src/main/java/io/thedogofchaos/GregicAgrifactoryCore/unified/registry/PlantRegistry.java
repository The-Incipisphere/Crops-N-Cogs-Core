package io.thedogofchaos.GregicAgrifactoryCore.unified.registry;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreHarvestedItem;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreSeedItem;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModCrops;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;

import java.util.*;

public class PlantRegistry implements IPlantRegistry {
    private static final PlantRegistry INSTANCE = new PlantRegistry();

    private Map<ResourceLocation, Crop> crops = new LinkedHashMap<>();
    @Getter @Setter private boolean allowRegistration = false;

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

    public void onRegisterBlocks(DeferredRegister<Block> registry){
        ModCrops.onRegisterCrops(this);

        var crops = this.crops.values();

        crops.forEach(c -> {
            var crop = c.getCropBlock();
            if (crop == null) {
                var defaultCrop = new OreCropBlock(c);
                c.setCropBlock(() -> defaultCrop);
                registry.register(new ResourceLocation(GregicAgrifactoryCore.MOD_ID, c.getCropNameWithSuffix("crop")).getPath(), () -> defaultCrop);
            } else {
                var id = new ResourceLocation(GregicAgrifactoryCore.MOD_ID, c.getCropNameWithSuffix("crop"));
                registry.register(id.getPath(), () -> crop);
            }
        });
    }

    public void onRegisterItems(DeferredRegister<Item> registry) {
        var crops = this.crops.values();

        crops.forEach(c -> {
            var crop = c.getHarvestedItem();
            if (crop == null) {
                var defaultHarvested = new OreHarvestedItem(c);
                c.setHarvestedItem(() -> defaultHarvested);
                registry.register(new ResourceLocation(GregicAgrifactoryCore.MOD_ID, c.getCropNameWithSuffix("harvested")).getPath(), () -> defaultHarvested);
            } else {
                var id = new ResourceLocation(GregicAgrifactoryCore.MOD_ID, c.getCropNameWithSuffix("harvested"));
                registry.register(id.getPath(), () -> crop);
            }
        });

        crops.forEach(c -> {
            var crop = c.getSeedItem();
            if (crop == null) {
                var defaultSeed = new OreSeedItem(c);
                c.setSeedItem(() -> defaultSeed);
                registry.register(new ResourceLocation(GregicAgrifactoryCore.MOD_ID, c.getCropNameWithSuffix("seed")).getPath(), () -> defaultSeed);
            } else {
                var id = new ResourceLocation(GregicAgrifactoryCore.MOD_ID, c.getCropNameWithSuffix("seed"));
                registry.register(id.getPath(), () -> crop);
            }
        });
    }
}

