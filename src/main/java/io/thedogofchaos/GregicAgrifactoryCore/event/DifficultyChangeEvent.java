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
        GregicAgrifactoryCore.LOGGER.info("difficultyChangeEvent has been fired, newdiff={} olddiff={}", event.getDifficulty(), event.getOldDifficulty());
        if (Config.disablePeaceful && event.getDifficulty() == Difficulty.PEACEFUL) {
            GregicAgrifactoryCore.LOGGER.warn("Tried to set difficulty to peaceful from {}, but peaceful mode is disabled!", event.getOldDifficulty());
            event.setCanceled(true);
        }
    }
}
