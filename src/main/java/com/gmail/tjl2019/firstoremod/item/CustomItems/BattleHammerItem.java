package com.gmail.tjl2019.firstoremod.item.CustomItems;

import com.gmail.tjl2019.firstoremod.FirstOreMod;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import org.slf4j.Logger;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


@Mod.EventBusSubscriber(modid = FirstOreMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class BattleHammerItem extends TieredItem implements Vanishable {
    private static final Logger logger = LogUtils.getLogger();

    // Fields
    private final Tier tier;
    private final float attackDamage;
    private final Multimap<Attribute, AttributeModifier> defaultModifiers;

    // Constructors
    public BattleHammerItem(Tier _tier, int attackBase, float attackSpeed, Item.Properties properties) {
        super(_tier, properties);
        this.tier = _tier;
        this.attackDamage = (float)attackBase + this.tier.getAttackDamageBonus();
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
        builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Weapon modifier", (double)this.attackDamage, AttributeModifier.Operation.ADDITION));
        builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Weapon modifier", (double)attackSpeed, AttributeModifier.Operation.ADDITION));
        this.defaultModifiers = builder.build();
    }

    // Methods
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        return 0.0f;
    }

    @SubscribeEvent
    // Find a way to prevent this from occuring unless fully charged
    public static void handleAttackEntity(AttackEntityEvent event) {
        LivingEntity entity = (LivingEntity)event.getTarget();
        entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN,
                200, 3, false, true, true));
    }

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot hand) {
        return hand == EquipmentSlot.MAINHAND ? this.defaultModifiers : super.getDefaultAttributeModifiers(hand);
    }
}
