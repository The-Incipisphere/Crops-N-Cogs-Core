package io.thedogofchaos.GregicAgrifactoryCore;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(GregicAgrifactoryCore.MODID)
public class GregicAgrifactoryCore {

    public static final String MODID = "gregicagrifactory";
    private static final Logger LOGGER = LogUtils.getLogger();

    public GregicAgrifactoryCore() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Registry.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);
        //modEventBus.addListener(this::addMaterialRegistries);
        //modEventBus.addListener(this::addMaterials);
        //modEventBus.addListener(this::modifyMaterials);

        MinecraftForge.EVENT_BUS.register(this);
    }

    //private void addMaterialRegistries(MaterialRegistryEvent event) {
    //    GTCEuAPI.materialManager.createRegistry(WorldshaperCore.MOD_ID);
    //}

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Common Setup
    }

    private void clientSetup(FMLClientSetupEvent event) {
        // LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
    }
}
