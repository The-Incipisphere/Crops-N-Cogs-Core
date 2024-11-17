package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelJsonGenerator extends ItemModelProvider {
    public ItemModelJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
