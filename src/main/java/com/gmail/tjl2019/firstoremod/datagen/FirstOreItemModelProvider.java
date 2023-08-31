package com.gmail.tjl2019.firstoremod.datagen;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.gmail.tjl2019.firstoremod.item.FirstOreItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class FirstOreItemModelProvider extends ItemModelProvider {
    public FirstOreItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstOreMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Silver Ore
        simpleItem(FirstOreItems.RAW_SILVER);
        simpleItem(FirstOreItems.SILVER_INGOT);

        // Silver Tools
        handheldItem(FirstOreItems.SILVER_AXE);
        handheldItem(FirstOreItems.SILVER_HOE);
        handheldItem(FirstOreItems.SILVER_PICKAXE);
        handheldItem(FirstOreItems.SILVER_SHOVEL);
        handheldItem(FirstOreItems.SILVER_SWORD);

        // Scythe Tools
        handheldItem(FirstOreItems.WOODEN_SCYTHE);
        handheldItem(FirstOreItems.STONE_SCYTHE);
        handheldItem(FirstOreItems.IRON_SCYTHE);
        handheldItem(FirstOreItems.SILVER_SCYTHE);
        handheldItem(FirstOreItems.GOLD_SCYTHE);
        handheldItem(FirstOreItems.DIAMOND_SCYTHE);
        handheldItem(FirstOreItems.NETHERITE_SCYTHE);

        // Hammer Tools
        handheldItem(FirstOreItems.WOODEN_HAMMER);
        handheldItem(FirstOreItems.STONE_HAMMER);
        handheldItem(FirstOreItems.IRON_HAMMER);
        handheldItem(FirstOreItems.SILVER_HAMMER);
        handheldItem(FirstOreItems.GOLD_HAMMER);
        handheldItem(FirstOreItems.DIAMOND_HAMMER);
        handheldItem(FirstOreItems.NETHERITE_HAMMER);


    }


    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FirstOreMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(FirstOreMod.MOD_ID, "item/" + item.getId().getPath()));
    }

}
