package io.thedogofchaos.GregicAgrifactoryCore.unified.gui.container;

import io.thedogofchaos.GregicAgrifactoryCore.unified.gui.slots.AshSlot;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.crafting.RecipeType;

/**
 * @!!! — The Ash Furnace is currently VERY broken.
 */
public class AshFurnaceContainer extends AbstractFurnaceMenu {
    private final Container container;
    private final ContainerData data;

    public AshFurnaceContainer(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new SimpleContainer(4), new SimpleContainerData(4));
    }

    public AshFurnaceContainer(int containerId, Inventory playerInventory, Container container, ContainerData data) {
        super(null, RecipeType.SMELTING, RecipeBookType.FURNACE, containerId, playerInventory);
        checkContainerSize(container, 4);
        checkContainerDataCount(data, 4);
        this.container = container;
        this.data = data;
        this.addSlot(new AshSlot(playerInventory.player, container, 3, 38, 53));
        this.addDataSlots(data);
    }
}
