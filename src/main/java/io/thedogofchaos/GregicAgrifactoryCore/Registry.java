package io.thedogofchaos.GregicAgrifactoryCore;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Registry {
    // All the normal blocks and items go to the following two registers.
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GregicAgrifactoryCore.MODID);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GregicAgrifactoryCore.MODID);

    // These two registers are only for Crops, their seeds, their harvested items, and their essences.
    private static final DeferredRegister<Block> CROP_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GregicAgrifactoryCore.MODID);
    private static final DeferredRegister<Item> CROP_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GregicAgrifactoryCore.MODID);

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
        CROP_BLOCKS.register(eventBus);
        CROP_ITEMS.register(eventBus);
    }
}
