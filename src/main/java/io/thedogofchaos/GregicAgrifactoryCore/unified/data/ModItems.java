package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;

import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GregicAgrifactoryCore.MOD_ID);

    // insert RegistryObject<T> here

    /*////////////////////*/
    /*/ ***** MISC ***** /*/
    /*////////////////////*/
    public static final RegistryObject<ArmorItem> ANTI_TRAMPLE_BOOTS = ITEMS.register("anti_trample_boots",
            () -> new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static void init(IEventBus modBus, CropRegistry cropRegistry){
        cropRegistry.onRegisterItems(ITEMS);
        ITEMS.register(modBus);
    }
}
