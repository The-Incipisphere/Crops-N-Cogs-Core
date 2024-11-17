package io.thedogofchaos.GregicAgrifactoryCore.crops;

import io.thedogofchaos.GregicAgrifactoryCore.crops.CropTextures;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

public class Crop {
    private final ResourceLocation id;
    private Component displayName;
    private int flowerColor;
    private int essenceColor;
    private int harvestedColor;
    private int seedColor;
    private CropTextures textures;
    private Supplier<? extends CropBlock> crop;
    private Supplier<? extends Item> essence;
    private Supplier<? extends Item> harvestedItem;
    private Supplier<? extends ItemNameBlockItem> seeds;
    private Supplier<? extends Block> crux;
    private boolean enabled;
    private boolean registerCropBlock;
    private boolean registerEssenceItem;
    private boolean registerHarvestedItem;
    private boolean registerSeedsItem;
    private boolean hasEffect;
    private Set<ResourceLocation> requiredBiomes;


    /**
     * Represents a new crop for registration
     * @param id the id of this crop, the path is used to generate the name
     */
    public Crop(ResourceLocation id) {
        this(id, new CropTextures());
    }

    /**
     * Represents a new crop for registration
     * @param id the id of this crop, the path is used to generate the name
     */
    public Crop(ResourceLocation id, int color) {
        this(id,new CropTextures(), color);
    }

    /**
     * Represents a new crop for registration
     * @param id the id of this crop, the path is used to generate the name
     * @param textures the textures of this crop
     */
    public Crop(ResourceLocation id, CropTextures textures) {
        this(id, textures, -1);
    }

    /**
     * Represents a new crop for registration
     * @param id the id of this crop, the path is used to generate the name
     * @param textures the textures of this crop
     * @param color the color to color the textures with
     */
    public Crop(ResourceLocation id, CropTextures textures, int color) {
        this.id = id;
        this.textures = textures.init(id);
        this.setColor(color);
        this.enabled = true;
        this.registerCropBlock = true;
        this.registerEssenceItem = true;
        this.registerHarvestedItem = true;
        this.registerSeedsItem = true;
        this.hasEffect = false;
        this.requiredBiomes = new HashSet<>();
    }

    /**
     * The id of this crop, the modid is taken from the namespace for {@link Crop#getModId()},
     * and the path is used for {@link Crop#getName()}
     * @return the id of this crop
     */
    public ResourceLocation getId() {
        return this.id;
    }

    /**
     * The internal name of this crop.
     * This is used for registration, so it MUST be all lowercase with underscores for spaces
     * @return the internal name of this crop
     */
    public String getName() {
        return this.getId().getPath();
    }

    /**
     * The modid of the mod that registered this crop
     * @return the modid of this crop
     */
    public String getModId() {
        return this.getId().getNamespace();
    }

    /**
     * Used to get the internal name of this crop with an _suffix
     * @param suffix the suffix to append (without the initial underscore)
     * @return the name with _suffix
     */
    public String getNameWithSuffix(String suffix) {
        return String.format("%s_%s", this.getName(), suffix);
    }

    /**
     * Get the localized name of this crop using the key crop.{@link Crop#getModId()}.{@link Crop#getName()},
     * or the display name set via {@link Crop#setDisplayName(Component)}
     * @return the localized name of this crop
     */
    public Component getDisplayName() {
        return this.displayName != null
                ? this.displayName
                : Component.translatable(String.format("crop.%s.%s", this.getModId(), this.getName()));
    }

    /**
     * Sets the display name of this crop
     * @param name the new display name
     * @return this crop
     */
    public Crop setDisplayName(Component name) {
        this.displayName = name;
        return this;
    }

    /**
     * All the textures related to this crop
     * @return the crop's textures
     */
    public CropTextures getTextures() {
        return this.textures;
    }

    /**
     * Whether this crop's flower should be colored using the color defined by {@link Crop#getFlowerColor()}
     * @return is the crop's flower colored
     */
    public boolean isFlowerColored() {
        return this.getFlowerColor() > -1;
    }

    /**
     * The color that should overlay this crop's flower
     * @return the color of this crop's flower
     */
    public int getFlowerColor() {
        return this.flowerColor;
    }

    /**
     * Set the color that should overlay this crop's flower
     * @param color the color
     * @return this crop
     */
    public Crop setFlowerColor(int color) {
        this.flowerColor = color;
        return this;
    }

    /**
     * Whether this crop's essence should be colored using the color defined by {@link Crop#getEssenceColor()}
     * @return is the crop's essence colored
     */
    public boolean isEssenceColored() {
        return this.getEssenceColor() > -1;
    }

    /**
     * The color that should overlay this crop's essence
     * @return the color of this crop's essence
     */
    public int getEssenceColor() {
        return this.essenceColor;
    }

    /**
     * Set the color that should overlay this crop's essence
     * @param color the color
     * @return this crop
     */
    public Crop setEssenceColor(int color) {
        this.essenceColor = color;
        return this;
    }

    /**
     * Whether this crop's seed should be colored using the color defined by {@link #getSeedColor()}
     * @return is the crop's seed colored
     */
    public boolean isSeedColored() {
        return this.getSeedColor() > -1;
    }

    /** The color that should overlay this crop's seed
     * @return the color of this crop's seed
     */
    public int getSeedColor() {
        return this.seedColor;
    }

    /**
     * Set the color that should overlay this crop's seed
     * @param color the color
     * @return this crop
     */
    public Crop setSeedColor(int color) {
        this.seedColor = color;
        return this;
    }

    /**
     * The crop block for this crop type
     * @return the crop block
     */
    public CropBlock getCropBlock() {
        return this.crop == null ? null : this.crop.get();
    }

