package io.thedogofchaos.GregicAgrifactoryCore.item;

import io.thedogofchaos.GregicAgrifactoryCore.block.ICropProvider;
import io.thedogofchaos.GregicAgrifactoryCore.organic.Crop;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

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

    @OnlyIn(Dist.CLIENT)
    public static ItemColor tintColor() {
        return (itemStack, index) -> {
            if(itemStack.getItem() instanceof OreHarvestedItem oreHarvestedItem){
                return oreHarvestedItem.crop.getLayerARGB(index);
            }
            return -1;
        };
    }
}
