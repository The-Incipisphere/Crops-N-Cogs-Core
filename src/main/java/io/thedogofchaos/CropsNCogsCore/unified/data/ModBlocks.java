package io.thedogofchaos.CropsNCogsCore.unified.data;

import com.tterrag.registrate.util.entry.RegistryEntry;
import io.thedogofchaos.CropsNCogsCore.block.OreCropBlock;
import io.thedogofchaos.CropsNCogsCore.organic.Crop;
import io.thedogofchaos.CropsNCogsCore.unified.registry.CropRegistry;


public class ModBlocks {
    public static final Crop becquerelliumCrop = ModPlants.Becquerellium; // shitty hack because of my own code.

    public static final RegistryEntry<OreCropBlock> BECQUERELLIUM_CROP = CropRegistry.makeCropBlock(becquerelliumCrop);

    public static void init() {
        becquerelliumCrop.setCropBlock(BECQUERELLIUM_CROP);
    }

}
