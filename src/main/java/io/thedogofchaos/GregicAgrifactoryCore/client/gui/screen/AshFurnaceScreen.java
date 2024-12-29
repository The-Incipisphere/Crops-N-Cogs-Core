package io.thedogofchaos.GregicAgrifactoryCore.client.gui.screen;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.unified.gui.container.AshFurnaceContainer;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

/**
 * @!!! — The Ash Furnace is currently VERY broken.
 */
public class AshFurnaceScreen extends AbstractContainerScreen<AshFurnaceContainer> {
    private final ResourceLocation GUI = new ResourceLocation(GregicAgrifactoryCore.MOD_ID, "textures/gui/furnace.png");

    public AshFurnaceScreen(AshFurnaceContainer containerMenu, Inventory playerInventory, Component title) {
        super(containerMenu, playerInventory, title);
        this.inventoryLabelY = this.imageHeight - 110;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        int relX = (this.width - this.imageWidth) / 2;
        int relY = (this.height - this.imageHeight) / 2;
        guiGraphics.blit(GUI, relX, relY, 0, 0, this.imageWidth, this.imageHeight);
    }
}
