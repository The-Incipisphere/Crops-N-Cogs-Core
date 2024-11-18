package io.thedogofchaos.GregicAgrifactoryCore;

import io.thedogofchaos.GregicAgrifactoryCore.datagen.DataGen;
import io.thedogofchaos.GregicAgrifactoryCore.registry.CropRegistry;
import io.thedogofchaos.GregicAgrifactoryCore.registry.Registry;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GregicAgrifactoryCore.MOD_ID)
public class GregicAgrifactoryCore {
    public static final String MOD_ID = "gregicagrifactory";
    public static final Logger LOGGER = LogManager.getLogger();

    public GregicAgrifactoryCore() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus(); //Ignore the deprecation, it is for 1.21.1 and later.

        Registry.registerAll(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(DataGen::generate);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());
    }

}