package io.thedogofchaos.CropsNCogsCore.datagen.generators;

import io.thedogofchaos.CropsNCogsCore.CropsNCogsCore;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

/**
 * Shouldn't need this class any more.
 *
 * @deprecated as of 7th January 2025. Try and use Registrate’s built-in datagen where possible.
 */
@Deprecated
public class LanguageJsonGenerator extends LanguageProvider {
    public LanguageJsonGenerator(PackOutput packOutput, String locale) {
        super(packOutput, CropsNCogsCore.MOD_ID, locale);
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
