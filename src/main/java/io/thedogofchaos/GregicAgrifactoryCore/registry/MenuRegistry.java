package io.thedogofchaos.GregicAgrifactoryCore.registry;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.gui.container.AshFurnaceContainer;
import net.minecraft.world.inventory.MenuType;

import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class MenuRegistry {
    protected static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, GregicAgrifactoryCore.MOD_ID);

    public static final RegistryObject<MenuType<AshFurnaceContainer>> ASH_FURNACE_CONTAINER = MENU_TYPES.register("furnace_menu",
        () -> IForgeMenuType.create(
            (windowId, inv, data) -> new AshFurnaceContainer(windowId, inv.player.getInventory()))
    );
}
