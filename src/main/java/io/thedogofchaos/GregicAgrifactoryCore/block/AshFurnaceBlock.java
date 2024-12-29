package io.thedogofchaos.GregicAgrifactoryCore.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/**
 * @!!! — The Ash Furnace is currently VERY broken.
 */
public class AshFurnaceBlock extends AbstractFurnaceBlock {
    public AshFurnaceBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.FURNACE));
    }

    @Override
    protected void openContainer(Level level, BlockPos pos, Player player) {
        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof AshFurnaceBlockEntity) {
            player.openMenu((MenuProvider) blockEntity);
        } else {
            throw new IllegalStateException("Expected to open AshFurnaceBlockEntity but found: " + blockEntity.getClass().getName());
        }
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new AshFurnaceBlockEntity(pos, state);
    }
}
