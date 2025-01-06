package io.thedogofchaos.GregicAgrifactoryCore.util;

import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import io.thedogofchaos.GregicAgrifactoryCore.organic.CropTextures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;

import java.util.function.Function;

public class BlockStateUtils {

    /*TODO: figure out blockStates here
     * must point to the model gregicagrifactory/models/block/plant_assets/flower_crop_cross
     * must point to the relevant textures within gregicagrifactory/textures/block/plant_assets/crop/<cropHeight>/<textureSet>/<cropAge>/
     * where cropHeight is the height of the given crop,
     * textureSet is the assigned texture set of the crop,
     * and cropAge is the textures for each crop age.
     */

    public static void flowerCropCross(VariantBlockStateBuilder variantBuilder, RegistrateBlockstateProvider provider, Crop crop) {
        variantBuilder.forAllStates(state -> cropStates(state, provider, crop));
    }

    private static ConfiguredModel[] cropStates(BlockState state, RegistrateBlockstateProvider provider, Crop crop) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                provider.models().withExistingParent(crop.getCropName(), new ResourceLocation(GregicAgrifactoryCore.MOD_ID, "block/plant_assets/flower_crop_cross"))
                        .texture("flower", FLOWERTEXTUREHERE)
                        .texture("pistil", PISTILTEXTUREHERE)
                        .texture("stem", STEMTEXTUREHERE)
        );
        return models;
    }
}
