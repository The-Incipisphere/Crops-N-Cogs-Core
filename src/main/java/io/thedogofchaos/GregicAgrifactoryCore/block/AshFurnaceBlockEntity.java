package io.thedogofchaos.GregicAgrifactoryCore.block;

import com.gregtechceu.gtceu.api.data.chemical.ChemicalHelper;
import com.gregtechceu.gtceu.api.registry.GTRegistry;
import com.gregtechceu.gtceu.common.data.GTItems;
import com.gregtechceu.gtceu.common.data.GTMaterials;
import io.thedogofchaos.GregicAgrifactoryCore.gui.container.AshFurnaceMenu;
import io.thedogofchaos.GregicAgrifactoryCore.registry.BlockEntityRegistry;
import io.thedogofchaos.GregicAgrifactoryCore.registry.BlockRegistry;
import io.thedogofchaos.GregicAgrifactoryCore.util.AdaptedItemHandler;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
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
import net.minecraft.world.level.block.entity.FurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import static com.gregtechceu.gtceu.api.data.tag.TagPrefix.dust;
import static com.gregtechceu.gtceu.common.data.GTMaterials.Ash;

public class AshFurnaceBlockEntity extends AbstractFurnaceBlockEntity {
    public static final int ASH_SLOT = 3;
    private int ashSlotFullness;

    public AshFurnaceBlockEntity(BlockPos pos, BlockState blockState) {
        super(BlockEntityRegistry.ASH_FURNACE_BLOCK_ENTITY.get(), pos, blockState, RecipeType.SMELTING);
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.furnace");
    }

    protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
        return new AshFurnaceMenu(containerId, inventory, this, this.dataAccess);
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
