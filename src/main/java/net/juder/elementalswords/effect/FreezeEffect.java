package net.juder.elementalswords.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class FreezeEffect extends MobEffect {

    protected FreezeEffect(MobEffectCategory category, int color) {
        super(category, color);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        // TODO Auto-generated method stub

        pLivingEntity.setSpeed(0);
        pLivingEntity.setDeltaMovement(new Vec3(0, 0, 0));

        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        // TODO Auto-generated method stub
        return true;
    }
}
