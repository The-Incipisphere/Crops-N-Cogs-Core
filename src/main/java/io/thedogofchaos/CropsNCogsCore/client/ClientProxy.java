package io.thedogofchaos.CropsNCogsCore.client;

import io.thedogofchaos.CropsNCogsCore.unified.UnifiedProxy;

import static io.thedogofchaos.CropsNCogsCore.CropsNCogsCore.MOD_ID;

/**
 * Explicitly Client-side stuff gets executed through here (like rendering & stuff)
 */
public class ClientProxy extends UnifiedProxy {
    public ClientProxy() {
        super();
        init();
        initLang();
    }

    public static void initLang() { // Because Registrate completely takes over datagen.
        REGISTRATE.addRawLang("config.jade.plugin_" + MOD_ID + ".crop_invalid_biome", "Show crop biome restriction tooltip");
        REGISTRATE.addRawLang("tooltip." + MOD_ID + ".invalid_biome", "Can't grow in this biome!");
    }

    private void init() {

    }
}
