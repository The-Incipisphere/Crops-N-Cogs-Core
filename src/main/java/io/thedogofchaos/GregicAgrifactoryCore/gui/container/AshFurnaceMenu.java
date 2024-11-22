package io.thedogofchaos.GregicAgrifactoryCore.gui.container;

import io.thedogofchaos.GregicAgrifactoryCore.block.AshFurnaceBlockEntity;
import io.thedogofchaos.GregicAgrifactoryCore.registry.BlockRegistry;
import io.thedogofchaos.GregicAgrifactoryCore.registry.MenuRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class AshFurnaceMenu extends AbstractContainerMenu {
    private final BlockPos pos;

    public AshFurnaceMenu(int containerId, Player player, BlockPos pos) {
        super(MenuRegistry.ASH_FURNACE_CONTAINER.get(), containerId);
        this.pos = pos;
        if (player.level().getBlockEntity(pos) instanceof AshFurnaceBlockEntity furnace) {
            addSlot(new SlotItemHandler(furnace.getInputItems(), AshFurnaceBlockEntity.INPUT_SLOT, 64, 24));
            addSlot(new SlotItemHandler(furnace.getFuelItems(), AshFurnaceBlockEntity.FUEL_SLOT, 108, 24));
            addSlot(new SlotItemHandler(furnace.getOutputItems(), AshFurnaceBlockEntity.OUTPUT_SLOT, 126, 24));
            addSlot(new SlotItemHandler(furnace.getAshItems(), AshFurnaceBlockEntity.ASH_SLOT, 144, 24));
        }
    }


    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(ContainerLevelAccess.create(player.level(), pos), player, BlockRegistry.ASH_FURNACE.get());
    }

}
