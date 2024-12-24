package io.thedogofchaos.GregicAgrifactoryCore.unified;

import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModPlants;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraftforge.eventbus.api.IEventBus;

public class UnifiedRegistry {
    public static void init(IEventBus modBus) {
        CropRegistry.getInstance().setAllowRegistration(true);
        ModPlants.init();
        ModBlocks.init(modBus);
        ModItems.init(modBus);
        CropRegistry.getInstance().setAllowRegistration(false);
        // Add other registries here as required.
    }
}
