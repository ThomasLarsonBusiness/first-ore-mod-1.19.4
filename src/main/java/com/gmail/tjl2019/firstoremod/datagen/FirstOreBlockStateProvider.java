package com.gmail.tjl2019.firstoremod.datagen;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.gmail.tjl2019.firstoremod.block.FirstOreBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.Resource;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class FirstOreBlockStateProvider extends BlockStateProvider {
    public FirstOreBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, FirstOreMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(FirstOreBlocks.SILVER_BLOCK);
        blockWithItem(FirstOreBlocks.SILVER_ORE);
        blockWithItem(FirstOreBlocks.DEEPSLATE_SILVER_ORE);

        blockWithTopBottom(FirstOreBlocks.LAMP_BLOCK,
                new ResourceLocation(FirstOreMod.MOD_ID, "block/lamp_block_side"),
                new ResourceLocation(FirstOreMod.MOD_ID, "block/lamp_block_bottom"),
                new ResourceLocation(FirstOreMod.MOD_ID, "block/lamp_block_top"));
    }

    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }


    public void blockWithTopBottom(RegistryObject<Block> blockRegistryObject, ResourceLocation side,
                                   ResourceLocation bottom, ResourceLocation top) {
        simpleBlockWithItem(blockRegistryObject.get(), models().cubeBottomTop("lamp_block", side, bottom, top));
    }


}



