package io.thedogofchaos.GregicAgrifactoryCore.crops;

import net.minecraft.world.level.block.CropBlock;

public class OreCrop extends CropBlock implements Comparable<OreCrop> {
    private int maxAge;
    private int color;

    public OreCrop(Properties properties, Builder builder) {
        super(properties);
    }
    @Override
    public int compareTo(OreCrop oreCrop) {
        return toString().compareTo(oreCrop.toString());
    }

    public static class Builder{

        public Builder(){

        }

        public OreCrop buildAndRegister(){

            var crop = new OreCrop();
            return crop;
        }
    }
}
