package io.thedogofchaos.GregicAgrifactoryCore.unified;

import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import net.minecraftforge.eventbus.api.IEventBus;

public class UnifiedRegistry {
    public static void init(IEventBus modBus) {
        ModBlocks.init(modBus);
        ModItems.init(modBus);
        // Add other registries here as required.
    }
}
