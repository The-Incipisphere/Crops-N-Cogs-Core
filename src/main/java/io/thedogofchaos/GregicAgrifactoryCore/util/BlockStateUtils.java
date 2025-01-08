package io.thedogofchaos.GregicAgrifactoryCore.util;

import com.tterrag.registrate.providers.RegistrateBlockstateProvider;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;

public class BlockStateUtils {

    /*TODO: figure out blockStates here
     * must point to the model gregicagrifactory/models/block/plant_assets/flower_crop_cross
     * must point to the relevant textures within gregicagrifactory/textures/block/plant_assets/crop/<cropHeight>/<textureSet>/<cropAge>/
     * where cropHeight is the height of the given crop,
     * textureSet is the assigned texture set of the crop,
     * and cropAge is the textures for each crop age.
     * -
     * UPDATE: SMOKE TEST TIME!
     */

    public static void flowerCropCross(VariantBlockStateBuilder variantBuilder, RegistrateBlockstateProvider provider, Crop crop, CropBlock cropBlock) {
        variantBuilder.forAllStates(state -> cropStates(state, provider, crop, cropBlock));
    }

    private static ConfiguredModel[] cropStates(BlockState state, RegistrateBlockstateProvider provider, Crop crop, CropBlock cropBlock) {
        String textureSetName = crop.getCropInfo().getTextures().getTextureSetName();
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(
                provider.models().withExistingParent(crop.getCropName().concat(state.getValue(((OreCropBlock) cropBlock).getAgeProperty()).toString()), new ResourceLocation(GregicAgrifactoryCore.MOD_ID, "block/plant_assets/flower_crop_cross"))
                        .texture("flower", String.format("block/plant_assets/crop/1_tall/%s/age%d/flower", textureSetName, state.getValue(((OreCropBlock) cropBlock).getAgeProperty())))
                        .texture("pistil", String.format("block/plant_assets/crop/1_tall/%s/age%d/pistil", textureSetName, state.getValue(((OreCropBlock) cropBlock).getAgeProperty())))
                        .texture("stem", String.format("block/plant_assets/crop/1_tall/%s/age%d/stem", textureSetName, state.getValue(((OreCropBlock) cropBlock).getAgeProperty())))
        );
        return models;
    }
}
