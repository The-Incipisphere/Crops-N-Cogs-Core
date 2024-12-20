package io.thedogofchaos.GregicAgrifactoryCore.unified;

import io.thedogofchaos.GregicAgrifactoryCore.event.FarmlandTrampleEvent;
import io.thedogofchaos.GregicAgrifactoryCore.unified.network.Network;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.IEventListener;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class UnifiedProxy {
    IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();
    public UnifiedProxy(){
        init(modBus);
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

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            // do shit here
        });
    }
}

