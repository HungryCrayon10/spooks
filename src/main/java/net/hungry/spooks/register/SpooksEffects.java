package net.hungry.spooks.register;

import net.hungry.spooks.effects.WastedEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import static net.hungry.spooks.SpooksMain.MOD_ID;

public class SpooksEffects {
    public static final RegistryEntry<StatusEffect> WASTED;

    static {
        WASTED = Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID, "wasted"), new WastedEffect());
    }

    public static void initialize() {
    }
}