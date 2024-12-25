// Package
package net.bleckwolf.testmodpack.item;

// Imports

import net.bleckwolf.testmodpack.TestModpack;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

// Class
public class ModItemGroups {

    // Test Item Group
    public static final ItemGroup GARNET_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(TestModpack.MOD_ID, "garnet_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.GARNET))
                    .displayName(Text.translatable("Garnet"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.GARNET);
                        entries.add(ModItems.RAW_GARNET);
                    }).build()
    );


    // Register method
    public static void registerItemGroups() {
        TestModpack.LOGGER.info("Registering Item Groups for " + TestModpack.MOD_ID);
    }
}
