package com.gmail.tjl2019.firstoremod.util;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FirstOreModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_SILVER_TOOL =
                tag("needs_silver_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(FirstOreMod.MOD_ID, name));
        }

        private static TagKey<Block> forgeBlockTag(String name) {
            return BlockTags.create(new ResourceLocation("forge", name));
        }
    }

    public static class Items {
        public static final TagKey<Item> PLANKS = minecraftItemTag("planks");
        public static final TagKey<Item> STONE_TOOL_MATERIAL = minecraftItemTag("stone_tool_materials");

        private static TagKey<Item> minecraftItemTag(String name) {
            return ItemTags.create(new ResourceLocation("minecraft", name));
        }
    }

}
