package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import static io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedRegistry.REGISTRATE;

public class ModCreativeTabs {
    public static void init(CropRegistry cropRegistry) {
        RegistryEntry<CreativeModeTab> CROP_HARVESTED = REGISTRATE.defaultCreativeTab("crop_harvested",
                        builder -> builder.icon(() -> new ItemStack((ItemLike) cropRegistry.getHarvestedItems(false).get("gold_harvested")))
                                .build())
                .register();
    }

    private static class DisplayItemsGenerator implements CreativeModeTab.DisplayItemsGenerator {
        @Override
        public void accept(CreativeModeTab.ItemDisplayParameters arg, CreativeModeTab.Output arg2) {
        }
    }
}
