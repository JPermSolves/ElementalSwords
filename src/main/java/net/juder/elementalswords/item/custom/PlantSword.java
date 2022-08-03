package net.juder.elementalswords.item.custom;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
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

public class PlantSword extends SwordItem {

    public PlantSword(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack pStack, LivingEntity pTarget, LivingEntity pAttacker) {

        Level level = pTarget.level;

        List<BlockPos> positions = new ArrayList<>();

        for (int i = -3; i < 2; i++) {
            positions.add(new BlockPos(pTarget.getX(), pTarget.getY() + (i + 1), pTarget.getZ()));
        }
        for (int i = -3; i < 2; i++) {
            positions.add(new BlockPos(pTarget.getX() + (i + 1), pTarget.getY(), pTarget.getZ()));
        }
        for (int i = -3; i < 2; i++) {
            positions.add(new BlockPos(pTarget.getX(), pTarget.getY(), pTarget.getZ() + (i + 1)));
        }
        for (int i = -2; i < 1; i++) {
            for (int j = -2; j < 1; j++) {
                positions.add(new BlockPos(pTarget.getX() + (j + 1), pTarget.getY(), pTarget.getZ() + (i + 1)));
            }
        }
        for (int i = -2; i < 1; i++) {
            for (int j = -2; j < 1; j++) {
                positions.add(new BlockPos(pTarget.getX(), pTarget.getY()  + (j + 1), pTarget.getZ() + (i + 1)));
            }
        }
        for (int i = -2; i < 1; i++) {
            for (int j = -2; j < 1; j++) {
                positions.add(new BlockPos(pTarget.getX() + (j + 1), pTarget.getY() + (i + 1), pTarget.getZ()));
            }
        }

        positions.remove(2);
        positions.remove(3);

        for (BlockPos i : positions) {
            if (level.getBlockState(i).canBeReplaced(new BlockPlaceContext((Player) pAttacker, InteractionHand.MAIN_HAND, pStack, new BlockHitResult(new Vec3(i.getX(), i.getY(), i.getZ()), Direction.UP, i, false)))) {
                level.setBlockAndUpdate(i, Blocks.OAK_LOG.defaultBlockState());
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }
    
}
