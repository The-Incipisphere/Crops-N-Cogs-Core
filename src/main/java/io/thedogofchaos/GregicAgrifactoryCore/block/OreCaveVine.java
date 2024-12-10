package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.plants.CaveVine;
import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.CaveVinesPlantBlock;

public class OreCaveVine extends CaveVinesBlock {
    private final CaveVine caveVine;

    public OreCaveVine(Properties properties, CaveVine caveVine) {
        super(properties);
        this.caveVine = caveVine;
    }

    public class OreCaveVineGrowable extends CaveVinesPlantBlock {
        public OreCaveVineGrowable(Properties arg) {
            super(arg);
        }
    }
}
