package net.juder.elementalswords.item;

import net.juder.elementalswords.ElementalSwords;
import net.juder.elementalswords.item.custom.Bolt;
import net.juder.elementalswords.item.custom.FireSword;
import net.juder.elementalswords.item.custom.IceSword;
import net.juder.elementalswords.item.custom.LightningSword;
import net.juder.elementalswords.item.custom.PlantSword;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalSwords.MOD_ID);

    public static final RegistryObject<Item> FIRE_SWORD = ITEMS.register("fire_sword", () -> new FireSword(ModTiers.FIRE_SWORD, 2, 1, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT).fireResistant()));

    public static final RegistryObject<Item> ICE_SWORD = ITEMS.register("ice_sword", () -> new IceSword(ModTiers.ICE_SWORD, 2, -2, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> LIGHTNING_SWORD = ITEMS.register("lightning_sword", () -> new LightningSword(ModTiers.LIGHTNING_SWORD, 2, 2, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> FROSTY_ROD = ITEMS.register("frosty_rod", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> BOLT = ITEMS.register("bolt", () -> new Bolt(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> PLANT_SWORD = ITEMS.register("plant_sword", () -> new PlantSword(ModTiers.PLANT_SWORD, 2, 0, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> MOSSY_STICK = ITEMS.register("mossy_stick", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static final RegistryObject<Item> CONDUCTOR_ROD = ITEMS.register("conductor_rod", () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}