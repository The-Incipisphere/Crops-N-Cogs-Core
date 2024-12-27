package io.thedogofchaos.GregicAgrifactoryCore.unified.registry;

import com.tterrag.registrate.util.entry.BlockEntry;
import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
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

import java.util.*;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedRegistry.REGISTRATE;

/*
 * Based on BlakeBr0's crop registry system for Mystical Agriculture
 */
public class CropRegistry implements ICropRegistry {
    private static final CropRegistry INSTANCE = new CropRegistry();

    private Map<ResourceLocation, Crop> crops = new LinkedHashMap<>();
    private final Map<String, RegistryEntry<OreCropBlock>> CROP_BLOCKS = new HashMap<>();
    private final Map<String, RegistryEntry<OreHarvestedItem>> CROP_HARVESTED_ITEMS = new HashMap<>();
    private final Map<String, RegistryEntry<OreSeedItem>> CROP_SEED_ITEMS = new HashMap<>();
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

    public void generateCrops() {
        var crops = this.crops.values();
        crops.forEach(c -> {
            if (c.getCropBlock() == null) {
                BlockEntry<OreCropBlock> cropBlockEntry = REGISTRATE.block(c.getCropNameWithSuffix("crop"), properties -> new OreCropBlock(c))
                        .initialProperties(() -> Blocks.WHEAT)
                        .properties(BlockBehaviour.Properties::noLootTable)
                        .color(() -> OreCropBlock::tintColor)
                        .register();
                CROP_BLOCKS.put(c.getCropName(), cropBlockEntry);
                c.setCropBlock(cropBlockEntry);
            }
            if (c.getHarvestedItem() == null) {
                ItemEntry<OreHarvestedItem> harvestedItemEntry = REGISTRATE.item(c.getCropNameWithSuffix("harvested"), properties -> new OreHarvestedItem(c))
                        .initialProperties(Item.Properties::new)
                        .color(() -> OreHarvestedItem::tintColor)
                        .register();

                CROP_HARVESTED_ITEMS.put(c.getCropName(), harvestedItemEntry);
                c.setHarvestedItem(harvestedItemEntry);
            }
            if (c.getSeedItem() == null) {
                // TODO: FIND A WAY TO REGISTER A SEED FOR THE GIVEN CROP (and have it functional as the seed for the given crop)
            }
        });
    }

}

