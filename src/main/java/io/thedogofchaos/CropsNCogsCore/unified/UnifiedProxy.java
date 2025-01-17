package io.thedogofchaos.CropsNCogsCore.unified;

import com.tterrag.registrate.Registrate;
import dev.toma.configuration.Configuration;
import dev.toma.configuration.config.format.ConfigFormats;
import io.thedogofchaos.CropsNCogsCore.CNCCConfig;
import io.thedogofchaos.CropsNCogsCore.CropsNCogsCore;
import io.thedogofchaos.CropsNCogsCore.unified.network.Network;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@SuppressWarnings("deprecated")
public class UnifiedProxy {
    public static final Registrate REGISTRATE = Registrate.create(CropsNCogsCore.MOD_ID);
    public static CNCCConfig config;
    public FMLJavaModLoadingContext modLoadingContext = FMLJavaModLoadingContext.get();
    public IEventBus modBus = modLoadingContext.getModEventBus();

    public UnifiedProxy() {
        config = Configuration.registerConfig(CNCCConfig.class, ConfigFormats.yaml()).getConfigInstance();
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

