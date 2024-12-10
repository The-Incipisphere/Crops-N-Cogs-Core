package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.plants.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.IPlantProvider;
import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.Plant;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;

public class OreCrop extends CropBlock implements IPlantProvider {
    private static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 4.0D, 16.0D);
    public HashMap cropType;
    private Crop crop;

    public OreCrop(Properties properties) {
        super(Properties.copy(Blocks.WHEAT));
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!this.canGrow(level, pos))
            return;

        super.randomTick(state, level, pos, random);
    }

    private boolean canGrow(Level level, BlockPos pos) {
        var biomes = this.crop.getRequiredBiomes();

        if (!biomes.isEmpty()) {
            var biome = level.getBiome(pos);
            var biomeId = ForgeRegistries.BIOMES.getKey(biome.value());
            return biomes.contains(biomeId);
        }

        return true;
    }

    @Override
    public Plant getPlant() {
        return this.crop;
    }
}
