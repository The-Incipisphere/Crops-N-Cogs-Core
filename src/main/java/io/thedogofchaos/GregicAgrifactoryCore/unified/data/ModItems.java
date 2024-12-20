package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.gregtechceu.gtceu.api.gui.editor.EditableUI;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GregicAgrifactoryCore.MOD_ID);

    /*/////////////////////*/
    /*/ ***** SEEDS ***** /*/
    /*/////////////////////*/
    public static final RegistryObject<Item> MAGNETITE_SEEDS = ITEMS.register("magnetite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MAGNETITE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHALCOPYRITE_SEEDS = ITEMS.register("chalcopyrite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CHALCOPYRITE_CROP.get(), new Item.Properties()));

    /*///////////////////////////////*/
    /*/ ***** HARVESTED CROPS ***** /*/
    /*///////////////////////////////*/
    public static final RegistryObject<Item> MAGNETITE_HARVESTED = ITEMS.register("magnetite_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHALCOPYRITE_HARVESTED = ITEMS.register("chalcopyrite_harvested",
            () -> new Item(new Item.Properties()));

    public static void init(IEventBus modBus){
        ITEMS.register(modBus);
    }
}
