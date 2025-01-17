package io.thedogofchaos.CropsNCogsCore.datagen.generators;

import io.thedogofchaos.CropsNCogsCore.CropsNCogsCore;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * Shouldn't need this class any more.
 *
 * @deprecated as of 7th January 2025. Try and use Registrate’s built-in datagen where possible.
 */
@Deprecated
public class BlockStatesAndModelsJsonGenerator extends BlockStateProvider {

    public BlockStatesAndModelsJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, CropsNCogsCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {/**/}
}
