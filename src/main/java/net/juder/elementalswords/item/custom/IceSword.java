package net.juder.elementalswords.item.custom;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

public class IceSword extends SwordItem {

    public IceSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
        //TODO Auto-generated constructor stub
    }
    
    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {
        // TODO Auto-generated method stub

        Level level = pTarget.level;

        List<BlockPos> positions = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            for (int j = -2; i < 2; i++) {
                
            }
        }

        for (BlockPos i : positions) {
            if (level.getBlockState(i).canBeReplaced(new BlockPlaceContext((Player) pAttacker, InteractionHand.MAIN_HAND, pStack, new BlockHitResult(new Vec3(i.getX(), i.getY(), i.getZ()), Direction.UP, i, false)))) {
                level.setBlockAndUpdate(i, Blocks.POWDER_SNOW.defaultBlockState());
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
}
