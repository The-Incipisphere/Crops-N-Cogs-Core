package io.thedogofchaos.GregicAgrifactoryCore.datagen.generators;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
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

    private void blockTranslations() {

    }

    private void itemTranslations() {

    }


    private void mobTranslations() {

    }

    private void miscTranslations() {

    }
}
