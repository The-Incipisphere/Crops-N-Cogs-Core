package io.thedogofchaos.GregicAgrifactoryCore.block;

import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

/**
 * This is a SINCERELY hacky extension of {@link AbstractFurnaceBlockEntity} right here:
 * Apparently, to add the ability for furnaces to produce ash when a fuel item has finished burning,
 * I need to recreate the ENTIRE {@code serverTick} method and most of its dependent methods and fields
 * since basically all of them are fucking PRIVATE OR STATIC.
 */
public class AshFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public static final String ITEMS_TAG = "Inventory";

    public static int SLOT_COUNT = 1;
    public static int SLOT = 0;
    private int litTime;
    private int litDuration;
    private int cookingProgress;
    private final Object2IntOpenHashMap<ResourceLocation> recipesUsed;
    private final RecipeManager.CachedCheck<Container, ? extends AbstractCookingRecipe> quickCheck;

    public AshFurnaceBlockEntity(BlockPos pos, BlockState blockState, Object2IntOpenHashMap<ResourceLocation> recipesUsed, RecipeManager.CachedCheck<Container, ? extends AbstractCookingRecipe> quickCheck) {
        super(BlockEntityType.FURNACE, pos, blockState, RecipeType.SMELTING);
        this.recipesUsed = recipesUsed;
        this.quickCheck = quickCheck;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.furnace");
    }

    @Override
    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return null;
    }

    private boolean isLit() {
        return this.litTime > 0;
    }

    // just replacing blockEntity with 'this' and hoping for the best atm
    public void tickServer(Level level, BlockPos pos, BlockState state) {
        boolean flag = this.isLit();
        boolean flag1 = false;
        if (this.isLit()) {
            --this.litTime;
        }

        ItemStack itemstack = (ItemStack)this.items.get(1);
        boolean flag2 = !((ItemStack)this.items.get(0)).isEmpty();
        boolean flag3 = !itemstack.isEmpty();
        if (this.isLit() || flag3 && flag2) {
            Recipe<?> recipe;
            if (flag2) {
                recipe = (Recipe)this.quickCheck.getRecipeFor(this, level).orElse((Object)null);
            } else {
                recipe = null;
            }

            int i = this.getMaxStackSize();
            if (!this.isLit() && this.canBurn(level.registryAccess(), recipe, this.items, i)) {
                setItem(1, GTCEu.);
                this.litTime = this.getBurnDuration(itemstack);
                this.litDuration = this.litTime;
                if (this.isLit()) {
                    flag1 = true;
                    if (itemstack.hasCraftingRemainingItem()) {
                        this.items.set(1, itemstack.getCraftingRemainingItem());
                    } else if (flag3) {
                        Item item = itemstack.getItem();
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            this.items.set(1, itemstack.getCraftingRemainingItem());
                        }
                    }
                }
            }

            if (this.isLit() && this.canBurn(level.registryAccess(), recipe, this.items, i)) {
                ++this.cookingProgress;
                if (this.cookingProgress == this.cookingTotalTime) {
                    this.cookingProgress = 0;
                    this.cookingTotalTime = getTotalCookTime(level, this);
                    if (this.burn(level.registryAccess(), recipe, this.items, i)) {
                        this.setRecipeUsed(recipe);
                    }

                    flag1 = true;
                }
            } else {
                this.cookingProgress = 0;
            }
        } else if (!this.isLit() && this.cookingProgress > 0) {
            this.cookingProgress = Mth.clamp(this.cookingProgress - 2, 0, blockEntity.cookingTotalTime);
        }

        if (flag != blockEntity.isLit()) {
            flag1 = true;
            state = (BlockState)state.setValue(AbstractFurnaceBlock.LIT, blockEntity.isLit());
            level.setBlock(pos, state, 3);
        }

        if (flag1) {
            setChanged(level, pos, state);
        }

    }

    private boolean canBurn(RegistryAccess recipe, @Nullable Recipe<?> inventory, NonNullList<ItemStack> maxStackSize, int i) {
        if (!((ItemStack)maxStackSize.get(0)).isEmpty() && inventory != null) {
            ItemStack itemstack = inventory.assemble(this, recipe);
            if (itemstack.isEmpty()) {
                return false;
            } else {
                ItemStack itemstack1 = (ItemStack)maxStackSize.get(2);
                if (itemstack1.isEmpty()) {
                    return true;
                } else if (!ItemStack.isSameItem(itemstack1, itemstack)) {
                    return false;
                } else if (itemstack1.getCount() + itemstack.getCount() <= i && itemstack1.getCount() + itemstack.getCount() <= itemstack1.getMaxStackSize()) {
                    return true;
                } else {
                    return itemstack1.getCount() + itemstack.getCount() <= itemstack.getMaxStackSize();
                }
            }
        } else {
            return false;
        }
    }
}
