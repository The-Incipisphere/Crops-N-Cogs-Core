package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModelJsonGenerator extends ItemModelProvider {
    // Note to self: This will need to be built to handle ItemModel generation of seeds/harvestedItems/rawEssences at runtime.
    public ItemModelJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(ModItems.MAGNETITE_SEEDS.getId().getPath(), modLoc("item/crops/seeds/"));
        withExistingParent(ModItems.MAGNETITE_HARVESTED.getId().getPath(), modLoc("item/crops/harvested/"));
    }
}
