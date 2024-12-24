package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;

import io.thedogofchaos.GregicAgrifactoryCore.unified.registry.CropRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GregicAgrifactoryCore.MOD_ID);

    // insert RegistryObject<T> here

    /*//////////////////////////////*/
    /*/ ***** HELPER METHODS ***** /*/
    /*//////////////////////////////*/

    /**Registers a Block and BlockItem.
     * <br><b>Be sensible, and don't call this if the block in question should NOT have a BlockItem.</b>
     * @param name A string with the name of the block to register.
     * @param block A supplier of the block to register.
     * @return The block, to be assigned to a {@link RegistryObject} field.
     */
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void init(IEventBus modBus) {
        BLOCKS.register(modBus);
        CropRegistry.getInstance().onRegisterBlocks(BLOCKS);
    }
}
