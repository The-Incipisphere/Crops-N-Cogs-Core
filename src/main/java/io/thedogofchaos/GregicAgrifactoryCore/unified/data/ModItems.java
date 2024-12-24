package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.gregtechceu.gtceu.api.gui.editor.EditableUI;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;

import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.PlantRegistry;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
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

    // Vanilla Materials
    public static final RegistryObject<Item> GOLD_SEEDS = ITEMS.register("gold_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GOLD_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> COAL_SEEDS = ITEMS.register("coal_seeds",
            () -> new ItemNameBlockItem(ModBlocks.COAL_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_SEEDS = ITEMS.register("redstone_seeds",
            () -> new ItemNameBlockItem(ModBlocks.REDSTONE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_SEEDS = ITEMS.register("diamond_seeds",
            () -> new ItemNameBlockItem(ModBlocks.DIAMOND_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_SEEDS = ITEMS.register("emerald_seeds",
            () -> new ItemNameBlockItem(ModBlocks.EMERALD_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_SEEDS = ITEMS.register("amethyst_seeds",
            () -> new ItemNameBlockItem(ModBlocks.AMETHYST_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> NETHER_QUARTZ_SEEDS = ITEMS.register("nether_quartz_seeds",
            () -> new ItemNameBlockItem(ModBlocks.NETHER_QUARTZ_CROP.get(), new Item.Properties()));
    // GT Materials
    // Metals
    public static final RegistryObject<Item> MAGNETITE_SEEDS = ITEMS.register("magnetite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.MAGNETITE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHALCOPYRITE_SEEDS = ITEMS.register("chalcopyrite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CHALCOPYRITE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CASSITERITE_SEEDS = ITEMS.register("cassiterite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CASSITERITE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> NICKEL_SEEDS = ITEMS.register("nickel_seeds",
            () -> new ItemNameBlockItem(ModBlocks.NICKEL_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SILVER_SEEDS = ITEMS.register("silver_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SILVER_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> COBALT_SEEDS = ITEMS.register("cobalt_seeds",
            () -> new ItemNameBlockItem(ModBlocks.COBALT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> LEAD_SEEDS = ITEMS.register("lead_seeds",
            () -> new ItemNameBlockItem(ModBlocks.LEAD_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPHALERITE_SEEDS = ITEMS.register("sphalerite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SPHALERITE_CROP.get(), new Item.Properties()));
    // Gems
    public static final RegistryObject<Item> RUBY_SEEDS = ITEMS.register("ruby_seeds",
            () -> new ItemNameBlockItem(ModBlocks.RUBY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SEEDS = ITEMS.register("sapphire_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SAPPHIRE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAPPHIRE_SEEDS = ITEMS.register("green_sapphire_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GREEN_SAPPHIRE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ_SEEDS = ITEMS.register("topaz_seeds",
            () -> new ItemNameBlockItem(ModBlocks.TOPAZ_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> APATITE_SEEDS = ITEMS.register("apatite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.APATITE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> OPAL_SEEDS = ITEMS.register("opal_seeds",
            () -> new ItemNameBlockItem(ModBlocks.OPAL_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CINNABAR_SEEDS = ITEMS.register("cinnabar_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CINNABAR_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> REALGAR_SEEDS = ITEMS.register("realgar_seeds",
            () -> new ItemNameBlockItem(ModBlocks.REALGAR_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> CERTUS_QUARTZ_SEEDS = ITEMS.register("certus_quartz_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CERTUS_QUARTZ_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUARTZITE_SEEDS = ITEMS.register("quartzite_seeds",
            () -> new ItemNameBlockItem(ModBlocks.QUARTZITE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SALT_SEEDS = ITEMS.register("salt_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SALT_CROP.get(), new Item.Properties()));
    // Misc
    public static final RegistryObject<Item> SALTPETRE_SEEDS = ITEMS.register("saltpetre_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SALTPETRE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> SULPHUR_SEEDS = ITEMS.register("sulphur_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SULPHUR_CROP.get(), new Item.Properties()));

    /*///////////////////////////////*/
    /*/ ***** HARVESTED CROPS ***** /*/
    /*///////////////////////////////*/

    // Vanilla Materials
    public static final RegistryObject<Item> GOLD_HARVESTED = ITEMS.register("gold_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COAL_HARVESTED = ITEMS.register("coal_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_HARVESTED = ITEMS.register("redstone_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DIAMOND_HARVESTED = ITEMS.register("diamond_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_HARVESTED = ITEMS.register("emerald_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_HARVESTED = ITEMS.register("amethyst_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NETHER_QUARTZ_HARVESTED = ITEMS.register("nether_quartz_harvested",
            () -> new Item(new Item.Properties()));
    // GT Materials
    // Metals
    public static final RegistryObject<Item> MAGNETITE_HARVESTED = ITEMS.register("magnetite_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHALCOPYRITE_HARVESTED = ITEMS.register("chalcopyrite_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CASSITERITE_HARVESTED = ITEMS.register("cassiterite_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> NICKEL_HARVESTED = ITEMS.register("nickel_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SILVER_HARVESTED = ITEMS.register("silver_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COBALT_HARVESTED = ITEMS.register("cobalt_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> LEAD_HARVESTED = ITEMS.register("lead_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SPHALERITE_HARVESTED = ITEMS.register("sphalerite_harvested",
            () -> new Item(new Item.Properties()));
    // Gems
    public static final RegistryObject<Item> RUBY_HARVESTED = ITEMS.register("ruby_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HARVESTED = ITEMS.register("sapphire_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> GREEN_SAPPHIRE_HARVESTED = ITEMS.register("green_sapphire_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TOPAZ_HARVESTED = ITEMS.register("topaz_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> APATITE_HARVESTED = ITEMS.register("apatite_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> OPAL_HARVESTED = ITEMS.register("opal_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CINNABAR_HARVESTED = ITEMS.register("cinnabar_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> REALGAR_HARVESTED = ITEMS.register("realgar_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CERTUS_QUARTZ_HARVESTED = ITEMS.register("certus_quartz_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> QUARTZITE_HARVESTED = ITEMS.register("quartzite_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SALT_HARVESTED = ITEMS.register("salt_harvested",
            () -> new Item(new Item.Properties()));
    // Misc
    public static final RegistryObject<Item> SALTPETRE_HARVESTED = ITEMS.register("saltpetre_harvested",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SULPHUR_HARVESTED = ITEMS.register("sulphur_harvested",
            () -> new Item(new Item.Properties()));

    /*////////////////////*/
    /*/ ***** MISC ***** /*/
    /*////////////////////*/
    public static final RegistryObject<ArmorItem> ANTI_TRAMPLE_BOOTS = ITEMS.register("anti_trample_boots",
            () -> new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant()));

    public static void init(IEventBus modBus){
        ITEMS.register(modBus);
        PlantRegistry.getInstance().onRegisterItems(ITEMS);
    }
}
