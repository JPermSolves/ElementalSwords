package net.juder.elementalswords.item.custom;

import java.util.ArrayList;
import java.util.List;

import net.juder.elementalswords.ElementalSwords;
import net.juder.elementalswords.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
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
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.registries.ForgeRegistries;

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

        for (BlockPos i : positions) {
            if (level.getBlockState(i).canBeReplaced(new BlockPlaceContext((Player) pAttacker, InteractionHand.MAIN_HAND, pStack, new BlockHitResult(new Vec3(i.getX(), i.getY(), i.getZ()), Direction.UP, i, false)))) {
                level.setBlockAndUpdate(i, Blocks.POWDER_SNOW.defaultBlockState());
            } else if (level.getBlockState(i) == Blocks.WATER.defaultBlockState()) {
                level.setBlockAndUpdate(i, Blocks.ICE.defaultBlockState());
            } else if (level.getBlockState(i) == Blocks.DIRT.defaultBlockState() || level.getBlockState(i) == Blocks.GRASS.defaultBlockState() && ModList.get().isLoaded("quark")) {
                level.setBlockAndUpdate(i, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("permafrost")).defaultBlockState());
            }
        }

        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

}
