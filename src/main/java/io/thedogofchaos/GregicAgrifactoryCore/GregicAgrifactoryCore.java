package io.thedogofchaos.GregicAgrifactoryCore;

import com.tterrag.registrate.Registrate;
import io.thedogofchaos.GregicAgrifactoryCore.datagen.DataGen;
import io.thedogofchaos.GregicAgrifactoryCore.client.gui.screen.AshFurnaceScreen;
import io.thedogofchaos.GregicAgrifactoryCore.registry.MenuRegistry;
import io.thedogofchaos.GregicAgrifactoryCore.registry.Registry;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
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
    public static final Registrate REGISTRATE = Registrate.create(MOD_ID);
    public IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

    public GregicAgrifactoryCore() {
        Registry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(DataGen::generate);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("Initialising commonSetup");

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Initialising clientSetup");
        LOGGER.info("Hey, we're on Minecraft version {}!", Minecraft.getInstance().getLaunchedVersion());

        event.enqueueWork(() -> {
            MenuScreens.register(MenuRegistry.ASH_FURNACE_CONTAINER.get(), AshFurnaceScreen::new);
        });
    }

}