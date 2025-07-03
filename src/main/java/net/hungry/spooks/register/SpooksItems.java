package net.hungry.spooks.register;

import net.hungry.spooks.items.*;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.util.Rarity;

import static net.hungry.spooks.SpooksMain.MOD_ID;
import static net.hungry.spooks.items.BloodOrange.bloodOrangeFood;
import static net.hungry.spooks.items.CrimsonCorn.crimsonCornFood;
import static net.hungry.spooks.items.DeltaThyme.deltaThymeFood;
import static net.hungry.spooks.items.GhostPeppers.ghostPepperFood;
import static net.hungry.spooks.items.Warpear.warpearFood;
import static net.hungry.spooks.items.Wasteshroom.wasteshroomFood;

public class SpooksItems {
    public static Item register(Item item, String id) {
        Identifier itemID = Identifier.of(MOD_ID, id);
        return Registry.register(Registries.ITEM, itemID, item);
    }
    public static final Item GHOST_PEPPERS = register(
            new GhostPeppers(new Item.Settings().food(ghostPepperFood).rarity(Rarity.UNCOMMON)),
            "ghost_peppers"
    );
    public static final Item CRIMSON_CORN = register(
            new CrimsonCorn(new Item.Settings().food(crimsonCornFood).rarity(Rarity.UNCOMMON)),
            "crimson_corn"
    );
    public static final Item WARPEAR = register(
            new Warpear(new Item.Settings().food(warpearFood).rarity(Rarity.UNCOMMON)),
            "warpear"
    );
    public static final Item DELTA_THYME = register(
            new DeltaThyme(new Item.Settings().food(deltaThymeFood).rarity(Rarity.UNCOMMON)),
            "delta_thyme"
    );
    public static final Item BLOOD_ORANGE = register(
            new BloodOrange(new Item.Settings().food(bloodOrangeFood).rarity(Rarity.UNCOMMON)),
            "blood_orange"
    );
    public static final Item WASTESHROOM = register(
            new Wasteshroom(new Item.Settings().food(wasteshroomFood).rarity(Rarity.UNCOMMON)),
            "wasteshroom"
    );

    public static void initialize() {
    }
}
