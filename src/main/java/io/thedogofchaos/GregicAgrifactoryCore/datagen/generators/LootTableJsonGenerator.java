package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Shouldn't need this class any more.
 *
 * @deprecated as of 7th January 2025. Try and use Registrate’s built-in datagen where possible.
 */
@Deprecated
public class LootTableJsonGenerator extends BlockLootSubProvider {
    public LootTableJsonGenerator() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(GregicAgrifactoryCore.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }


    /**
     * Guarantees a single seed item to always drop from a crop when the crop is broken.
     * <br>Also drops the crop’s harvested item if the crop is fully grown.
     *
     * @param cropBlock     The crop block to generate a loot table for.
     * @param harvestedItem The harvested item to drop when the {@code cropBlock} is broken, if the crop is fully grown.
     * @param seedItem      The seed to always drop 1 of when the cropBlock is broken.
     * @param ageProperty   An {@link IntegerProperty} of the crop’s AGE field.
     * @return The LootTable Builder, to continue building loot tables if need be.
     */
    public LootTable.Builder alwaysSingleSeedDrop(Block cropBlock, Item harvestedItem, Item seedItem, IntegerProperty ageProperty) {
        return applyExplosionDecay(
                cropBlock,
                LootTable.lootTable()


        );
    }
}
