package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedRegistry.REGISTRATE;

public class ModBlocks {
    public static final Crop becquerelliumCrop = ModPlants.Becquerellium; // shitty hack because of my own code
    public static final RegistryEntry<OreCropBlock> BECQUERELLIUM_CROP = REGISTRATE.block("becquerellium_crop", properties -> new OreCropBlock(becquerelliumCrop, properties))
            .initialProperties(() -> Blocks.WHEAT)
            .properties(BlockBehaviour.Properties::noLootTable)
            .color(() -> OreCropBlock::tintColor)
            .register();

    public static void init() {
        becquerelliumCrop.setCropBlock(BECQUERELLIUM_CROP);
    }
}
