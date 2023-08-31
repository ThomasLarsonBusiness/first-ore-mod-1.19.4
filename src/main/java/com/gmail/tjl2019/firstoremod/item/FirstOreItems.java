package com.gmail.tjl2019.firstoremod.item;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.gmail.tjl2019.firstoremod.item.CustomItems.BattleHammerItem;
import com.gmail.tjl2019.firstoremod.item.CustomItems.ScytheItem;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.List;

public class FirstOreItems {

    // Utility Functions
    private static final Logger log = LogUtils.getLogger();

    // Deferred Register for Items
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "firstoremod");

    // Item Properties
    //private static final Item.Properties SILVER_TOOL_PROPERTIES =
            //new Item.Properties().durability(200);

    // Items
    public static final RegistryObject<Item> SILVER_INGOT = ITEMS.register("silver_ingot",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_SILVER = ITEMS.register("raw_silver",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe",
            () -> new AxeItem(FirstOreToolTiers.SILVER,
                    6, -3.0f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe",
            () -> new PickaxeItem(FirstOreToolTiers.SILVER,
                    6, -3.5f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel",
            () -> new ShovelItem(FirstOreToolTiers.SILVER,
                    3, -0.5f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_SWORD = ITEMS.register("silver_sword",
            () -> new SwordItem(FirstOreToolTiers.SILVER,
                    8, -1.5f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe",
            () -> new HoeItem(FirstOreToolTiers.SILVER,
                    1, -2.0f, new Item.Properties()));

    // Scythe Items
    public static final RegistryObject<Item> WOODEN_SCYTHE = ITEMS.register("wooden_scythe",
            () -> new ScytheItem(Tiers.WOOD, new Item.Properties()));

    public static final RegistryObject<Item> STONE_SCYTHE = ITEMS.register("stone_scythe",
            () -> new ScytheItem(Tiers.STONE, new Item.Properties()));

    public static final RegistryObject<Item> IRON_SCYTHE = ITEMS.register("iron_scythe",
            () -> new ScytheItem(Tiers.IRON, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_SCYTHE = ITEMS.register("silver_scythe",
            () -> new ScytheItem(FirstOreToolTiers.SILVER, new Item.Properties()));

    public static final RegistryObject<Item> GOLD_SCYTHE = ITEMS.register("gold_scythe",
            () -> new ScytheItem(Tiers.GOLD, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_SCYTHE = ITEMS.register("diamond_scythe",
            () -> new ScytheItem(Tiers.DIAMOND, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_SCYTHE = ITEMS.register("netherite_scythe",
            () -> new ScytheItem(Tiers.NETHERITE, new Item.Properties()));

    // Battle Hammers
    public static final RegistryObject<Item> WOODEN_HAMMER = ITEMS.register("wooden_hammer",
            () -> new BattleHammerItem(Tiers.WOOD, 12, -3.5f, new Item.Properties()));

    public static final RegistryObject<Item> STONE_HAMMER = ITEMS.register("stone_hammer",
            () -> new BattleHammerItem(Tiers.STONE, 12, -3.5f, new Item.Properties()));

    public static final RegistryObject<Item> IRON_HAMMER = ITEMS.register("iron_hammer",
            () -> new BattleHammerItem(Tiers.IRON, 12, -3.5f, new Item.Properties()));

    public static final RegistryObject<Item> SILVER_HAMMER = ITEMS.register("silver_hammer",
            () -> new BattleHammerItem(FirstOreToolTiers.SILVER, 12, -3.5f, new Item.Properties()));

    public static final RegistryObject<Item> GOLD_HAMMER = ITEMS.register("gold_hammer",
            () -> new BattleHammerItem(Tiers.GOLD, 12, -3.5f, new Item.Properties()));

    public static final RegistryObject<Item> DIAMOND_HAMMER = ITEMS.register("diamond_hammer",
            () -> new BattleHammerItem(Tiers.DIAMOND, 12, -3.5f, new Item.Properties()));

    public static final RegistryObject<Item> NETHERITE_HAMMER = ITEMS.register("netherite_hammer",
            () -> new BattleHammerItem(Tiers.NETHERITE, 12, -3.5f, new Item.Properties()));

    // Register Event For In The FirstOreMod Class
    public static void register(IEventBus event) {
        log.info("Registering Items");
        ITEMS.register(event);
    }

}
