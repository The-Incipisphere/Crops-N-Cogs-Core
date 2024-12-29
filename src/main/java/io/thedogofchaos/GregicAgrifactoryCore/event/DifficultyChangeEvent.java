package io.thedogofchaos.GregicAgrifactoryCore.event;

import io.thedogofchaos.GregicAgrifactoryCore.Config;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import net.minecraft.world.Difficulty;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DifficultyChangeEvent {
    @SubscribeEvent
    public static void difficultyChangeEvent(net.minecraftforge.event.DifficultyChangeEvent event) {
        if (Config.disablePeaceful && event.getDifficulty() == Difficulty.PEACEFUL) {
            GregicAgrifactoryCore.LOGGER.warn("Tried to set difficulty to peaceful from " + event.getOldDifficulty().toString() + ", but peaceful mode is disabled!");
            event.setCanceled(true);
        }
    }
}
