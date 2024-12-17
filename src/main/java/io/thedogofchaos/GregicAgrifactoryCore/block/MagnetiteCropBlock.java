package io.thedogofchaos.GregicAgrifactoryCore.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

public class MagnetiteCropBlock extends CropBlock {

    public MagnetiteCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.MAGNETITE_SEEDS.get();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

/*
    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!this.canGrow(level, pos))
            return;
        super.randomTick(state, level, pos, random);
    }

    private boolean canGrow(Level level, BlockPos pos) {
        return true;
    }
*/
}
