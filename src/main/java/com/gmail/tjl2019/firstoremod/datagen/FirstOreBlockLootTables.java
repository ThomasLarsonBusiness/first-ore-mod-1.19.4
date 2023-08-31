package com.gmail.tjl2019.firstoremod.datagen;

import com.gmail.tjl2019.firstoremod.block.FirstOreBlocks;
import com.gmail.tjl2019.firstoremod.item.FirstOreItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class FirstOreBlockLootTables extends BlockLootSubProvider {

    protected FirstOreBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(FirstOreBlocks.SILVER_BLOCK.get());
        dropSelf(FirstOreBlocks.LAMP_BLOCK.get());

        add(FirstOreBlocks.SILVER_ORE.get(),
                (block) -> createOreDrop(FirstOreBlocks.SILVER_ORE.get(), FirstOreItems.RAW_SILVER.get()));

        add(FirstOreBlocks.DEEPSLATE_SILVER_ORE.get(),
                (block) -> createOreDrop(FirstOreBlocks.DEEPSLATE_SILVER_ORE.get(), FirstOreItems.RAW_SILVER.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return FirstOreBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
