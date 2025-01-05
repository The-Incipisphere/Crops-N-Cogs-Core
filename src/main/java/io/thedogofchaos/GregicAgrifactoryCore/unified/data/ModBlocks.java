package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.datagen.GACBlockModelProvider;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.client.model.generators.BlockStateProvider;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedRegistry.REGISTRATE;

public class ModBlocks {
    public static final Crop becquerelliumCrop = ModPlants.Becquerellium; // shitty hack because of my own code.
    public static final RegistryEntry<OreCropBlock> BECQUERELLIUM_CROP = REGISTRATE
            .block("becquerellium_crop", properties -> new OreCropBlock(becquerelliumCrop, properties))
            .initialProperties(() -> Blocks.WHEAT)
            .properties(BlockBehaviour.Properties::noLootTable)
            .color(() -> OreCropBlock::tintColor)
            .blockstate((context, provider) ->
                    provider.simpleBlock(
                            context,
                            provider,
                            /*TODO: figure out blockStates here
                             * must point to the model gregicagrifactory/models/block/plant_assets/flower_crop_cross
                             * must point to the relevant textures within gregicagrifactory/textures/block/plant_assets/crop/<cropHeight>/<textureSet>/<cropAge>/
                             * where cropHeight is the height of the given crop,
                             * textureSet is the assigned texture set of the crop,
                             * and cropAge is the textures for each crop age.
                             */
                            blockState -> provider.models().withExistingParent(
                                    becquerelliumCrop.getCropInfo().getTextures().getPlantBlockTextures().getPath(),
                                    provider.modLoc("block")
                            )
                    )
            )
            .register();

    public static void init() {
        becquerelliumCrop.setCropBlock(BECQUERELLIUM_CROP);
    }
}
