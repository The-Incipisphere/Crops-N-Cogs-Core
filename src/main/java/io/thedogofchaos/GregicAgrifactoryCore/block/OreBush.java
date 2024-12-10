package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.plants.Bush;
import net.minecraft.world.level.block.BushBlock;

public class OreBush extends BushBlock {
    private final Bush bush;

    public OreBush(Properties properties, Bush bush) {
        super(properties);
        this.bush = bush;
    }
}
