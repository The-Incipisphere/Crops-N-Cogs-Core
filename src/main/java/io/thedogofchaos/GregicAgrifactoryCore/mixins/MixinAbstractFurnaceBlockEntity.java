package io.thedogofchaos.GregicAgrifactoryCore.mixins;

import dev.architectury.patchedmixin.staticmixin.spongepowered.asm.mixin.Mixin;
import dev.architectury.patchedmixin.staticmixin.spongepowered.asm.mixin.Overwrite;
import dev.architectury.patchedmixin.staticmixin.spongepowered.asm.mixin.Shadow;
import dev.architectury.patchedmixin.staticmixin.spongepowered.asm.mixin.injection.At;
import dev.architectury.patchedmixin.staticmixin.spongepowered.asm.mixin.injection.Inject;
import dev.architectury.patchedmixin.staticmixin.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

// Main logic overwrite. This feels hacky.
@Mixin(AbstractFurnaceBlockEntity.class)
public class MixinAbstractFurnaceBlockEntity {
    @Overwrite
    private static void serverTick(Level level, BlockPos pos, BlockState state, AbstractFurnaceBlockEntity blockEntity, CallbackInfo callbackInfo) {
        boolean flag = blockEntity.isLit();
        boolean flag1 = false;
        if (blockEntity.isLit()) {
            --blockEntity.litTime;
        }

        ItemStack itemstack = (ItemStack)blockEntity.items.get(1);
        boolean flag2 = !((ItemStack)blockEntity.items.get(0)).isEmpty();
        boolean flag3 = !itemstack.isEmpty();
        if (!blockEntity.isLit() && (!flag3 || !flag2)) {
            if (!blockEntity.isLit() && blockEntity.cookingProgress > 0) {
                blockEntity.cookingProgress = Mth.clamp(blockEntity.cookingProgress - 2, 0, blockEntity.cookingTotalTime);
            }
        } else {
            Recipe recipe;
            if (flag2) {
                recipe = (Recipe)blockEntity.quickCheck.getRecipeFor(blockEntity, level).orElse((Object)null);
            } else {
                recipe = null;
            }

            int i = blockEntity.getMaxStackSize();
            if (!blockEntity.isLit() && blockEntity.canBurn(level.registryAccess(), recipe, blockEntity.items, i)) {
                blockEntity.litTime = blockEntity.getBurnDuration(itemstack);
                blockEntity.litDuration = blockEntity.litTime;
                if (blockEntity.isLit()) {
                    flag1 = true;
                    if (itemstack.hasCraftingRemainingItem()) {
                        blockEntity.items.set(1, itemstack.getCraftingRemainingItem());
                    } else if (flag3) {
                        Item item = itemstack.getItem();
                        itemstack.shrink(1);
                        if (itemstack.isEmpty()) {
                            blockEntity.items.set(1, itemstack.getCraftingRemainingItem());
                        }
                    }
                }
            }

            if (blockEntity.isLit() && blockEntity.canBurn(level.registryAccess(), recipe, blockEntity.items, i)) {
                ++blockEntity.cookingProgress;
                if (blockEntity.cookingProgress == blockEntity.cookingTotalTime) {
                    blockEntity.cookingProgress = 0;
                    blockEntity.cookingTotalTime = getTotalCookTime(level, blockEntity);
                    if (blockEntity.burn(level.registryAccess(), recipe, blockEntity.items, i)) {
                        blockEntity.setRecipeUsed(recipe);
                    }

                    flag1 = true;
                }
            } else {
                blockEntity.cookingProgress = 0;
            }
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

    @Shadow

}
