package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Plant;
import lombok.Getter;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/** The common class for ALL OreCrops. */
public class OreCropBlock extends CropBlock {
    // Use a Supplier to delay figuring out the value of seedItem until getBaseSeedId() is called, to stop the game shitting itself because said seedItem isn't registered yet.
    private final Supplier<ItemLike> seedItem; // Delayed initialisation for seed items.
    private final Plant plant;

    //public OreCropBlock(Properties properties, Supplier<ItemLike> seedItem, int flowerColor, String textureSetName) {
        // this(properties, seedItem, flowerColor, 0x177b04, textureSetName);
    //}
    public OreCropBlock(Plant plant) {
        super(Properties.copy(Blocks.WHEAT));
        this.plant = plant;

    }

    @Override
    protected ItemLike getBaseSeedId() {
        // This would not be possible if I passed ModItems.INSERTSEEDIDHERE.get()
        // directly as a parameter of the constructor when instantiating this class
        // for reasons explained at seedItem’s field definition.
        return seedItem.get();
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

/*  // Come back to these methods if I decide that I want biome requirements for crops.
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
