package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import io.thedogofchaos.GregicAgrifactoryCore.organic.Plant;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.plants.CommonOrePlants;

public class ModPlants {
    public static Plant Magnetite;

    public static void init(){
        CommonOrePlants.register();
    }
}
