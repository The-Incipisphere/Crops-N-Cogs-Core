package io.thedogofchaos.GregicAgrifactoryCore.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;

public class GACBlockModelProvider extends BlockModelProvider {
    public GACBlockModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper) {
        super(output, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {}

    public BlockModelBuilder flowerCropCross(String name, ResourceLocation flower, ResourceLocation pistil, ResourceLocation stem) {
        return withExistingParent(name, new ResourceLocation("gregicagrifactory", "models/block/plant_assets/flower_crop_cross"))
                .texture("flower", flower)
                .texture("pistil", pistil)
                .texture("stem", stem);
    }
}
