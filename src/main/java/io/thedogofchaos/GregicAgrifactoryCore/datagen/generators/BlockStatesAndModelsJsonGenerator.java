package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.datagen.GACBlockModelProvider;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BlockStatesAndModelsJsonGenerator extends BlockStateProvider {
    private final GACBlockModelProvider modelProv;

    public BlockStatesAndModelsJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
        modelProv = new GACBlockModelProvider(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        CropRegistry.getInstance().getCropBlocksAsOreCropBlock().forEach((cropName, blockEntry) -> {
            GregicAgrifactoryCore.LOGGER.info("CropBlock {} has the assigned CropBlock of {}",cropName,blockEntry.getCrop().getCropBlock());
        });
    }

    // TODO: adapt makeCrop to the new block model
//    public void makeCrop(CropBlock cropBlock, String texturePath, String modelName) {
//        Function<BlockState, ConfiguredModel[]> function = state -> cropStates(state, cropBlock, texturePath, modelName);
//        getVariantBuilder(cropBlock).forAllStates(function);
//    }
    // TODO: adapt cropStates to the new block model
//    private ConfiguredModel[] cropStates(BlockState state, CropBlock block, String texturePath, String modelName) {
//        ConfiguredModel[] models = new ConfiguredModel[1];
//        models[0] = new ConfiguredModel(
//                modelProv.flowerCropCross(
//
//
//                ).renderType("cutout")
//        );
//        return models;
//    }
}
