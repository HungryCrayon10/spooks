package net.hungry.spooks.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.hungry.spooks.register.SpooksBlocks;
import net.hungry.spooks.register.SpooksItems;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.ChangedDimensionCriterion;
import net.minecraft.advancement.criterion.ConsumeItemCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import static net.hungry.spooks.SpooksMain.MOD_ID;

public class SpooksAdvancements extends FabricAdvancementProvider {
    public SpooksAdvancements(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        AdvancementEntry enterNether = Advancement.Builder.create()
                .display(
                        Items.OBSIDIAN,
                        Text.literal("Spooks"),
                        Text.literal("Enter the Nether to begin the Spooks journey"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        true,
                        false,
                        false
                )
                .criterion("enter_nether", ChangedDimensionCriterion.Conditions.to(World.NETHER))
                .build(consumer, MOD_ID + "/enter_nether");

        AdvancementEntry acquireGhostPeppers = Advancement.Builder.create()
                .display(
                        SpooksItems.GHOST_PEPPERS,
                        Text.literal("Ghastly Heat"),
                        Text.literal("Acquire Ghost Peppers, a plant that grows on soul soil"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_peppers", InventoryChangedCriterion.Conditions.items(SpooksItems.GHOST_PEPPERS))
                .parent(enterNether)
                .build(consumer, MOD_ID + "/acquire_ghost_peppers");

        AdvancementEntry acquireCrimsonCorn = Advancement.Builder.create()
                .display(
                        SpooksItems.CRIMSON_CORN,
                        Text.literal("I LOVE Corn!"),
                        Text.literal("Acquire Crimson Corn, a nylium crop in the Crimson Forest"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_corn", InventoryChangedCriterion.Conditions.items(SpooksItems.CRIMSON_CORN))
                .parent(enterNether)
                .build(consumer, MOD_ID + "/acquire_crimson_corn");

        AdvancementEntry acquireWarpear = Advancement.Builder.create()
                .display(
                        SpooksItems.WARPEAR,
                        Text.literal("Chorus Fruit Lite"),
                        Text.literal("Acquire a Warpear, found on trees in the Warped Forest"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_pear", InventoryChangedCriterion.Conditions.items(SpooksItems.WARPEAR))
                .parent(enterNether)
                .build(consumer, MOD_ID + "/acquire_warpear");

        AdvancementEntry acquireBloodOrange = Advancement.Builder.create()
                .display(
                        SpooksItems.BLOOD_ORANGE,
                        Text.literal("Annoying"),
                        Text.literal("Acquire a Blood Orange, found somewhere"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_orange", InventoryChangedCriterion.Conditions.items(SpooksItems.BLOOD_ORANGE))
                .parent(enterNether)
                .build(consumer, MOD_ID + "/acquire_blood_orange");

        AdvancementEntry acquireDeltaThyme = Advancement.Builder.create()
                .display(
                        SpooksItems.DELTA_THYME,
                        Text.literal("Programming Joke"),
                        Text.literal("Acquire Delta Thyme, a surface-growth herb in Basalt Deltas"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_thyme", InventoryChangedCriterion.Conditions.items(SpooksItems.DELTA_THYME))
                .parent(enterNether)
                .build(consumer, MOD_ID + "/acquire_delta_thyme");

        AdvancementEntry eatGhostPeppers = Advancement.Builder.create()
                .display(
                        SpooksItems.GHOST_PEPPERS,
                        Text.literal("Spirit Snack"),
                        Text.literal("Disappear for a very brief period by eating ghost peppers"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion("eat_ghost_peppers", ConsumeItemCriterion.Conditions.item(SpooksItems.GHOST_PEPPERS))
                .parent(acquireGhostPeppers)
                .build(consumer, MOD_ID + "/eat_ghost_peppers");

        AdvancementEntry eatCrimsonCorn = Advancement.Builder.create()
                .display(
                        SpooksItems.CRIMSON_CORN,
                        Text.literal("Heartburn"),
                        Text.literal("Become briefly fire resistant by eating crimson corn"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion("eat_crimson_corn", ConsumeItemCriterion.Conditions.item(SpooksItems.CRIMSON_CORN))
                .parent(acquireCrimsonCorn)
                .build(consumer, MOD_ID + "/eat_crimson_corn");

        AdvancementEntry eatWarpear = Advancement.Builder.create()
                .display(
                        SpooksItems.WARPEAR,
                        Text.literal("Barely Even Moved"),
                        Text.literal("Teleport an extremely small distance by eating a warpear"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion("eat_warpear", ConsumeItemCriterion.Conditions.item(SpooksItems.WARPEAR))
                .parent(acquireWarpear)
                .build(consumer, MOD_ID + "/eat_warpear");

        AdvancementEntry eatBloodOrange = Advancement.Builder.create()
                .display(
                        SpooksItems.BLOOD_ORANGE,
                        Text.literal("Bloodlust"),
                        Text.literal("Become stronger for short time by eating a blood orange"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion("eat_blood_orange", ConsumeItemCriterion.Conditions.item(SpooksItems.BLOOD_ORANGE))
                .parent(acquireBloodOrange)
                .build(consumer, MOD_ID + "/eat_blood_orange");

        AdvancementEntry eatDeltaThyme = Advancement.Builder.create()
                .display(
                        SpooksItems.DELTA_THYME,
                        Text.literal("I Hate Seasoning"),
                        Text.literal("Eat delta thyme on its own for negligent nutrition"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion("eat_delta_thyme", ConsumeItemCriterion.Conditions.item(SpooksItems.DELTA_THYME))
                .parent(acquireDeltaThyme)
                .build(consumer, MOD_ID + "/eat_delta_thyme");

        AdvancementEntry acquireDrainedSoil = Advancement.Builder.create()
                .display(
                        SpooksBlocks.HOLLOWED_GROUND.asItem(),
                        Text.literal("Soulless"),
                        Text.literal("Ghost peppers drain the souls out of soul soil as they grow"),
                        Identifier.ofVanilla("textures/gui/advancements/backgrounds/nether.png"),
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion("got_drained_soil", InventoryChangedCriterion.Conditions.items(SpooksBlocks.HOLLOWED_GROUND.asItem()))
                .parent(acquireGhostPeppers)
                .build(consumer, MOD_ID + "/acquire_drained_soil");


    }
}
