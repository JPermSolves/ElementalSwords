package net.juder.elementalswords.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.Vec3;

public class LightningSword extends SwordItem {

    public LightningSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        // TODO Auto-generated method stub

        ServerLevel level = (ServerLevel) pTarget.level;

        LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
        bolt.moveTo(Vec3.atBottomCenterOf(new BlockPos(pTarget.getX(), pTarget.getY(), pTarget.getZ())));
        bolt.setVisualOnly(false);

        level.addFreshEntity(bolt);

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
