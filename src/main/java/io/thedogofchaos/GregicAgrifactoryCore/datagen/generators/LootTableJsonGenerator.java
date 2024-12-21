package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class LootTableJsonGenerator extends BlockLootSubProvider {
    public LootTableJsonGenerator() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate(){
        // Vanilla Materials
        this.add(ModBlocks.GOLD_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.GOLD_CROP.get(),
                        ModItems.GOLD_HARVESTED.get(),
                        ModItems.GOLD_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.COAL_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.COAL_CROP.get(),
                        ModItems.COAL_HARVESTED.get(),
                        ModItems.COAL_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.REDSTONE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.REDSTONE_CROP.get(),
                        ModItems.REDSTONE_HARVESTED.get(),
                        ModItems.REDSTONE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.DIAMOND_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.DIAMOND_CROP.get(),
                        ModItems.DIAMOND_HARVESTED.get(),
                        ModItems.DIAMOND_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.EMERALD_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.EMERALD_CROP.get(),
                        ModItems.EMERALD_HARVESTED.get(),
                        ModItems.EMERALD_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.AMETHYST_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.AMETHYST_CROP.get(),
                        ModItems.AMETHYST_HARVESTED.get(),
                        ModItems.AMETHYST_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.NETHER_QUARTZ_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.NETHER_QUARTZ_CROP.get(),
                        ModItems.NETHER_QUARTZ_HARVESTED.get(),
                        ModItems.NETHER_QUARTZ_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        // GT Materials
        // Metals
        this.add(ModBlocks.MAGNETITE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.MAGNETITE_CROP.get(),
                        ModItems.MAGNETITE_HARVESTED.get(),
                        ModItems.MAGNETITE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.CHALCOPYRITE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.CHALCOPYRITE_CROP.get(),
                        ModItems.CHALCOPYRITE_HARVESTED.get(),
                        ModItems.CHALCOPYRITE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.CASSITERITE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.CASSITERITE_CROP.get(),
                        ModItems.CASSITERITE_HARVESTED.get(),
                        ModItems.CASSITERITE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.NICKEL_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.NICKEL_CROP.get(),
                        ModItems.NICKEL_HARVESTED.get(),
                        ModItems.NICKEL_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.SILVER_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.SILVER_CROP.get(),
                        ModItems.SILVER_HARVESTED.get(),
                        ModItems.SILVER_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.COBALT_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.COBALT_CROP.get(),
                        ModItems.COBALT_HARVESTED.get(),
                        ModItems.COBALT_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.LEAD_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.LEAD_CROP.get(),
                        ModItems.LEAD_HARVESTED.get(),
                        ModItems.LEAD_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.SPHALERITE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.SPHALERITE_CROP.get(),
                        ModItems.SPHALERITE_HARVESTED.get(),
                        ModItems.SPHALERITE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        // Gems
        this.add(ModBlocks.RUBY_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.RUBY_CROP.get(),
                        ModItems.RUBY_HARVESTED.get(),
                        ModItems.RUBY_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.SAPPHIRE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.SAPPHIRE_CROP.get(),
                        ModItems.SAPPHIRE_HARVESTED.get(),
                        ModItems.SAPPHIRE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.GREEN_SAPPHIRE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.GREEN_SAPPHIRE_CROP.get(),
                        ModItems.GREEN_SAPPHIRE_HARVESTED.get(),
                        ModItems.GREEN_SAPPHIRE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.TOPAZ_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.TOPAZ_CROP.get(),
                        ModItems.TOPAZ_HARVESTED.get(),
                        ModItems.TOPAZ_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.APATITE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.APATITE_CROP.get(),
                        ModItems.APATITE_HARVESTED.get(),
                        ModItems.APATITE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.OPAL_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.OPAL_CROP.get(),
                        ModItems.OPAL_HARVESTED.get(),
                        ModItems.OPAL_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.CINNABAR_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.CINNABAR_CROP.get(),
                        ModItems.CINNABAR_HARVESTED.get(),
                        ModItems.CINNABAR_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.REALGAR_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.REALGAR_CROP.get(),
                        ModItems.REALGAR_HARVESTED.get(),
                        ModItems.REALGAR_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.CERTUS_QUARTZ_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.CERTUS_QUARTZ_CROP.get(),
                        ModItems.CERTUS_QUARTZ_HARVESTED.get(),
                        ModItems.CERTUS_QUARTZ_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.QUARTZITE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.QUARTZITE_CROP.get(),
                        ModItems.QUARTZITE_HARVESTED.get(),
                        ModItems.QUARTZITE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.SALT_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.SALT_CROP.get(),
                        ModItems.SALT_HARVESTED.get(),
                        ModItems.SALT_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        // Misc
        this.add(ModBlocks.SALTPETRE_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.SALTPETRE_CROP.get(),
                        ModItems.SALTPETRE_HARVESTED.get(),
                        ModItems.SALTPETRE_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
        this.add(ModBlocks.SULPHUR_CROP.get(),
                alwaysSingleSeedDrop(
                        ModBlocks.SULPHUR_CROP.get(),
                        ModItems.SULPHUR_HARVESTED.get(),
                        ModItems.SULPHUR_SEEDS.get(),
                        OreCropBlock.AGE
                )
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(GregicAgrifactoryCore.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }


    /** Guarantees a single seed item to always drop from a crop when the crop is broken.
     * <br>Also drops the crop’s harvested item if the crop is fully grown.
     * @param cropBlock The crop block to generate a loot table for.
     * @param harvestedItem The harvested item to drop when the {@code cropBlock} is broken, if the crop is fully grown.
     * @param seedItem The seed to always drop 1 of when the cropBlock is broken.
     * @param ageProperty An {@link IntegerProperty} of the crop’s AGE field.
     * @return The LootTable Builder, to continue building loot tables if need be.
     */
    public LootTable.Builder alwaysSingleSeedDrop(Block cropBlock, Item harvestedItem, Item seedItem, IntegerProperty ageProperty) {
        return applyExplosionDecay(
                cropBlock,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(harvestedItem)
                                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock)
                                                .setProperties(StatePropertiesPredicate.Builder.properties()
                                                        .hasProperty(ageProperty, 7)
                                                )
                                        ).otherwise(LootItem.lootTableItem(seedItem))
                                )
                        )
                        .withPool(LootPool.lootPool()
                                .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock)
                                        .setProperties(StatePropertiesPredicate.Builder.properties()
                                                .hasProperty(ageProperty, 7)
                                        )
                                )
                                .add(LootItem.lootTableItem(seedItem))
                        )

        );
    }
}
