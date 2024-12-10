package io.thedogofchaos.GregicAgrifactoryCore.block;

import io.thedogofchaos.GregicAgrifactoryCore.organic.plant.plants.Vine;
import net.minecraft.world.level.block.VineBlock;

/**Colossally big maybe.*/
public class OreVine extends VineBlock {
    private final Vine vine;
    public OreVine(Properties properties, Vine vine) {
        super(properties);
        this.vine = vine;
    }

}
