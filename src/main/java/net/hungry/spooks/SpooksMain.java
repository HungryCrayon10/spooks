package net.hungry.spooks;

import net.fabricmc.api.ModInitializer;
import net.hungry.spooks.register.SpooksGroups;
import net.hungry.spooks.register.SpooksItems;
import net.hungry.spooks.register.SpooksBlocks;

public class SpooksMain implements ModInitializer {
    public static final String MOD_ID = "spooks";

    @Override
    public void onInitialize() {
        SpooksItems.initialize();
        SpooksBlocks.initialize();
        SpooksGroups.initialize();
    }
}
