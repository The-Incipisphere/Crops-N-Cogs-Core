package io.thedogofchaos.GregicAgrifactoryCore.unified.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import dev.latvian.mods.kubejs.recipe.component.OrRecipeComponent;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreHarvestedItem;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreSeedItem;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedRegistry.REGISTRATE;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModCreativeTabs.CROP_HARVESTED_TAB;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModCreativeTabs.CROP_SEEDS_TAB;

/*
 * Based on BlakeBr0's crop registry system for Mystical Agriculture
 */
public class CropRegistry implements ICropRegistry {
    private static final CropRegistry INSTANCE = new CropRegistry();
    private final Map<String, RegistryEntry<OreCropBlock>> CROP_BLOCKS = new HashMap<>();
    private final Map<String, RegistryEntry<OreHarvestedItem>> CROP_HARVESTED_ITEMS = new HashMap<>();
    private final Map<String, RegistryEntry<OreSeedItem>> CROP_SEED_ITEMS = new HashMap<>();
    private final Map<ResourceLocation, Crop> CROPS = new LinkedHashMap<>();
    @Getter
    @Setter
    private boolean allowRegistration = false;

    public static CropRegistry getInstance() {
        return INSTANCE;
    }

    public void register(Crop crop) {
        if (this.allowRegistration) {
            if (this.CROPS.values().stream().noneMatch(c -> c.getCropName().equals(crop.getCropName()))) {
                this.CROPS.put(crop.getCropInfo().getId(), crop);
            }
        }
    }

    public Map<ResourceLocation, Crop> getCrops() {
        return this.CROPS;
    }

    public Map<String, ?> getCropBlocksAsRegistryEntries() {
        return CROP_BLOCKS;
    }

    public Map<String, OreCropBlock> getCropBlocksAsOreCropBlock() {
        var list = new HashMap<String, OreCropBlock>();
        this.CROP_BLOCKS.forEach((str, crop) -> {
            list.put(str, crop.get());
        });
        return list;
    }

    public Map<String, ?> getHarvestedItemsAsRegistryEntries() {
        return CROP_HARVESTED_ITEMS;
    }

    public Map<String, OreHarvestedItem> getHarvestedItemsAsOreHarvestedItem() {
        var list = new HashMap<String, OreHarvestedItem>();
        this.CROP_HARVESTED_ITEMS.forEach((str, crop) -> {
            list.put(str, crop.get());
        });
        return list;

    }

    public Map<String, ?> getSeedItemsAsRegistryEntries() {
        return CROP_SEED_ITEMS;
    }

    public Map<String, OreSeedItem> getSeedItemsAsOreSeedItem() {
        var list = new HashMap<String, OreSeedItem>();
        this.CROP_SEED_ITEMS.forEach((str, crop) -> {
            list.put(str, crop.get());
        });
        return list;
    }

    @Override
    public Crop getCropById(ResourceLocation id) {
        return this.CROPS.get(id);
    }

    @Override
    public Crop getCropByName(String name) {
        return this.CROPS.values().stream().filter(
                c -> name.equals(
                        c.getCropName()
                )
        ).findFirst().orElse(null);
    }

    public void generateCrops() {
        var crops = this.CROPS.values();
        crops.forEach(c -> {
            if (c.getCropBlock() == null) {
                BlockEntry<OreCropBlock> cropBlockEntry = REGISTRATE.block(c.getCropNameWithSuffix("crop"), properties -> new OreCropBlock(c, properties))
                        .initialProperties(() -> Blocks.WHEAT)
                        .properties(BlockBehaviour.Properties::noLootTable)
                        .color(() -> OreCropBlock::tintColor)
                        .register();
                c.setCropBlock(cropBlockEntry);
                CROP_BLOCKS.put(c.getCropName(), cropBlockEntry);
            }
            if (c.getHarvestedItem() == null) {
                ItemEntry<OreHarvestedItem> harvestedItemEntry = REGISTRATE.item(c.getCropNameWithSuffix("harvested"), properties -> new OreHarvestedItem(c, properties))
                        .initialProperties(Item.Properties::new)
                        .color(() -> OreHarvestedItem::tintColor)
                        .tab(Objects.requireNonNull(CROP_HARVESTED_TAB.getKey()))
                        .register();
                c.setHarvestedItem(harvestedItemEntry);
                CROP_HARVESTED_ITEMS.put(c.getCropName(), harvestedItemEntry);
            }
            if (c.getSeedItem() == null) {
                ItemEntry<OreSeedItem> seedItemEntry = REGISTRATE.item(c.getCropNameWithSuffix("seed"), properties -> new OreSeedItem(c, properties))
                        .initialProperties(Item.Properties::new)
                        .color(() -> OreSeedItem::tintColor)
                        .tab(Objects.requireNonNull(CROP_SEEDS_TAB.getKey()))
                        .register();
                c.setSeedItem(seedItemEntry);
                CROP_SEED_ITEMS.put(c.getCropName(), seedItemEntry);
            }
        });
    }

}

