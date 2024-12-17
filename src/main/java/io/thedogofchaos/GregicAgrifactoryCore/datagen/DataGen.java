package io.thedogofchaos.GregicAgrifactoryCore.datagen;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.datagen.generators.*;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = GregicAgrifactoryCore.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGen {
    @SubscribeEvent
    public static void generate(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new BlockStateJsonGenerator(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ItemModelJsonGenerator(packOutput, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LanguageJsonGenerator(packOutput, "en_us"));

        BlockTagsJsonGenerator blockTags = new BlockTagsJsonGenerator(packOutput, lookupProvider, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTags);
        generator.addProvider(event.includeServer(), new ItemTagJsonGenerator(packOutput, lookupProvider, blockTags, event.getExistingFileHelper()));
        generator.addProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(LootTableJsonGenerator::new, LootContextParamSets.BLOCK))));
    }
}