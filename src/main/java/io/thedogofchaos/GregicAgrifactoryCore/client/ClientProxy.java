package io.thedogofchaos.GregicAgrifactoryCore.client;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
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

    private void init() {

    }

    public static void initLang() { // Because Registrate completely takes over datagen.
        REGISTRATE.addRawLang("config.jade.plugin_"+MOD_ID+".crop", "jade throws an exception if it cant find the translation key for this config thing (relating to crops), I mean DANG, WHY DO YOU NEED THIS KEY SO BAD");
        REGISTRATE.addRawLang("tooltip."+MOD_ID+".invalid_biome","Can't grow in this biome!");
    }
}
