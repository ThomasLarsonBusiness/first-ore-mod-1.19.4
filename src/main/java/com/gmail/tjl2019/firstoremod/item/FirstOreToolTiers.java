package com.gmail.tjl2019.firstoremod.item;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.gmail.tjl2019.firstoremod.util.FirstOreModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class FirstOreToolTiers {
    // List of Tiers
    public static Tier SILVER;

    static {
        SILVER = TierSortingRegistry.registerTier(
                new ForgeTier(2, 350, 7.0f, 2.0f, 14,
                        FirstOreModTags.Blocks.NEEDS_SILVER_TOOL, () -> {
                    return Ingredient.of(FirstOreItems.SILVER_INGOT.get());} ),
                new ResourceLocation(FirstOreMod.MOD_ID, "silver"),
                        List.of(Tiers.IRON), List.of(Tiers.DIAMOND)
        );
    }


}
