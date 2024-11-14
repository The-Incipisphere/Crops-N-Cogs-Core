package io.thedogofchaos.GregicAgrifactoryCore.crops;

import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class OreCrop extends CropBlock {
    public static final int MAX_AGE = 5;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public OreCrop(Properties pProperties) {
        super(pProperties);
    }
}
