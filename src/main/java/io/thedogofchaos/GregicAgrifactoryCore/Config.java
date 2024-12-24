package io.thedogofchaos.GregicAgrifactoryCore;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue DISABLE_PEACEFUL = BUILDER
            .comment("Whether to disable Peaceful mode. Defaults to true, as this pack is not built to be played on Peaceful.")
            .define("disablePeaceful", true);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean disablePeaceful;

    @SubscribeEvent
    public static void onConfigReload(final ModConfigEvent.Reloading event) {
        if (event.getConfig().getSpec() == SPEC) {
            syncConfig();
        }
    }

    private static void syncConfig() {
        disablePeaceful = DISABLE_PEACEFUL.get();
    }
}
