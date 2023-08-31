package com.gmail.tjl2019.firstoremod.datagen;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.gmail.tjl2019.firstoremod.block.FirstOreBlocks;
import com.gmail.tjl2019.firstoremod.item.FirstOreItems;
import com.gmail.tjl2019.firstoremod.util.FirstOreModTags;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Consumer;

public class FirstOreRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public FirstOreRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        // Silver Block Recipes
        solidBlockRecipe(FirstOreBlocks.SILVER_BLOCK, FirstOreItems.SILVER_INGOT, consumer
                , "silver_block_from_ingot");
        blockToSingleItem(FirstOreItems.SILVER_INGOT, FirstOreBlocks.SILVER_BLOCK, consumer
                , "silver_ingot_from_block");

        solidWithUniqueCenterBlockRecipe(FirstOreBlocks.LAMP_BLOCK, FirstOreItems.SILVER_INGOT.get(),
                Blocks.DAYLIGHT_DETECTOR, consumer, "silver_ingot_from_block");

        // Smelting Recipes
        smeltFromRawOre(FirstOreItems.SILVER_INGOT, FirstOreItems.RAW_SILVER, consumer,
                "silver_ingot");

        // Silver Tools
        axeRecipeViaItem(FirstOreItems.SILVER_AXE, FirstOreItems.SILVER_INGOT, consumer);
        hoeRecipeViaItem(FirstOreItems.SILVER_HOE, FirstOreItems.SILVER_INGOT, consumer);
        pickaxeRecipeViaItem(FirstOreItems.SILVER_PICKAXE, FirstOreItems.SILVER_INGOT, consumer);
        shovelRecipeViaItem(FirstOreItems.SILVER_SHOVEL, FirstOreItems.SILVER_INGOT, consumer);
        swordRecipeViaItem(FirstOreItems.SILVER_SWORD, FirstOreItems.SILVER_INGOT, consumer);

        // Scythe Tools
        scytheRecipeViaTag(FirstOreItems.WOODEN_SCYTHE, FirstOreModTags.Items.PLANKS, consumer);
        scytheRecipeViaTag(FirstOreItems.STONE_SCYTHE, FirstOreModTags.Items.STONE_TOOL_MATERIAL, consumer);
        scytheRecipeViaItem(FirstOreItems.IRON_SCYTHE, Items.IRON_INGOT, consumer);
        scytheRecipeViaItem(FirstOreItems.GOLD_SCYTHE, Items.GOLD_INGOT, consumer);
        scytheRecipeViaItem(FirstOreItems.SILVER_SCYTHE, FirstOreItems.SILVER_INGOT.get(), consumer);
        scytheRecipeViaItem(FirstOreItems.DIAMOND_SCYTHE, Items.DIAMOND, consumer);

        // Hammer Tools
        hammerRecipeViaTag(FirstOreItems.WOODEN_HAMMER, FirstOreModTags.Items.PLANKS, consumer);
        hammerRecipeViaTag(FirstOreItems.STONE_HAMMER, FirstOreModTags.Items.STONE_TOOL_MATERIAL, consumer);
        hammerRecipeViaItem(FirstOreItems.IRON_HAMMER, Items.IRON_INGOT, consumer);
        hammerRecipeViaItem(FirstOreItems.SILVER_HAMMER, FirstOreItems.SILVER_INGOT.get(), consumer);
        hammerRecipeViaItem(FirstOreItems.GOLD_HAMMER, Items.GOLD_INGOT, consumer);
        hammerRecipeViaItem(FirstOreItems.DIAMOND_HAMMER, Items.DIAMOND, consumer);

        // Silver Lamp Recipe

    }

    // Recipe Patterns
    // Solid Blocks
    private void solidBlockRecipe(RegistryObject<Block> outputBlock, RegistryObject<Item> inputItem,
                                  Consumer<FinishedRecipe> consumer, String filename) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, outputBlock.get())
                .define('S', inputItem.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem.get()).build()))
                .save(consumer, "firstoremod:blocks/" + filename);
    }

    private void blockToSingleItem(RegistryObject<Item> outputItem, RegistryObject<Block> inputBlock,
                                   Consumer<FinishedRecipe> consumer, String filename) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, outputItem.get(), 9)
                .requires(inputBlock.get())
                .unlockedBy("has_necessary_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputBlock.get()).build()))
                .save(consumer, "firstoremod:items/" + filename);
    }

    private void solidWithUniqueCenterBlockRecipe(RegistryObject<Block> outputBlock, ItemLike borderItem,
                                  Block centerBlock, Consumer<FinishedRecipe> consumer, String filename) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, outputBlock.get())
                .define('S', borderItem)
                .define('#', centerBlock)
                .pattern("SSS")
                .pattern("S#S")
                .pattern("SSS")
                .unlockedBy("has_necessary_center", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(centerBlock).build()))
                .save(consumer, "firstoremod:blocks/" + filename);
    }

    // Smelting
    private void smeltFromRawOre(RegistryObject<Item> outputItem, RegistryObject<Item> inputItem,
                                 Consumer<FinishedRecipe> consumer, String filename) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(inputItem.get()), RecipeCategory.MISC, outputItem.get(),
                0.5f, 150)
                .unlockedBy("has_necessary_ingredient", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem.get()).build()))
                .save(consumer, "firstoremod:items/" + filename + "_from_smelting");

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(inputItem.get()), RecipeCategory.MISC, outputItem.get(),
                        0.5f, 75)
                .unlockedBy("has_necessary_ingredient", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem.get()).build()))
                .save(consumer, "firstoremod:items/" + filename + "_from_blasting");
    }

    // Tool Crafting Shapes
    private void axeRecipeViaItem(RegistryObject<Item> outputItem, RegistryObject<Item> inputItem,
                           Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputItem.get())
                .pattern("##")
                .pattern("#S")
                .pattern(" S")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem.get()).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }

    private void hoeRecipeViaItem(RegistryObject<Item> outputItem, RegistryObject<Item> inputItem,
                                  Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputItem.get())
                .pattern("##")
                .pattern(" S")
                .pattern(" S")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem.get()).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }

    private void pickaxeRecipeViaItem(RegistryObject<Item> outputItem, RegistryObject<Item> inputItem,
                                  Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputItem.get())
                .pattern("###")
                .pattern(" S ")
                .pattern(" S ")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem.get()).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }

    private void shovelRecipeViaItem(RegistryObject<Item> outputItem, RegistryObject<Item> inputItem,
                                  Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputItem.get())
                .pattern("#")
                .pattern("S")
                .pattern("S")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem.get()).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }

    private void swordRecipeViaItem(RegistryObject<Item> outputItem, RegistryObject<Item> inputItem,
                                     Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputItem.get())
                .pattern("#")
                .pattern("#")
                .pattern("S")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem.get()).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }

    private void scytheRecipeViaItem(RegistryObject<Item> outputItem, ItemLike inputItem,
                                    Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputItem)
                .pattern("## ")
                .pattern(" S#")
                .pattern(" S ")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }

    private void scytheRecipeViaTag(RegistryObject<Item> outputItem, TagKey<Item> inputTag,
                                     Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputTag)
                .pattern("## ")
                .pattern(" S#")
                .pattern(" S ")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputTag).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }

    private void hammerRecipeViaItem(RegistryObject<Item> outputItem, ItemLike inputItem,
                                     Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputItem)
                .pattern("###")
                .pattern("#S#")
                .pattern(" S ")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputItem).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }

    private void hammerRecipeViaTag(RegistryObject<Item> outputItem, TagKey<Item> inputTag,
                                    Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, outputItem.get())
                .define('S', Items.STICK)
                .define('#', inputTag)
                .pattern("###")
                .pattern("#S#")
                .pattern(" S ")
                .unlockedBy("has_necessary_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(inputTag).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem.get()));
    }



    /* WILL ONLY WORK IN 1.20
    private void netheriteUpgradeRecipe(Item outputItem, Item inputItem, Consumer<FinishedRecipe> consumer) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.EMPTY, Ingredient.of(inputItem),
                Ingredient.of(Items.NETHERITE_INGOT), RecipeCategory.TOOLS, outputItem)
                .unlocks("has_netherite_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.NETHERITE_INGOT).build()))
                .save(consumer, "firstoremod:items/" + getItemName(outputItem) + "_by_smithing");
    }
    */
}
