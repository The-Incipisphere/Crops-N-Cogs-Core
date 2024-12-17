package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.MagnetiteCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BlockStateJsonGenerator extends BlockStateProvider {
    // Note to self: This will need to be built to handle Model/Blockstate generation of Crops/Bushes at runtime.
    public BlockStateJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeMagnetiteCrop((CropBlock) ModBlocks.MAGNETITE_CROP.get(), "magnetite_crop_age", "magnetite_crop_age");
    }

    public void makeMagnetiteCrop(CropBlock cropBlock, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> magnetiteCropStates(state, cropBlock, modelName, textureName);
        getVariantBuilder(cropBlock).forAllStates(function);
    }

    private ConfiguredModel[] magnetiteCropStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                models().cross(
                        modelName + state.getValue(((MagnetiteCropBlock) block).getAgeProperty()),
                        new ResourceLocation(
                                GregicAgrifactoryCore.MOD_ID,
                                "block/crop/magnetite/" + textureName + state.getValue(((MagnetiteCropBlock) block).getAgeProperty())
                        )
                ).renderType("cutout").parent(models().getExistingFile(new ResourceLocation("minecraft", "block/cross"))));
        return models;
    }
}
