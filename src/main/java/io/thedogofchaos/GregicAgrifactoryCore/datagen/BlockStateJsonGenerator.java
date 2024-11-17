package io.thedogofchaos.GregicAgrifactoryCore.datagen;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.IronOreCrop;
import io.thedogofchaos.GregicAgrifactoryCore.registry.CropRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BlockStateJsonGenerator extends BlockStateProvider {
    public BlockStateJsonGenerator(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GregicAgrifactoryCore.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        makeIronOreCrop((CropBlock) CropRegistry.IRON_ORE_CROP.get(), "iron_ore_crop_age", "iron_ore_crop_age", "crop/iron_ore/");
    }

    public void makeIronOreCrop(CropBlock block, String modelName, String textureName, String path) {
        Function<BlockState, ConfiguredModel[]> function = state -> ironOreCropStates(state, block, modelName, textureName, path);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] ironOreCropStates(BlockState state, CropBlock block, String modelName, String textureName, String path) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((IronOreCrop) block).getAgeProperty()),
                new ResourceLocation(GregicAgrifactoryCore.MOD_ID, "block/" + path + textureName + state.getValue(((IronOreCrop) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
}
