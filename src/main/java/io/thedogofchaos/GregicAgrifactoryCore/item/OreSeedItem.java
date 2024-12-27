package io.thedogofchaos.GregicAgrifactoryCore.item;

import io.thedogofchaos.GregicAgrifactoryCore.block.ICropProvider;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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

    @OnlyIn(Dist.CLIENT)
    public static ItemColor tintColor() {
        return (itemStack, index) -> {
            if(itemStack.getItem() instanceof OreSeedItem oreSeedItem){
                return oreSeedItem.crop.getLayerARGB(index);
            }
            return -1;
        };
    }

    public static void onRegister(BlockItem blockItem) {}
}
