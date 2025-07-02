package net.hungry.spooks.register;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.hungry.spooks.SpooksMain.MOD_ID;

public class SpooksGroups {
    public static final RegistryKey<ItemGroup> SPOOKS_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(MOD_ID, "spooks"));
    public static final ItemGroup SPOOKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SpooksItems.GHOST_PEPPERS))
            .displayName(Text.translatable("itemGroup.spooks"))
            .build();

    public static void initialize() {
        Registry.register(Registries.ITEM_GROUP, SPOOKS_KEY, SPOOKS);
        ItemGroupEvents.modifyEntriesEvent(SPOOKS_KEY).register(itemGroup -> {
            itemGroup.add(SpooksItems.GHOST_PEPPERS);
            itemGroup.add(SpooksItems.CRIMSON_CORN);
            itemGroup.add(SpooksItems.WARPEAR);
            itemGroup.add(SpooksItems.BLOOD_ORANGE);
            itemGroup.add(SpooksItems.DELTA_THYME);
            itemGroup.add(SpooksBlocks.HOLLOWED_GROUND.asItem());
        }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(itemGroup -> {
            itemGroup.addAfter(Items.GLOW_BERRIES, SpooksItems.GHOST_PEPPERS);
            itemGroup.addAfter(Items.POISONOUS_POTATO, SpooksItems.CRIMSON_CORN);
            itemGroup.addAfter(Items.CHORUS_FRUIT, SpooksItems.WARPEAR);
            itemGroup.addAfter(Items.ENCHANTED_GOLDEN_APPLE, SpooksItems.BLOOD_ORANGE);
        }
        );
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(itemGroup -> {
            itemGroup.addAfter(Items.CRIMSON_ROOTS, SpooksItems.DELTA_THYME);
        }
        );
    }
}
