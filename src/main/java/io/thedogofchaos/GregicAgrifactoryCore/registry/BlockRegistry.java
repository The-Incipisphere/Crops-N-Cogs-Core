package io.thedogofchaos.GregicAgrifactoryCore.registry;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.AshFurnaceBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {
    protected static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GregicAgrifactoryCore.MOD_ID);

    /**
     * @!!! — The Ash Furnace is currently VERY broken.
     */
    public static final RegistryObject<Block> ASH_FURNACE = registerBlock("furnace", AshFurnaceBlock::new);

    /**
     * An overloaded method to register a block (and automatically, a {@link BlockItem} at the same time).
     * @param name A {@link String} with the name of the block to register.
     * @param block A {@link Supplier} with the block to register.
     * @return {@code registerBlock(name, block, true)}
     * @since 0.0.1
     * @param <T> The type of the {@link Supplier}.
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, true);
    }

    /**
     * An overloaded method to register a block (and OPTIONALLY, a {@link BlockItem} at the same time).
     * @param name A {@link String} with the name of the block to register.
     * @param block A {@link Supplier} with the block to register.
     * @param alsoRegisterBlockItem If true, also register a {@link BlockItem}.
     * @return The {@code registeredBlock}.
     * @since 0.0.1
     * @param <T> The type of the {@link Supplier}.
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean alsoRegisterBlockItem) {
        RegistryObject<T> registeredBlock;
        registeredBlock = BLOCKS.register(name, block);
        if (alsoRegisterBlockItem) ItemRegistry.ITEMS.register(name, () -> new BlockItem(registeredBlock.get(), new Item.Properties()));

        return registeredBlock;
    }

}
