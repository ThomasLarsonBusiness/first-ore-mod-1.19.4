package com.gmail.tjl2019.firstoremod.block;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.gmail.tjl2019.firstoremod.block.custom.LampBlock;
import com.gmail.tjl2019.firstoremod.item.FirstOreItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class FirstOreBlocks {
    // Defines the Deferred Register
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FirstOreMod.MOD_ID);

    // Blocks
    public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops()
                    .strength(6f)));

    public static final RegistryObject<Block> SILVER_ORE = registerBlock("silver_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops()
                    .strength(4f)));

    public static final RegistryObject<Block> DEEPSLATE_SILVER_ORE = registerBlock("deepslate_silver_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops()
                    .strength(5f)));

    public static final RegistryObject<Block> LAMP_BLOCK = registerBlock("lamp_block",
            () -> new LampBlock(BlockBehaviour.Properties.of(Material.METAL).requiresCorrectToolForDrops().
                    strength(6f).lightLevel(state -> state.getValue(LampBlock.LIGHT_VALUE))));

    // Helper Function
    private static <T extends Block> RegistryObject<T> registerBlock (String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return FirstOreItems.ITEMS.register(name, () ->  new BlockItem(block.get(), new Item.Properties()));
    }

    // Register Function
    public static void register(IEventBus event){
        BLOCKS.register(event);
    }
}
