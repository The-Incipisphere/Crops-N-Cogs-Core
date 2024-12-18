package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModBlocks;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class LanguageJsonGenerator extends LanguageProvider {
    public LanguageJsonGenerator(PackOutput packOutput, String locale) {
        super(packOutput, GregicAgrifactoryCore.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        blockTranslations();
        itemTranslations();
        mobTranslations();
        miscTranslations();
    }

    private void blockTranslations(){
        add(ModBlocks.MAGNETITE_CROP.get(), "Magnetite Crop");
    }

    private void itemTranslations() {
        add(ModItems.MAGNETITE_SEEDS.get(), "Magnetite Seed");
        add(ModItems.MAGNETITE_HARVESTED.get(), "Magnetite Flower");
    }

    private void mobTranslations() {

    }

    private void miscTranslations() {

    }
}
