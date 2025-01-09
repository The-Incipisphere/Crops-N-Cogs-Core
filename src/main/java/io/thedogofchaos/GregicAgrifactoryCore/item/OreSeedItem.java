package io.thedogofchaos.GregicAgrifactoryCore.item;

import io.thedogofchaos.GregicAgrifactoryCore.block.ICropProvider;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemNameBlockItem;

public class OreSeedItem extends ItemNameBlockItem implements ICropProvider {
    private final Crop crop;

    public OreSeedItem(Crop crop, Properties properties) {
        super(crop.getCropBlock(), properties);
        this.crop = crop;
    }

    public static void onRegister(BlockItem blockItem) {
    }

    @Override
    public Crop getCrop() {
        return this.crop;
    }
}
