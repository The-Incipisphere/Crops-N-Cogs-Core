package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.MagnetiteCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

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
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.MAGNETITE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MagnetiteCropBlock.AGE, 5));

        this.add(ModBlocks.MAGNETITE_CROP.get(), createCropDrops(ModBlocks.MAGNETITE_CROP.get(), ModItems.MAGNETITE_HARVESTED.get(),
                ModItems.MAGNETITE_SEEDS.get(), lootitemcondition$builder));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream()
                .filter(e -> e.getKey().location().getNamespace().equals(GregicAgrifactoryCore.MOD_ID))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}
