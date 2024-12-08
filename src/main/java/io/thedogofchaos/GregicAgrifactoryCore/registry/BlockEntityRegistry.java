package io.thedogofchaos.GregicAgrifactoryCore.registry;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.AshFurnaceBlock;
import io.thedogofchaos.GregicAgrifactoryCore.block.AshFurnaceBlockEntity;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityRegistry {
    protected static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, GregicAgrifactoryCore.MOD_ID);

    /**
     * @!!! — The Ash Furnace is currently VERY broken.
     */
    public static final RegistryObject<BlockEntityType<AshFurnaceBlockEntity>> ASH_FURNACE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("ash_furnace_be", () -> BlockEntityType.Builder.of(AshFurnaceBlockEntity::new, BlockRegistry.ASH_FURNACE.get()).build(null));
}
