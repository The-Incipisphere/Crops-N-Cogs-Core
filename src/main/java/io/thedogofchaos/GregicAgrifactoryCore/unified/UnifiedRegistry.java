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

        cropRegistry.setAllowRegistration(true); // allow crop registration past this point
        ModPlants.init();
        cropRegistry.generateCrops();

        ModBlocks.init();
        ModItems.init();
        cropRegistry.setAllowRegistration(false); // disallow crop registration past this point
        ModCreativeTabs.init();
        // Add other registries here as required.
    }
}
