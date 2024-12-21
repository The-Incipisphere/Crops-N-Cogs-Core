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

    private void blockTranslations() {
        // Vanilla Materials
        add(ModBlocks.GOLD_CROP.get(), "Gold Crop");
        add(ModBlocks.COAL_CROP.get(), "Coal Crop");
        add(ModBlocks.REDSTONE_CROP.get(), "Redstone Crop");
        add(ModBlocks.DIAMOND_CROP.get(), "Diamond Crop");
        add(ModBlocks.EMERALD_CROP.get(), "Emerald Crop");
        add(ModBlocks.AMETHYST_CROP.get(), "Amethyst Crop");
        add(ModBlocks.NETHER_QUARTZ_CROP.get(), "Nether Quartz Crop");
        // GT Materials
        // Metals
        add(ModBlocks.MAGNETITE_CROP.get(), "Magnetite Crop");
        add(ModBlocks.CHALCOPYRITE_CROP.get(), "Chalcopyrite Crop");
        add(ModBlocks.CASSITERITE_CROP.get(), "Cassiterite Crop");
        add(ModBlocks.NICKEL_CROP.get(), "Nickel Crop");
        add(ModBlocks.SILVER_CROP.get(), "Silver Crop");
        add(ModBlocks.COBALT_CROP.get(), "Cobalt Crop");
        add(ModBlocks.LEAD_CROP.get(), "Lead Crop");
        add(ModBlocks.SPHALERITE_CROP.get(), "Sphalerite Crop");
        // Gems
        add(ModBlocks.RUBY_CROP.get(), "Ruby Crop");
        add(ModBlocks.SAPPHIRE_CROP.get(), "Sapphire Crop");
        add(ModBlocks.GREEN_SAPPHIRE_CROP.get(), "Green Sapphire Crop");
        add(ModBlocks.TOPAZ_CROP.get(), "Topaz Crop");
        add(ModBlocks.APATITE_CROP.get(), "Apatite Crop");
        add(ModBlocks.OPAL_CROP.get(), "Opal Crop");
        add(ModBlocks.CINNABAR_CROP.get(), "Cinnabar Crop");
        add(ModBlocks.REALGAR_CROP.get(), "Realgar Crop");
        add(ModBlocks.CERTUS_QUARTZ_CROP.get(), "Certus Quartz Crop");
        add(ModBlocks.QUARTZITE_CROP.get(), "Quartzite Crop");
        add(ModBlocks.SALT_CROP.get(), "Salt Crop");
        // Misc
        add(ModBlocks.SALTPETRE_CROP.get(), "Saltpetre Crop");
        add(ModBlocks.SULPHUR_CROP.get(), "Sulphur Crop");
    }

    private void itemTranslations() {
        /*/////////////////////*/
        /*/ ***** SEEDS ***** /*/
        /*/////////////////////*/

        // Vanilla Materials
        add(ModItems.GOLD_SEEDS.get(), "Gold Seed");
        add(ModItems.COAL_SEEDS.get(), "Coal Seed");
        add(ModItems.REDSTONE_SEEDS.get(), "Redstone Seed");
        add(ModItems.DIAMOND_SEEDS.get(), "Diamond Seed");
        add(ModItems.EMERALD_SEEDS.get(), "Emerald Seed");
        add(ModItems.AMETHYST_SEEDS.get(), "Amethyst Seed");
        add(ModItems.NETHER_QUARTZ_SEEDS.get(), "Nether Quartz Seed");
        // GT Materials
        add(ModItems.MAGNETITE_SEEDS.get(), "Magnetite Seed");
        add(ModItems.CHALCOPYRITE_SEEDS.get(), "Chalcopyrite Seed");
        add(ModItems.CASSITERITE_SEEDS.get(), "Cassiterite Seed");
        add(ModItems.NICKEL_SEEDS.get(), "Nickel Seed");
        add(ModItems.SILVER_SEEDS.get(), "Silver Seed");
        add(ModItems.COBALT_SEEDS.get(), "Cobalt Seed");
        add(ModItems.LEAD_SEEDS.get(), "Lead Seed");
        add(ModItems.SPHALERITE_SEEDS.get(), "Sphalerite Seed");
        // Gems
        add(ModItems.RUBY_SEEDS.get(), "Ruby Seed");
        add(ModItems.SAPPHIRE_SEEDS.get(), "Sapphire Seed");
        add(ModItems.GREEN_SAPPHIRE_SEEDS.get(), "Green Sapphire Seed");
        add(ModItems.TOPAZ_SEEDS.get(), "Topaz Seed");
        add(ModItems.APATITE_SEEDS.get(), "Apatite Seed");
        add(ModItems.OPAL_SEEDS.get(), "Opal Seed");
        add(ModItems.CINNABAR_SEEDS.get(), "Cinnabar Seed");
        add(ModItems.REALGAR_SEEDS.get(), "Realgar Seed");
        add(ModItems.CERTUS_QUARTZ_SEEDS.get(), "Certus Quartz Seed");
        add(ModItems.QUARTZITE_SEEDS.get(), "Quartzite Seed");
        add(ModItems.SALT_SEEDS.get(), "Salt Seed");
        // Misc
        add(ModItems.SALTPETRE_SEEDS.get(), "Saltpetre Seed");
        add(ModItems.SULPHUR_SEEDS.get(), "Sulphur Seed");

        /*///////////////////////////////*/
        /*/ ***** HARVESTED CROPS ***** /*/
        /*///////////////////////////////*/

        // Vanilla Materials
        add(ModItems.GOLD_HARVESTED.get(), "Gold Flower");
        add(ModItems.COAL_HARVESTED.get(), "Coal Flower");
        add(ModItems.REDSTONE_HARVESTED.get(), "Redstone Flower");
        add(ModItems.DIAMOND_HARVESTED.get(), "Diamond Flower");
        add(ModItems.EMERALD_HARVESTED.get(), "Emerald Flower");
        add(ModItems.AMETHYST_HARVESTED.get(), "Amethyst Flower");
        add(ModItems.NETHER_QUARTZ_HARVESTED.get(), "Nether Quartz Flower");
        // GT Materials
        // Metals
        add(ModItems.MAGNETITE_HARVESTED.get(), "Magnetite Flower");
        add(ModItems.CHALCOPYRITE_HARVESTED.get(), "Chalcopyrite Flower");
        add(ModItems.CASSITERITE_HARVESTED.get(), "Cassiterite Flower");
        add(ModItems.NICKEL_HARVESTED.get(), "Nickel Flower");
        add(ModItems.SILVER_HARVESTED.get(), "Silver Flower");
        add(ModItems.COBALT_HARVESTED.get(), "Cobalt Flower");
        add(ModItems.LEAD_HARVESTED.get(), "Lead Flower");
        add(ModItems.SPHALERITE_HARVESTED.get(), "Sphalerite Flower");
        // Gems
        add(ModItems.RUBY_HARVESTED.get(), "Ruby Flower");
        add(ModItems.SAPPHIRE_HARVESTED.get(), "Sapphire Flower");
        add(ModItems.GREEN_SAPPHIRE_HARVESTED.get(), "Green Sapphire Flower");
        add(ModItems.TOPAZ_HARVESTED.get(), "Topaz Flower");
        add(ModItems.APATITE_HARVESTED.get(), "Apatite Flower");
        add(ModItems.OPAL_HARVESTED.get(), "Opal Flower");
        add(ModItems.CINNABAR_HARVESTED.get(), "Cinnabar Flower");
        add(ModItems.REALGAR_HARVESTED.get(), "Realgar Flower");
        add(ModItems.CERTUS_QUARTZ_HARVESTED.get(), "Certus Quartz Flower");
        add(ModItems.QUARTZITE_HARVESTED.get(), "Quartzite Flower");
        add(ModItems.SALT_HARVESTED.get(), "Salt Flower");
        // <osc
        add(ModItems.SALTPETRE_HARVESTED.get(), "Saltpetre Flower");
        add(ModItems.SULPHUR_HARVESTED.get(), "Sulphur Flower");
    }


    private void mobTranslations() {

    }

    private void miscTranslations() {

    }
}
