package io.thedogofchaos.GregicAgrifactoryCore.gui.container;

import io.thedogofchaos.GregicAgrifactoryCore.block.AshFurnaceBlockEntity;
import io.thedogofchaos.GregicAgrifactoryCore.gui.slots.AshSlot;
import io.thedogofchaos.GregicAgrifactoryCore.registry.BlockRegistry;
import io.thedogofchaos.GregicAgrifactoryCore.registry.MenuRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class AshFurnaceMenu extends AbstractFurnaceMenu {
    private final Container container;

    public AshFurnaceMenu(MenuType<?> menuType, RecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookType recipeBookType, int containerId, Inventory playerInventory) {
        this(menuType, recipeType, recipeBookType, containerId, playerInventory, new SimpleContainer(3), new SimpleContainerData(4));
    }

    public AshFurnaceMenu(MenuType<?> menuType, RecipeType<? extends AbstractCookingRecipe> recipeType, RecipeBookType recipeBookType, int containerId, Inventory playerInventory, Container container, ContainerData data) {
        super(menuType, recipeType, recipeBookType, containerId, playerInventory);
        this.container = container;

        this.addSlot(new AshSlot(playerInventory.player, container, 4, 38, 53));

        this.addDataSlots(data);
    }

    @Override
    public boolean stillValid(Player player) {
        return this.container.stillValid(player);
    }

}
