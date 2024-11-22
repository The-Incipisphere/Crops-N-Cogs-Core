package io.thedogofchaos.GregicAgrifactoryCore.registry;

import net.minecraftforge.eventbus.api.IEventBus;

public class Registry {
    public static void registerAll(IEventBus eventBus){
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(eventBus);
        BlockRegistry.BLOCKS.register(eventBus);
        ItemRegistry.ITEMS.register(eventBus);
        MenuRegistry.MENU_TYPES.register(eventBus);
    }
}
