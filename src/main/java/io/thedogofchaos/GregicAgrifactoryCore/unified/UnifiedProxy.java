package io.thedogofchaos.GregicAgrifactoryCore.unified;

import io.thedogofchaos.GregicAgrifactoryCore.unified.data.ModCreativeTabs;
import io.thedogofchaos.GregicAgrifactoryCore.unified.network.Network;
import io.thedogofchaos.GregicAgrifactoryCore.Config;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class UnifiedProxy {
    public FMLJavaModLoadingContext modLoadingContext = FMLJavaModLoadingContext.get();
    public IEventBus modBus = modLoadingContext.getModEventBus();
    public UnifiedProxy(){
        init(modBus);
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
        modBus.register(this);
    }

    public static void init(IEventBus modBus){
        Network.init();
        UnifiedRegistry.init(modBus);
    }

    @SubscribeEvent
    public void modConstruct(FMLConstructModEvent event) {
        // bingus
    }
}

