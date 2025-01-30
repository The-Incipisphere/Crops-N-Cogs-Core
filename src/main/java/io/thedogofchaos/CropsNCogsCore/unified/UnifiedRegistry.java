package io.thedogofchaos.CropsNCogsCore.unified;

import io.thedogofchaos.CropsNCogsCore.unified.data.ModBlocks;
import io.thedogofchaos.CropsNCogsCore.unified.data.ModCreativeTabs;
import io.thedogofchaos.CropsNCogsCore.unified.data.ModItems;
import io.thedogofchaos.CropsNCogsCore.unified.data.ModPlants;
import io.thedogofchaos.CropsNCogsCore.unified.registry.CropRegistry;
import net.minecraftforge.eventbus.api.IEventBus;

public class UnifiedRegistry {


    public static void init(IEventBus modBus) {
        CropRegistry cropRegistry = CropRegistry.getInstance();

        ModCreativeTabs.init(modBus);
        cropRegistry.setCropRegistryIsFrozen(false); // allow crop registration past this point
        ModPlants.init();
        cropRegistry.generateCrops();
        ModBlocks.init();
        ModItems.init();
        cropRegistry.setCropRegistryIsFrozen(true); // disallow crop registration past this point

        // Add other registries here as required.
    }
}
