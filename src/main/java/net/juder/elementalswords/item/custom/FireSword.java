package net.juder.elementalswords.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class FireSword extends SwordItem {

    public FireSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        // TODO Auto-generated method stub
        pTarget.setRemainingFireTicks(100);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

}
