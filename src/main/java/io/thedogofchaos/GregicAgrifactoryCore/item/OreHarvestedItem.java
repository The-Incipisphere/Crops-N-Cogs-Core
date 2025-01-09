package io.thedogofchaos.GregicAgrifactoryCore.item;

import io.thedogofchaos.GregicAgrifactoryCore.block.ICropProvider;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.world.item.Item;

public class OreHarvestedItem extends Item implements ICropProvider {
    private final Crop crop;

    public OreHarvestedItem(Crop crop, Properties properties) {
        super(properties);
        this.crop = crop;
    }

    @Override
    public Crop getCrop() {
        return this.crop;
    }
}
