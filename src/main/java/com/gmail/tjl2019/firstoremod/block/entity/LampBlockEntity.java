package com.gmail.tjl2019.firstoremod.block.entity;

import com.gmail.tjl2019.firstoremod.block.custom.LampBlock;
import com.mojang.logging.LogUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.logging.Logger;

public class LampBlockEntity extends BlockEntity {
    private static final org.slf4j.Logger LOGGER = LogUtils.getLogger();

    public LampBlockEntity(BlockPos blockPos, BlockState state) {
        super(FirstOreBlockEntities.LAMP_BLOCK.get(), blockPos, state);
    }

    /* TODO
    *
    *   Make sure the math isn't affected by being directly under a block
    *   Make sure it works when fully exposed to the sun
    */
    public static void tick(Level level, BlockPos pos, BlockState  state, LampBlockEntity pEntity) {
        if (level.isClientSide()) { return; }

        if (level.getGameTime() % 20 == 0) {
            int i = level.getBrightness(LightLayer.SKY, pos.above()) - level.getSkyDarken();
            i = Mth.clamp(i, 0, 15);
            i = 15 - i;
            LOGGER.info("Combined: " + i + " Sky Level: " + level.getBrightness(LightLayer.SKY, pos.above()) +
                    " Darkness: " + level.getSkyDarken());
            level.setBlockAndUpdate(pos, state.setValue(LampBlock.LIGHT_VALUE, i));
        }


    }


}
