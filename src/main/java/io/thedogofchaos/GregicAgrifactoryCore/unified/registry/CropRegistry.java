package io.thedogofchaos.GregicAgrifactoryCore.unified.registry;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreHarvestedItem;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreSeedItem;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;

import java.util.*;
import java.util.function.Supplier;

/*
 * All my credit for this registry system’s concept goes to BlakeBr0.
 * BlakeBr0, if you ever read this,
 * I’m sorry this is almost an ad-verbatim copy of
 * Mystical Agriculture’s crop registry system,
 * but your shit just… works.
 */
public class CropRegistry implements ICropRegistry {
    private static final CropRegistry INSTANCE = new CropRegistry();

    private Map<ResourceLocation, Crop> crops = new LinkedHashMap<>();
    @Getter private final Map<String, Supplier<OreCropBlock>> preCreatedCrops = new HashMap<>();
    @Getter private final Map<String, Supplier<OreHarvestedItem>> preCreatedHarvestedItems = new HashMap<>();
    @Getter private final Map<String, Supplier<OreSeedItem>> preCreatedSeedItems = new HashMap<>();
    @Getter @Setter private boolean allowRegistration = false;

    public void register(Crop crop) {
        if (this.allowRegistration) {
            if (this.crops.values().stream().noneMatch(c -> c.getCropName().equals(crop.getCropName()))) {
                this.crops.put(crop.getCropInfo().getId(), crop);
            }
        }
    }

    @Override
    public List<Crop> getCrops() {
        return List.copyOf(this.crops.values());
    }

    @Override
    public Crop getCropById(ResourceLocation id) {
        return this.crops.get(id);
    }

    @Override
    public Crop getCropByName(String name) {
        return this.crops.values().stream().filter(
                c -> name.equals(
                        c.getCropName()
                )
        ).findFirst().orElse(null);
    }

    public static CropRegistry getInstance() {
        return INSTANCE;
    }

    public void initializeCrops() {
        var crops = this.crops.values();
        crops.forEach(c -> {
            if (c.getCropBlock() == null) {
                preCreatedCrops.put(c.getCropNameWithSuffix("crop"), () -> new OreCropBlock(c));
                c.setCropBlock(() -> new OreCropBlock(c));
            }
            if (c.getHarvestedItem() == null) {
                preCreatedHarvestedItems.put(c.getCropNameWithSuffix("harvested"), () -> new OreHarvestedItem(c));
                c.setHarvestedItem(() -> new OreHarvestedItem(c));
            }

            if (c.getSeedItem() == null) {
                preCreatedSeedItems.put(c.getCropNameWithSuffix("seed"), () -> new OreSeedItem(c));
                c.setSeedItem(() -> new OreSeedItem(c));
            }
        });
    }
    public void onRegisterBlocks(DeferredRegister<Block> registry){
        preCreatedCrops.forEach(registry::register);
    }

    public void onRegisterItems(DeferredRegister<Item> registry) {
        preCreatedHarvestedItems.forEach(registry::register);
        preCreatedSeedItems.forEach(registry::register);
    }
}

