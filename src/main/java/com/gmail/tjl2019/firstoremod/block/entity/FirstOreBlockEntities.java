package com.gmail.tjl2019.firstoremod.block.entity;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.gmail.tjl2019.firstoremod.block.FirstOreBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class FirstOreBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, FirstOreMod.MOD_ID);


    public static final RegistryObject<BlockEntityType<LampBlockEntity>> LAMP_BLOCK =
            BLOCK_ENTITIES.register("lamp_block", () ->
                    BlockEntityType.Builder.of(LampBlockEntity::new,
                            FirstOreBlocks.LAMP_BLOCK.get()).build(null));



    public static void register(IEventBus event){
        BLOCK_ENTITIES.register(event);
    }
}
