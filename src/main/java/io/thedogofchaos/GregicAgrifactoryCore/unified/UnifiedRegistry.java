package io.thedogofchaos.GregicAgrifactoryCore.unified;

import com.tterrag.registrate.Registrate;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModCreativeTabs;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraftforge.eventbus.api.IEventBus;

public class UnifiedRegistry {
    public static final Registrate REGISTRATE = Registrate.create(GregicAgrifactoryCore.MOD_ID);
    public static void init(IEventBus modBus) {
        CropRegistry cropRegistry = CropRegistry.getInstance();

        cropRegistry.setAllowRegistration(true);
        ModPlants.init();
        cropRegistry.generateCrops();
        ModCreativeTabs.init(cropRegistry);
        ModBlocks.init(modBus);
        ModItems.init(modBus);
        cropRegistry.setAllowRegistration(false);
        // Add other registries here as required.
    }
}
