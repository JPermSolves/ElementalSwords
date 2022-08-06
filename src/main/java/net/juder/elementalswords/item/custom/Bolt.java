package net.juder.elementalswords.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.Vec3;

public class Bolt extends Item {

    public Bolt(Properties pProperties) {
        super(pProperties);
    }
    
    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        ServerLevel level = null;
        
        if (!pContext.getLevel().isClientSide) {
            level = (ServerLevel) pContext.getLevel();
        }

        if (level != null) {
            LightningBolt bolt = EntityType.LIGHTNING_BOLT.create(level);
            bolt.moveTo(Vec3.atBottomCenterOf(new BlockPos(pContext.getClickLocation())));
            bolt.setVisualOnly(false);

            level.addFreshEntity(bolt);
        }

        //pContext.getPlayer().setItemSlot(pContext.getItemInHand().getEquipmentSlot(), new ItemStack(craftingRemainingItem));

        return super.useOn(pContext);
    }

}
