package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.tterrag.registrate.util.entry.ItemEntry;
import com.tterrag.registrate.util.entry.RegistryEntry;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;

import io.thedogofchaos.GregicAgrifactoryCore.item.OreHarvestedItem;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreSeedItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedRegistry.REGISTRATE;

public class ModItems {

    public static final RegistryEntry<OreHarvestedItem> BECQUERELLIUM_HARVESTED = REGISTRATE.item("becquerellium_harvested", properties -> new OreHarvestedItem(ModPlants.Becquerellium, properties))
            .initialProperties(Item.Properties::new)
            .color(() -> OreHarvestedItem::tintColor)
            .register();

    public static final RegistryEntry<OreSeedItem> BECQUERELLIUM_SEEDS = REGISTRATE.item("becquerellium_seed", properties -> new OreSeedItem(ModPlants.Becquerellium, properties))
            .initialProperties(Item.Properties::new)
            .color(() -> OreSeedItem::tintColor)
            .register();

    public static final RegistryEntry<ArmorItem> ANTI_TRAMPLE_BOOTS = REGISTRATE.item("anti_trample_boots",
            properties -> new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, properties))
            .register();

    public static void init(){
    }
}
