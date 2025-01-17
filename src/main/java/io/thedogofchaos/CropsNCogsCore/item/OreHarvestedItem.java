package io.thedogofchaos.CropsNCogsCore.item;

import io.thedogofchaos.CropsNCogsCore.block.ICropProvider;
import io.thedogofchaos.CropsNCogsCore.organic.Crop;
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
