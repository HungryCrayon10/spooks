package net.hungry.spooks.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class WastedEffect extends StatusEffect {
    public WastedEffect() {
        super(StatusEffectCategory.HARMFUL, 0xe701313);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity playerEntity) {
            playerEntity.addExhaustion(0.015F * (amplifier + 1));
        }
        return true;
    }
}