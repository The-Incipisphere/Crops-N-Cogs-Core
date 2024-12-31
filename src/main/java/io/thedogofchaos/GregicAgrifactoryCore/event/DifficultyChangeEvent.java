package io.thedogofchaos.GregicAgrifactoryCore.event;

import com.mojang.brigadier.ParseResults;
import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.unified.UnifiedProxy;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.Difficulty;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.server.ServerLifecycleHooks;

@Mod.EventBusSubscriber
public class DifficultyChangeEvent {
    @SubscribeEvent
    public static void difficultyChangeEvent(net.minecraftforge.event.DifficultyChangeEvent event) {
        if(Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER /* Check if the event is firing on the Logical Server. Because I don't have access to a Level or World object here. Not guaranteed to always work if some other mod fucks with threads, but it’ll work.*/) {
            GregicAgrifactoryCore.LOGGER.info("difficultyChangeEvent has been fired, newdiff={} olddiff={}", event.getDifficulty(), event.getOldDifficulty());
            if (UnifiedProxy.config.disablePeaceful && event.getDifficulty() == Difficulty.PEACEFUL) {
                GregicAgrifactoryCore.LOGGER.warn("Tried to set difficulty to peaceful from {}, but peaceful mode is disabled! Setting difficulty back to {}", event.getOldDifficulty(), event.getOldDifficulty());
                MinecraftServer server = ServerLifecycleHooks.getCurrentServer();
                server.getCommands().performCommand(/* WHAT KIND OF PARSERESULTS DOES THIS SHITFUCK WANT FROM ME*/, "difficulty {}", event.getOldDifficulty().toString().toLowerCase());
            }
        }
    }
}
