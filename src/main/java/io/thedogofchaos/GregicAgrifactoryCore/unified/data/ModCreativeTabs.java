package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.MOD_NAME;
import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.id;
import static io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedRegistry.REGISTRATE;

public class ModCreativeTabs {
    public static RegistryEntry<CreativeModeTab> CROP_BLOCKS_TAB;
    public static RegistryEntry<CreativeModeTab> CROP_HARVESTED_TAB;
    public static RegistryEntry<CreativeModeTab> CROP_SEEDS_TAB;

    public static void init() {
        CROP_BLOCKS_TAB = REGISTRATE.defaultCreativeTab("crop_blocks_tab",
                        builder -> builder
                                .icon(() -> new ItemStack(ModBlocks.BECQUERELLIUM_CROP.get()))
                                .title(REGISTRATE.addLang("itemGroup", id("crop_blocks_tab"), MOD_NAME + " Crop Blocks"))
                                .build())
                .register();

        CROP_HARVESTED_TAB = REGISTRATE.defaultCreativeTab("crop_harvested_items_tab",
                        builder -> builder
                                .icon(() -> new ItemStack(ModItems.BECQUERELLIUM_HARVESTED.get()))
                                .title(REGISTRATE.addLang("itemGroup", id("crop_harvested_items_tab"), MOD_NAME + " Harvested Crops"))
                                .build())
                .register();

        CROP_SEEDS_TAB = REGISTRATE.defaultCreativeTab("crop_seed_items_tab",
                        builder -> builder
                                .icon(() -> new ItemStack(ModItems.BECQUERELLIUM_SEEDS.get()))
                                .title(REGISTRATE.addLang("itemGroup", id("crop_seed_items_tab"), MOD_NAME + " Crop Seeds"))
                                .build())
                .register();
    }

}
