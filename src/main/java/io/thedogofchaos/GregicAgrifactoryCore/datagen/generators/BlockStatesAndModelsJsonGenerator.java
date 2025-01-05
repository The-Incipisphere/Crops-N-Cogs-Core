package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.datagen.GACBlockModelProvider;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.function.Function;

public class BlockStatesAndModelsJsonGenerator extends BlockStateProvider {
    private final GACBlockModelProvider modelProv;

    public BlockStatesAndModelsJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
        modelProv = new GACBlockModelProvider(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {/**/}

    @Override
    public VariantBlockStateBuilder getVariantBuilder(Block b) {
        return super.getVariantBuilder(b);
    }
}
