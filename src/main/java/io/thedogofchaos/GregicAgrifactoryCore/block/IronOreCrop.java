package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.registry.Registry;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class IronOreCrop extends CropBlock {
    // This is one of a few tests to get a feel for making crops before I try to make a Builder class or add direct GregTech material compat.
    public static final int MAX_AGE = 5;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public IronOreCrop(Properties properties) {
        super(properties);
    }

    @Override
    protected ItemLike getBaseSeedId(){
        return Registry.IRON_ORE_SEEDS.get();
    }

    @Override
    protected IntegerProperty getAgeProperty(){
        return AGE;
    }

    @Override
    public int getMaxAge(){
        return MAX_AGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
