package io.thedogofchaos.GregicAgrifactoryCore.datagen;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.registry.CropRegistry;
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
        simpleItem(CropRegistry.IRON_ORE_SEEDS, "seeds/");
    }

    /**
     * Creates an item model.
     *
     * @param item The {@link RegistryObject} containing the {@link Item} to generate a model for.
     * @param path A {@link String} representing the path (after namespace/textures/item/) to the item texture's location
     * @return the created model object
     * @since 1.0.0
     */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String path) {
        return withExistingParent(
            item.getId().getPath(),
            new ResourceLocation("item/generated") // The item model will be generated here.
        ).texture("layer0",
            // The location of the texture that the item model file will point to.
            new ResourceLocation(GregicAgrifactoryCore.MOD_ID,"item/" + path + item.getId().getPath())
        );
    }
}
