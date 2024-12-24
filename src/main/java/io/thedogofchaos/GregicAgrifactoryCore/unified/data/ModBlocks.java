package io.thedogofchaos.GregicAgrifactoryCore.unified.data;

import io.thedogofchaos.GregicAgrifactoryCore.GregicAgrifactoryCore;
import io.thedogofchaos.GregicAgrifactoryCore.block.OreCropBlock;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GregicAgrifactoryCore.MOD_ID);

    // Vanilla Materials
    public static final RegistryObject<Block> GOLD_CROP = BLOCKS.register("gold_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.GOLD_SEEDS::get, 0xfdf55f, "debug"));
    public static final RegistryObject<Block> COAL_CROP = BLOCKS.register("coal_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.COAL_SEEDS::get));
    public static final RegistryObject<Block> REDSTONE_CROP = BLOCKS.register("redstone_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.REDSTONE_SEEDS::get));
    public static final RegistryObject<Block> DIAMOND_CROP = BLOCKS.register("diamond_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.DIAMOND_SEEDS::get));
    public static final RegistryObject<Block> EMERALD_CROP = BLOCKS.register("emerald_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.EMERALD_SEEDS::get));
    public static final RegistryObject<Block> AMETHYST_CROP = BLOCKS.register("amethyst_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.AMETHYST_SEEDS::get));
    public static final RegistryObject<Block> NETHER_QUARTZ_CROP = BLOCKS.register("nether_quartz_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.NETHER_QUARTZ_SEEDS::get));
    // GT Materials
    // Metals
    public static final RegistryObject<Block> MAGNETITE_CROP = BLOCKS.register("magnetite_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.MAGNETITE_SEEDS::get));
    public static final RegistryObject<Block> CHALCOPYRITE_CROP = BLOCKS.register("chalcopyrite_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.CHALCOPYRITE_SEEDS::get));
    public static final RegistryObject<Block> CASSITERITE_CROP = BLOCKS.register("cassiterite_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.CASSITERITE_SEEDS::get));
    public static final RegistryObject<Block> NICKEL_CROP = BLOCKS.register("nickel_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.NICKEL_SEEDS::get));
    public static final RegistryObject<Block> SILVER_CROP = BLOCKS.register("silver_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.SILVER_SEEDS::get));
    public static final RegistryObject<Block> COBALT_CROP = BLOCKS.register("cobalt_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.COBALT_SEEDS::get));
    public static final RegistryObject<Block> LEAD_CROP = BLOCKS.register("lead_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.LEAD_SEEDS::get));
    public static final RegistryObject<Block> SPHALERITE_CROP = BLOCKS.register("sphalerite_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.SPHALERITE_SEEDS::get));
    // Gems
    public static final RegistryObject<Block> RUBY_CROP = BLOCKS.register("ruby_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.RUBY_SEEDS::get));
    public static final RegistryObject<Block> SAPPHIRE_CROP = BLOCKS.register("sapphire_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.SAPPHIRE_SEEDS::get));
    public static final RegistryObject<Block> GREEN_SAPPHIRE_CROP = BLOCKS.register("green_sapphire_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.GREEN_SAPPHIRE_SEEDS::get));
    public static final RegistryObject<Block> TOPAZ_CROP = BLOCKS.register("topaz_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.TOPAZ_SEEDS::get));
    public static final RegistryObject<Block> APATITE_CROP = BLOCKS.register("apatite_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.APATITE_SEEDS::get));
    public static final RegistryObject<Block> OPAL_CROP = BLOCKS.register("opal_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.OPAL_SEEDS::get));
    public static final RegistryObject<Block> CINNABAR_CROP = BLOCKS.register("cinnabar_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.CINNABAR_SEEDS::get));
    public static final RegistryObject<Block> REALGAR_CROP = BLOCKS.register("realgar_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.REALGAR_SEEDS::get));
    public static final RegistryObject<Block> CERTUS_QUARTZ_CROP = BLOCKS.register("certus_quartz_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.CERTUS_QUARTZ_SEEDS::get));
    public static final RegistryObject<Block> QUARTZITE_CROP = BLOCKS.register("quartzite_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.QUARTZITE_SEEDS::get));
    public static final RegistryObject<Block> SALT_CROP = BLOCKS.register("salt_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.SALT_SEEDS::get));
    // Misc
    public static final RegistryObject<Block> SALTPETRE_CROP = BLOCKS.register("saltpetre_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.SALTPETRE_SEEDS::get));
    public static final RegistryObject<Block> SULPHUR_CROP = BLOCKS.register("sulphur_crop",
            () -> new OreCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission(), ModItems.SULPHUR_SEEDS::get));

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
    }
}
