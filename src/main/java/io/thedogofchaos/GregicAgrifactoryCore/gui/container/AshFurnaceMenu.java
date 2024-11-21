package io.thedogofchaos.GregicAgrifactoryCore.gui.container;

import io.thedogofchaos.GregicAgrifactoryCore.registry.MenuRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import io.thedogofchaos.GregicAgrifactoryCore.util.SlotHelper;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;

public class AshFurnaceMenu extends AbstractFurnaceMenu {
    private final BlockPos blockPos;

    protected AshFurnaceMenu(MenuType<?> menuType, RecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookType recipeBookType, int containerId, Inventory playerInventory) {
        super(menuType, recipeType, recipeBookType, containerId, playerInventory);
        //super(MenuRegistry.ASH_FURNACE_CONTAINER.get(), windowId);
        //this.blockPos = blockPos;
        //SlotHelper.layoutPlayerInventorySlots(this::addSlot, player.getInventory(), 10, 70);
    }

    private int addSlotRange(Container playerInventory, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(new Slot(playerInventory, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private int addSlotBox(Container playerInventory, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(playerInventory, index, x, y, horAmount, dx);
            y += dy;
        }
        return index;
    }

    private void layoutPlayerInventorySlots(Container playerInventory, int leftCol, int topRow) {
        // Player inventory
        addSlotBox(playerInventory, 9, leftCol, topRow, 9, 18, 3, 18);

        // Hotbar
        topRow += 58;
        addSlotRange(playerInventory, 0, leftCol, topRow, 9, 18);
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        return null;
    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }

}
