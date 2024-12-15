package io.thedogofchaos.GregicAgrifactoryCore.unified;

import io.thedogofchaos.GregicAgrifactoryCore.registry.Registries;
import io.thedogofchaos.GregicAgrifactoryCore.unified.data.*;
import io.thedogofchaos.GregicAgrifactoryCore.unified.network.Network;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class UnifiedProxy {
    @SuppressWarnings("deprecation")
    public UnifiedProxy(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.register(this);
        //Registries.init();
    }

    public static void init(){
        Network.init();
        initPlants();
        ModBlocks.init();
        ModItems.init();
    }

    public static void initPlants(){

    }


    @SubscribeEvent
    public void modConstruct(FMLConstructModEvent event) {
        // this is done to delay initialization of content to be after KJS has set up.
        event.enqueueWork(UnifiedProxy::init);
    }

    @SubscribeEvent
    public void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
    }
}

