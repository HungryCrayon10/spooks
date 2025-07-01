package net.hungry.spooks.client;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.hungry.spooks.client.datagen.SpooksAdvancements;
import net.hungry.spooks.client.datagen.SpooksRecipes;

public class SpooksDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(SpooksRecipes::new);
        pack.addProvider(SpooksAdvancements::new);

    }
}
