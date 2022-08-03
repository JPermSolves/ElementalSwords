package net.juder.elementalswords.effect;

import net.juder.elementalswords.ElementalSwords;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, ElementalSwords.MOD_ID);

    public static final RegistryObject FREEZE = EFFECTS.register("freeze", () -> new FreezeEffect(MobEffectCategory.HARMFUL, 0));

    public static void register(IEventBus bus) {
        EFFECTS.register(bus);
    }
}
