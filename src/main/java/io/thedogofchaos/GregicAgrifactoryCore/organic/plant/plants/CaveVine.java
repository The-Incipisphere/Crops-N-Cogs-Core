package io.thedogofchaos.GregicAgrifactoryCore.organic.plant.plants;

import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.Plant;
import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.PlantTextures;
import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.PlantType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.level.block.BushBlock;

import java.util.Set;
import java.util.function.Supplier;

public class CaveVine extends Plant {

    public CaveVine(Component displayName, PlantType plantType, PlantTextures plantTextures, Supplier<? extends BushBlock> plant, Supplier<? extends Item> essence, Supplier<? extends ItemNameBlockItem> seeds, Set<ResourceLocation> requiredBiomes) {
        super(displayName, plantType, plantTextures, plant, essence, seeds, requiredBiomes);
    }
}
