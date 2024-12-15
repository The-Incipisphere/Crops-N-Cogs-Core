package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import com.tterrag.registrate.Registrate;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.MOD_ID;
import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.REGISTRATE;

@SuppressWarnings("Convert2MethodRef")
public class ModCreativeModeTabs {
    public static RegistryEntry<CreativeModeTab> PLANT_SEEDS = REGISTRATE.defaultCreativeTab("plant_seeds",
            builder -> builder
                    .title(Component.translatable("creative_tab."+MOD_ID+".plant_seeds"))
                    .build())
            .register();

    public static RegistryEntry<CreativeModeTab> PLANT_BLOCKS = REGISTRATE.defaultCreativeTab("plant_blocks",
                    builder -> builder
                            .title(Component.translatable("creative_tab."+MOD_ID+".plant_blocks"))
                            .build())
            .register();

}
