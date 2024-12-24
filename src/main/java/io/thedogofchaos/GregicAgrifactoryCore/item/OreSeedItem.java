package io.thedogofchaos.GregicAgrifactoryCore.item;

import io.thedogofchaos.GregicAgrifactoryCore.block.ICropProvider;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;

public class OreSeedItem extends ItemNameBlockItem implements ICropProvider {
    private final Crop crop;

    public OreSeedItem(Crop crop) {
        super(crop.getCropBlock(), new Item.Properties());
        this.crop = crop;
    }

    @Override
    public Crop getCrop() {
        return this.crop;
    }
}
