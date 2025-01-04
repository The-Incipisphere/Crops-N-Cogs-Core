package io.thedogofchaos.GregicAgrifactoryCore.unified;

import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import io.thedogofchaos.GregicAgrifactoryCore.GACConfig;
import io.thedogofchaos.GregicAgrifactoryCore.unified.network.Network;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("deprecated")
public class UnifiedProxy {
    public FMLJavaModLoadingContext modLoadingContext = FMLJavaModLoadingContext.get();
    public IEventBus modBus = modLoadingContext.getModEventBus();
    public static GACConfig config;

    public UnifiedProxy() {
        config = Configuration.registerConfig(GACConfig.class, ConfigFormats.yaml()).getConfigInstance();
        init(modBus);

        modBus.register(this);
    }

    public static void init(IEventBus modBus) {
        Network.init();
        UnifiedRegistry.init(modBus);
    }

    @SubscribeEvent
    public void modConstruct(FMLConstructModEvent event) {
        // bingus
    }
}

