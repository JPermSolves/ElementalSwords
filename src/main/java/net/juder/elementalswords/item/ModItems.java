package net.juder.elementalswords.item;

import net.juder.elementalswords.ElementalSwords;
import net.juder.elementalswords.item.custom.FireSword;
import net.juder.elementalswords.item.custom.IceSword;
import net.juder.elementalswords.item.custom.LightningSword;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ElementalSwords.MOD_ID);

    public static final RegistryObject<Item> FIRE_SWORD = ITEMS.register("fire_sword", () -> new FireSword(ModTiers.FIRE_SWORD, 2, 1, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> ICE_SWORD = ITEMS.register("ice_sword", () -> new IceSword(ModTiers.ICE_SWORD, 2, -2, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));

    public static final RegistryObject<Item> LIGHTNING_SWORD = ITEMS.register("lightning_sword", () -> new LightningSword(ModTiers.LIGHTNING_SWORD, 2, 2, new Item.Properties().stacksTo(1).tab(CreativeModeTab.TAB_COMBAT)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}