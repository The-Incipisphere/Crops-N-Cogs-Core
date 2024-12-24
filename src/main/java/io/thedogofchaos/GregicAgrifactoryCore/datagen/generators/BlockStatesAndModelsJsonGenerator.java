package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BlockStatesAndModelsJsonGenerator extends BlockStateProvider {
    public BlockStatesAndModelsJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

    }

    public void makeCrop(CropBlock cropBlock, String texturePath, String modelName) {
        Function<BlockState, ConfiguredModel[]> function = state -> cropStates(state, cropBlock, texturePath, modelName);
        getVariantBuilder(cropBlock).forAllStates(function);
    }

    private ConfiguredModel[] cropStates(BlockState state, CropBlock block, String texturePath, String modelName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                models().cross(
                        modelName + state.getValue(((OreCropBlock) block).getAgeProperty()),
                        new ResourceLocation(
                                GregicAgrifactoryCore.MOD_ID,
                                "block/crop/" + texturePath + modelName + state.getValue(((OreCropBlock) block).getAgeProperty())
                        )
                ).renderType("cutout").parent(models().getExistingFile(new ResourceLocation("minecraft", "block/cross"))));
        return models;
    }
}
