package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/** The common class for ALL OreCrops. */
public class OreCropBlock extends CropBlock implements ICropProvider {
    private final Crop crop;

    public OreCropBlock(Crop crop) {
        super(Properties.copy(Blocks.WHEAT));
        this.crop = crop;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource random, BlockPos pos, BlockState state) {
        return false;
    }

    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.getBlock() instanceof FarmBlock;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return this.crop.getSeedItem();
    }

    @Override
    public Crop getCrop() {
        return this.crop;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!this.canGrow(level, pos))
            return;
        super.randomTick(state, level, pos, random);
    }

    private boolean canGrow(Level level, BlockPos pos) {
        var biomes = this.crop.getCropInfo().getRequiredBiomes();
        if (!biomes.isEmpty()) {
            var biome = level.getBiome(pos);
            var biomeId = ForgeRegistries.BIOMES.getKey(biome.value());
            return biomes.contains(biomeId);
        }
        return true;
    }
}