    /**
     * Used to set the crop block instance for this crop, the supplier should return the same instance every time
     * @param crop the crop block
     * @return this crop
     */
    public Crop setCropBlock(Supplier<? extends CropBlock> crop) {
        return this.setCropBlock(crop, false);
    }

    /**
     * Used to set the crop block instance for this crop, the supplier should return the same instance every time
     * @param crop the crop block
     * @param register should this block be automatically registered
     * @return this crop
     */
    public Crop setCropBlock(Supplier<? extends CropBlock> crop, boolean register) {
        this.crop = crop;
        this.registerCropBlock = register;
        return this;
    }

    /**
     * Should this crop's crop block be registered
     * @return should be registered
     */
    public boolean shouldRegisterCropBlock() {
        return this.registerCropBlock;
    }

    /**
     * The essence item for this crop type
     * @return the essence item
     */
    public Item getEssenceItem() {
        return this.essence == null ? null : this.essence.get();
    }

    /**
     * Used to set the essence item instance for this crop, the supplier should return the same instance every time
     * @param essence the essence item
     * @return this crop
     */
    public Crop setEssenceItem(Supplier<? extends Item> essence) {
        return this.setEssenceItem(essence, false);
    }

    /**
     * Used to set the essence item instance for this crop, the supplier should return the same instance every time
     * @param essence the essence item
     * @param register should this item be registered
     * @return this crop
     */
    public Crop setEssenceItem(Supplier<? extends Item> essence, boolean register) {
        this.essence = essence;
        this.registerEssenceItem = register;
        return this;
    }

    /**
     * Should this crop's essence item be registered
     * @return should be registered
     */
    public boolean shouldRegisterEssenceItem() {
        return this.registerEssenceItem;
    }

    /**
     * The essence item for this crop type
     * @return the essence item
     */
    public Item getHarvestedItem() {
        return this.essence == null ? null : this.essence.get();
    }

    /**
     * Used to set the harvested item instance for this crop, the supplier should return the same instance every time
     * @param harvestedItem the essence item
     * @return this crop
     */
    public Crop setHarvestedItem(Supplier<? extends Item> harvestedItem) {
        return this.setHarvestedItem(harvestedItem, false);
    }


    /**
     * Used to set the harvested item instance for this crop, the supplier should return the same instance every time
     * @param harvestedItem the essence item
     * @param register should this item be registered
     * @return this crop
     */
    public Crop setHarvestedItem(Supplier<? extends Item> harvestedItem, boolean register) {
        this.harvestedItem = harvestedItem;
        this.registerEssenceItem = register;
        return this;
    }

    /**
     * Should this crop's essence item be registered
     * @return should be registered
     */
    public boolean shouldRegisterHarvestedItem() {
        return this.registerHarvestedItem;
    }


    /**
     * The seeds item for this crop type
     * @return the seed item
     */
    public ItemNameBlockItem getSeedsItem() {
        return this.seeds == null ? null : this.seeds.get();
    }

    /**
     * Used to set the seeds item instance for this crop, the supplier should return the same instance every time
     * @param seeds the seeds item
     * @return this crop
     */
    public Crop setSeedsItem(Supplier<? extends ItemNameBlockItem> seeds) {
        return this.setSeedsItem(seeds, false);
    }

    /**
     * Used to set the seeds item instance for this crop, the supplier should return the same instance every time
     * @param seeds the seeds item
     * @param register should this item be registered
     * @return this crop
     */
    public Crop setSeedsItem(Supplier<? extends ItemNameBlockItem> seeds, boolean register) {
        this.seeds = seeds;
        this.registerSeedsItem = register;
        return this;
    }

    /**
     * Should this crop's seeds item be registered
     * @return should be registered
     */
    public boolean shouldRegisterSeedsItem() {
        return this.registerSeedsItem;
    }

    /**
     * Whether this crop has recipes and shows up in the creative menu
     * @return is this crop enabled
     */
    public boolean isEnabled() {
        return this.enabled;
    }

    /**
     * Set whether this crop should be hidden from the game
     * @param enabled the enabled state
     */
    public Crop setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    /**
     * The crux block for this crop type
     * @return the crux block
     */
    public Block getCruxBlock() {
        return this.crux == null ? null : this.crux.get();
    }

    /**
     * Used to set the crux block instance for this crop, the supplier should return the same instance every time
     * @param crux the crux block
     * @return this crop
     */
    public Crop setCruxBlock(Supplier<? extends Block> crux) {
        this.crux = crux;
        return this;
    }

    /**
     * Whether or not this crops items should have the enchantment glint effect
     * @param stack the stack
     * @return should the crop have the glint effect
     */
    public boolean hasEffect(ItemStack stack) {
        return this.hasEffect;
    }

    /**
     * Set whether or not this crop should have the enchantment glint effect
     * @param hasEffect the effect state
     * @return this crop
     */
    public Crop setHasEffect(boolean hasEffect) {
        this.hasEffect = hasEffect;
        return this;
    }

    /**
     * A set of biome ids that this crop can grow in
     * @return this crop's required biomes
     */
    public Set<ResourceLocation> getRequiredBiomes() {
        return this.requiredBiomes;
    }

    /**
     * Add a biome id to the list of required biomes for this crop
     * @param id the biome id
     * @return this crop
     */
    public Crop addRequiredBiome(ResourceLocation id) {
        this.requiredBiomes.add(id);
        return this;
    }

    /**
     * Helper method to set the flower, essence, and seed colors
     * @param color the color
     * @return this crop
     */
    public Crop setColor(int color) {
        this.setFlowerColor(color);
        this.setEssenceColor(color);
        this.setSeedColor(color);

        return this;
    }
}