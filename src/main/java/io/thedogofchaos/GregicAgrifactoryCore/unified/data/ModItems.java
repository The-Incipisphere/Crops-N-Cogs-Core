package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GregicAgrifactoryCore.MOD_ID);

    public static final RegistryObject<Item> MAGNETITE_SEEDS = ITEMS.register("magnetite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MAGNETITE_CROP.get(), new Item.Properties()));
    public static void init(IEventBus modBus){
        ITEMS.register(modBus);
    }
}
