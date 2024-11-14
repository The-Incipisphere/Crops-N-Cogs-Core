package io.thedogofchaos.GregicAgrifactoryCore.crops;

import io.thedogofchaos.GregicAgrifactoryCore.registry.registrate.BuilderBase;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.List;

public class OreCrop extends CropBlock implements Comparable<OreCrop> {
    private int maxAge;
    private int color;

    public OreCrop(Properties properties, Builder builder) {
        super(properties);
    }
    @Override
    public int compareTo(OreCrop oreCrop) {
        return toString().compareTo(oreCrop.toString());
    }

    public static class Builder extends BuilderBase<OreCrop> {

        public Builder(ResourceLocation id, Object... args) {
            super(id, args);
        }

        @Override
        public OreCrop register() {
            return null;
        }
    }
}
