package io.thedogofchaos.GregicAgrifactoryCore.datagen.loot;

import io.thedogofchaos.GregicAgrifactoryCore.block.IronOreCrop;
import io.thedogofchaos.GregicAgrifactoryCore.registry.Registry;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;

import java.util.Set;

public class BlockLootTables extends BlockLootSubProvider {
    public BlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(Registry.IRON_ORE_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(IronOreCrop.AGE, 5));

        this.add(Registry.IRON_ORE_CROP.get(), createCropDrops(Registry.IRON_ORE_CROP.get(), Items.IRON_ORE,
                Registry.IRON_ORE_SEEDS.get(), lootitemcondition$builder));

    }
}
