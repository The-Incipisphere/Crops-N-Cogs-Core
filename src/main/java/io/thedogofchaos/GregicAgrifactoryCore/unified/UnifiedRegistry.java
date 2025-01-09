package io.thedogofchaos.GregicAgrifactoryCore.unified;

import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModCreativeTabs;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraftforge.eventbus.api.IEventBus;

public class UnifiedRegistry {


    public static void init(IEventBus modBus) {
        CropRegistry cropRegistry = CropRegistry.getInstance();

        ModCreativeTabs.init(modBus);
        cropRegistry.setAllowRegistration(true); // allow crop registration past this point
        ModPlants.init();
        cropRegistry.generateCrops();
        ModBlocks.init();
        ModItems.init();
        cropRegistry.setAllowRegistration(false); // disallow crop registration past this point

        // Add other registries here as required.
    }
}
