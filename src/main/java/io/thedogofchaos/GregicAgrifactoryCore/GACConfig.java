package io.thedogofchaos.GregicAgrifactoryCore;

import dev.toma.configuration.config.Config;
import dev.toma.configuration.config.Configurable;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.config.ModConfigEvent;

import static io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore.MOD_ID;

@Config(id = MOD_ID)
public class GACConfig {
    @Configurable
    @Configurable.Comment(value = "Whether to disable Peaceful mode. Defaults to true, as this pack cannot be progressed past a certain point on Peaceful.")
    public boolean disablePeaceful = true;
}
