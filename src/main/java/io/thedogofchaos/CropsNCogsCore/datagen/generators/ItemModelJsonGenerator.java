package io.thedogofchaos.CropsNCogsCore.datagen.generators;

import io.thedogofchaos.CropsNCogsCore.CropsNCogsCore;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

/**
 * Shouldn't need this class any more.
 *
 * @deprecated as of 7th January 2025. Try and use Registrate’s built-in datagen where possible.
 */
@Deprecated
public class ItemModelJsonGenerator extends ItemModelProvider {
    public ItemModelJsonGenerator(PackOutput packOutput, ExistingFileHelper existingFileHelper) {
        super(packOutput, CropsNCogsCore.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    /**
     * Creates an item model.
     *
     * @param item The {@link RegistryObject} containing the {@link Item} to generate a model for.
     * @param path A {@link String} representing the path (after {@code <modNamespace>/textures/item/}) to the item texture's location
     * @return The created model object
     */
    private ItemModelBuilder simpleItem(RegistryObject<Item> item, String path) {
        return withExistingParent(
                item.getId().getPath(),
                new ResourceLocation("item/generated") // The item model will be generated here.
        ).texture("layer0",
                // The location of the texture that the item model file will point to.
                new ResourceLocation(CropsNCogsCore.MOD_ID, "item/" + path + item.getId().getPath())
        );
    }
}
