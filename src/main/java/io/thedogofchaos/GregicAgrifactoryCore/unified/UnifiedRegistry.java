package io.thedogofchaos.GregicAgrifactoryCore.unified;

import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.PlantRegistry;
import net.minecraftforge.eventbus.api.IEventBus;

public class UnifiedRegistry {
    public static void init(IEventBus modBus) {
        PlantRegistry.getInstance().setAllowRegistration(true);
        ModBlocks.init(modBus);
        ModItems.init(modBus);
        PlantRegistry.getInstance().setAllowRegistration(false);
        // Add other registries here as required.
    }
}
