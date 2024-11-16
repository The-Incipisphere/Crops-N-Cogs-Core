package io.thedogofchaos.GregicAgrifactoryCore.datagen;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.registry.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ItemModelJsonGenerator extends ItemModelProvider {

    public ItemModelJsonGenerator(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GregicAgrifactoryCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(Registry.IRON_ORE_SEEDS);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(GregicAgrifactoryCore.MOD_ID,"item/" + item.getId().getPath()));
    }
}
