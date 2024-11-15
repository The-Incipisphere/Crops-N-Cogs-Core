package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.crops.Crop;
import net.minecraft.MethodsReturnNonnullByDefault;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

@MethodsReturnNonnullByDefault
public class OreCrop extends CropBlock implements Comparable<OreCrop> {
    private static int maxAge;
    private int color;

    private final Crop crop;

    public OreCrop(Crop crop) {
        super(Properties.copy(Blocks.WHEAT));
        this.crop = crop;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    @Override
    protected ItemLike getBaseSeedId(){
        return this.crop.getId();
    };

    @Override
    protected IntegerProperty getAgeProperty(){
        return AGE;
    };

    @Override
    public int compareTo(OreCrop oreCrop) {
        return toString().compareTo(oreCrop.toString());
    }

}
