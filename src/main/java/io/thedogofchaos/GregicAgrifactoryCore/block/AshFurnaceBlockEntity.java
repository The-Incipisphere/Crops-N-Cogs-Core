package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.gui.container.AshFurnaceContainer;
import io.thedogofchaos.GregicAgrifactoryCore.registry.BlockEntityRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * @!!! — The Ash Furnace is currently VERY broken.
 */
public class AshFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public static final int ASH_SLOT = 3;
    private int ashSlotFullness;

    public AshFurnaceBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.ASH_FURNACE_BLOCK_ENTITY.get(), pos, blockState, RecipeType.SMELTING);
        this.items = NonNullList.withSize(4, ItemStack.EMPTY);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.furnace");
    }

    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new AshFurnaceContainer(containerId, inventory, this, this.dataAccess);
    }

    /** @return AbstractFurnaceBlockEntity#litTime */
    @Override
    public boolean isLit(){
        return dataAccess.get(0) > 0;
    };

    public void load(CompoundTag tag) {
        super.load(tag);
        this.ashSlotFullness = tag.getInt("AshSlotFullness");
    }

    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        tag.putInt("AshSlotFullness", this.ashSlotFullness);
    }
}
