package com.gmail.tjl2019.firstoremod.item.CustomItems;

import com.gmail.tjl2019.firstoremod.item.FirstOreToolTiers;
import com.gmail.tjl2019.firstoremod.util.FirstOreModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.Tags;

public class ScytheItem extends TieredItem implements Vanishable {
    // Fields
    private final Tier tier;

    // Default Constructor
    public ScytheItem(Tier _tier, Item.Properties properties){
        super(_tier, properties);
        this.tier = _tier;
    }

    // Overrided Methods
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.FLOWERS) || state.is(BlockTags.CROPS) || state.is(BlockTags.REPLACEABLE_PLANTS)){
            return 15.0f;
        } else {
            return 0.0f;
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        // Initial Variables for the method
        ItemStack stack = player.getItemInHand(hand);
        int numDestroyed = 0;

        // Determines how many loops based on the tiers
        int loopCount = 1;
        if (tier.equals(FirstOreToolTiers.SILVER) || tier.equals(Tiers.DIAMOND) || tier.equals(Tiers.NETHERITE)) {
            loopCount = 2;
        }

        // Gets the target block's position
        BlockHitResult ray = getPlayerPOVHitResult(level, player, ClipContext.Fluid.NONE);
        BlockPos centerPos = ray.getBlockPos();

        // Loops through the blocks directly adjacent to the target block
        for (int i = -1 * loopCount; i < loopCount + 1; i++) {
            for (int j = -1 * loopCount; j < loopCount + 1; j++) {
                BlockPos tempPos = centerPos;

                tempPos = tempPos.offset(i, 0, j);

                // If the target block is a FLOWER, CROP, or REPLACEABLE_PLANT
                if (level.getBlockState(tempPos).is(BlockTags.FLOWERS) || level.getBlockState(tempPos).is(BlockTags.CROPS)
                        || level.getBlockState(tempPos).is(BlockTags.REPLACEABLE_PLANTS)) {
                    level.destroyBlock(tempPos, true, null, 1);
                    numDestroyed++;
                }
            }
        }

        // If it actually destroyed something, damages the tool
        if (numDestroyed != 0) {
            stack.hurtAndBreak(1, player, (e) -> {
                e.broadcastBreakEvent(EquipmentSlot.MAINHAND);
            });

            player.getCooldowns().addCooldown(this, 20);
        }

        return InteractionResultHolder.pass(player.getItemInHand(hand));
    }
}
