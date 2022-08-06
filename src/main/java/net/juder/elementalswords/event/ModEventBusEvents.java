package net.juder.elementalswords.event;

import javax.annotation.Nonnull;

import com.ibm.icu.util.RangeValueIterator.Element;

import net.juder.elementalswords.ElementalSwords;
import net.juder.elementalswords.event.loot.BoltFromZombifiedPiglins;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.loot.GlobalLootModifierSerializer;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ElementalSwords.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerModifierSerializers(@Nonnull final RegistryEvent.Register<GlobalLootModifierSerializer<?>> event) {
        event.getRegistry().registerAll(new BoltFromZombifiedPiglins.Serializer().setRegistryName(new ResourceLocation(ElementalSwords.MOD_ID,"bolt_from_zombified_piglins")));
    }
}
