package io.thedogofchaos.GregicAgrifactoryCore.block;

import net.minecraft.world.level.block.CaveVinesBlock;
import net.minecraft.world.level.block.CaveVinesPlantBlock;

public class OreCaveVine extends CaveVinesBlock {

    public OreCaveVine(Properties properties) {
        super(properties);
    }

    public class OreCaveVineGrowable extends CaveVinesPlantBlock {
        public OreCaveVineGrowable(Properties arg) {
            super(arg);
        }
    }
}
