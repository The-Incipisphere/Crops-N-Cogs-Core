package io.thedogofchaos.GregicAgrifactoryCore.gui.slots;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraftforge.event.ForgeEventFactory;

public class AshSlot extends Slot {
    private final Player player;
    private int removeCount;

    public AshSlot(Player player, Container container, int slot, int xPosition, int yPosition) {
        super(container, slot, xPosition, yPosition);
        this.player = player;
    }

    public boolean mayPlace(ItemStack stack) {
        return false;
    }

    public ItemStack remove(int amount) {
        if (this.hasItem()) {
            this.removeCount += Math.min(amount, this.getItem().getCount());
        }
        return super.remove(amount);
    }

    public void onTake(Player player, ItemStack stack) {
        super.onTake(player, stack);
    }

    protected void onQuickCraft(ItemStack stack, int amount) {
        this.removeCount += amount;
    }
}
