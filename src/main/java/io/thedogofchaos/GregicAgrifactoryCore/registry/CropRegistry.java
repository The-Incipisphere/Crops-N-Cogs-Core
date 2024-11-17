package io.thedogofchaos.GregicAgrifactoryCore.registry;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.IronOreCrop;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class CropRegistry {
    // All the normal blocks and items go to the following two registers.
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GregicAgrifactoryCore.MOD_ID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GregicAgrifactoryCore.MOD_ID);

    // These two registers are only for Crops, their seeds, their harvested items, and their essences.
    private static final DeferredRegister<Block> CROP_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GregicAgrifactoryCore.MOD_ID);
    private static final DeferredRegister<Item> CROP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GregicAgrifactoryCore.MOD_ID);

    // Let's Define.
    public static final RegistryObject<Block> IRON_ORE_CROP = registerBlock("iron_ore_crop",
            () -> new IronOreCrop(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()), true);
    public static final RegistryObject<Item > IRON_ORE_SEEDS = CROP_ITEMS.register("iron_ore_seeds",
            () -> new ItemNameBlockItem(IRON_ORE_CROP.get(), new Item.Properties()));


    // Helper Methods, with a side of overloading
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        return registerBlock(name, block, true, false);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean isCrop) {
        return registerBlock(name, block, false, isCrop);
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, boolean alsoRegisterBlockItem, boolean isCrop) {
        RegistryObject<T> registeredBlock;
        if (isCrop) { // CropBlocks do not have a BlockItem, and also should not be registered by BLOCKS.
            registeredBlock = CROP_BLOCKS.register(name, block);
        }else{
            registeredBlock = BLOCKS.register(name, block);
            if (alsoRegisterBlockItem) registerBlockItem(name, registeredBlock);
        }
        return registeredBlock;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    // Gotta register them all!
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CROP_BLOCKS.register(eventBus);
        CROP_ITEMS.register(eventBus);
    }
}
