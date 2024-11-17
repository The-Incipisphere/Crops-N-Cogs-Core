package io.thedogofchaos.GregicAgrifactoryCore.registry;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class BlockRegistry {
    protected static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GregicAgrifactoryCore.MOD_ID);

    /**
     * An overloaded method to register a block.
     * @param name A {@link String} with the name of the block to register.
     * @param block A {@link Supplier} with the block to register.
     * @return registerBlock(name, block, true)
     * @param <T> The type of the {@link Supplier}.
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, true);
    }
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean alsoRegisterBlockItem) {
        RegistryObject<T> registeredBlock;
        registeredBlock = BLOCKS.register(name, block);
        if (alsoRegisterBlockItem) registerBlockItem(name, registeredBlock);

        return registeredBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
}
