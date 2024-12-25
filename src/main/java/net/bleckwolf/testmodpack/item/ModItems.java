// Packages
package net.bleckwolf.testmodpack.item;

//Imports
import net.bleckwolf.testmodpack.TestModpack;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

// Main class
public class ModItems {

    // Register first item
    public static final Item RAW_GARNET = registerItem("raw_garnet", new Item(new Item.Settings()));
    public static final Item GARNET = registerItem("garnet", new Item(new Item.Settings()));

    // Helper to register mod Items
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TestModpack.MOD_ID, name), item);
    }

    // Fixed method name to follow Java conventions
    public static void registerModItems() {
        TestModpack.LOGGER.info("Registering Mod items for " + TestModpack.MOD_ID);

        addItemsToItemGroup();
    }

    // Separated item group registration for better organization
    private static void addItemsToItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAW_GARNET);
            entries.add(GARNET);
        });
    }
}
