package com.gmail.tjl2019.firstoremod.item;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.gmail.tjl2019.firstoremod.block.FirstOreBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = FirstOreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CustomCreativeModTabs {
    // Creates the Custom Tab
    public static CreativeModeTab FIRSTORE_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        FIRSTORE_TAB = event.registerCreativeModeTab(new ResourceLocation(FirstOreMod.MOD_ID, "firstore_tab"),
                builder -> builder.icon(() -> new ItemStack(FirstOreItems.SILVER_INGOT.get()))
                        .title(Component.translatable("creativemodtab.firstore_tab"))
                        .displayItems((generator, populator) -> {
                            // Silver Drops
                            populator.accept(new ItemStack(FirstOreItems.SILVER_INGOT.get()));
                            populator.accept(new ItemStack(FirstOreItems.RAW_SILVER.get()));
                            // Vanilla Silver Tools
                            populator.accept(new ItemStack(FirstOreItems.SILVER_AXE.get()));
                            populator.accept(new ItemStack(FirstOreItems.SILVER_PICKAXE.get()));
                            populator.accept(new ItemStack(FirstOreItems.SILVER_SHOVEL.get()));
                            populator.accept(new ItemStack(FirstOreItems.SILVER_SWORD.get()));
                            populator.accept(new ItemStack(FirstOreItems.SILVER_HOE.get()));
                            // Silver Blocks
                            populator.accept(new ItemStack(FirstOreBlocks.SILVER_BLOCK.get()));
                            populator.accept(new ItemStack(FirstOreBlocks.SILVER_ORE.get()));
                            populator.accept(new ItemStack(FirstOreBlocks.DEEPSLATE_SILVER_ORE.get()));
                            // Scythes
                            populator.accept(new ItemStack(FirstOreItems.WOODEN_SCYTHE.get()));
                            populator.accept(new ItemStack(FirstOreItems.STONE_SCYTHE.get()));
                            populator.accept(new ItemStack(FirstOreItems.IRON_SCYTHE.get()));
                            populator.accept(new ItemStack(FirstOreItems.SILVER_SCYTHE.get()));
                            populator.accept(new ItemStack(FirstOreItems.GOLD_SCYTHE.get()));
                            populator.accept(new ItemStack(FirstOreItems.DIAMOND_SCYTHE.get()));
                            populator.accept(new ItemStack(FirstOreItems.NETHERITE_SCYTHE.get()));
                            // Hammers
                            populator.accept(new ItemStack(FirstOreItems.WOODEN_HAMMER.get()));
                            populator.accept(new ItemStack(FirstOreItems.STONE_HAMMER.get()));
                            populator.accept(new ItemStack(FirstOreItems.IRON_HAMMER.get()));
                            populator.accept(new ItemStack(FirstOreItems.SILVER_HAMMER.get()));
                            populator.accept(new ItemStack(FirstOreItems.GOLD_HAMMER.get()));
                            populator.accept(new ItemStack(FirstOreItems.DIAMOND_HAMMER.get()));
                            populator.accept(new ItemStack(FirstOreItems.NETHERITE_HAMMER.get()));
                            // Lamp
                            populator.accept(new ItemStack(FirstOreBlocks.LAMP_BLOCK.get()));
                        }));
    }

}
