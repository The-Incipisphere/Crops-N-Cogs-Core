package io.thedogofchaos.GregicAgrifactoryCore.client;

import io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedProxy;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.MOD_ID;

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
        REGISTRATE.addRawLang("config.jade.plugin_" + MOD_ID + ".crop", "Show biome restriction tooltip (for crops)");
        REGISTRATE.addRawLang("tooltip." + MOD_ID + ".invalid_biome", "Can't grow in this biome!");
    }

    private void init() {

    }
}
