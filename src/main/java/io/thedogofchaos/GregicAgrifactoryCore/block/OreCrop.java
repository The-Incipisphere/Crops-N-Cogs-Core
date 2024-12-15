package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.organic.IPlantProvider;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Plant;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

public class OreCrop extends CropBlock implements IPlantProvider {

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
        return true; //
    }

    /**
     * Gets the {@link Plant} from this object.
     *
     * @return The {@link Plant}
     */
    @Override
    public Plant getPlant() {
        return null;
    }
}
