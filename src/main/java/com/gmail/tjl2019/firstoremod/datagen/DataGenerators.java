package com.gmail.tjl2019.firstoremod.datagen;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = FirstOreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new FirstOreRecipeProvider(output));
        generator.addProvider(true, FirstOreLootTableProvider.create(output));
        generator.addProvider(true, new FirstOreBlockStateProvider(output, existingFileHelper));
        generator.addProvider(true, new FirstOreItemModelProvider(output, existingFileHelper));
        generator.addProvider(event.includeServer(), new FirstOreWorldGenProvider(output, lookupProvider));
    }


}
