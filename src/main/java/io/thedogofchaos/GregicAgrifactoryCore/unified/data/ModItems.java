package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreHarvestedItem;
import io.thedogofchaos.GregicAgrifactoryCore.item.OreSeedItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Item;

import java.util.Objects;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedRegistry.REGISTRATE;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModCreativeTabs.*;

public class ModItems {
    public static final RegistryEntry<OreHarvestedItem> BECQUERELLIUM_HARVESTED = REGISTRATE.item("becquerellium_harvested", properties -> new OreHarvestedItem(ModBlocks.becquerelliumCrop, properties))
            .initialProperties(Item.Properties::new)
            .color(() -> OreHarvestedItem::tintColor)
            .tab(Objects.requireNonNull(CROP_HARVESTED_TAB.getKey()))
            .register();

    public static final RegistryEntry<OreSeedItem> BECQUERELLIUM_SEEDS = REGISTRATE.item("becquerellium_seed", properties -> new OreSeedItem(ModBlocks.becquerelliumCrop, properties))
            .initialProperties(Item.Properties::new)
            .color(() -> OreSeedItem::tintColor)
            .tab(Objects.requireNonNull(CROP_SEEDS_TAB.getKey()))
            .register();

    public static final RegistryEntry<ArmorItem> ANTI_TRAMPLE_BOOTS = REGISTRATE.item("anti_trample_boots",
                    properties -> new ArmorItem(ArmorMaterials.LEATHER, ArmorItem.Type.BOOTS, properties))
            .tab(Objects.requireNonNull(MAIN_TAB.getKey()))
            .register();

    public static void init() {
        ModBlocks.becquerelliumCrop.setHarvestedItem(BECQUERELLIUM_HARVESTED);
        ModBlocks.becquerelliumCrop.setSeedItem(BECQUERELLIUM_SEEDS);
    }
}
