package io.thedogofchaos.GregicAgrifactoryCore.registry;

import net.minecraftforge.eventbus.api.IEventBus;

public class Registry {
    public static void register(IEventBus eventBus) {
        MenuRegistry.MENU_TYPES.register(eventBus);
        BlockEntityRegistry.BLOCK_ENTITY_TYPES.register(eventBus);
        BlockRegistry.BLOCKS.register(eventBus);
        ItemRegistry.ITEMS.register(eventBus);
    }
}
