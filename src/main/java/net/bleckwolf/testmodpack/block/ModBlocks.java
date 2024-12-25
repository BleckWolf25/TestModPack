package net.bleckwolf.testmodpack.block;

import net.bleckwolf.testmodpack.TestModpack;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    // RAW GARNET BLOCK REGISTRATION
    public static final Block RAW_GARNET_BLOCK = registerBlock("raw_garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(3.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)
            )
    );

    // GARNET BLOCK REGISTRATION
    public static final Block GARNET_BLOCK = registerBlock("garnet_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4.0f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.AMETHYST_BLOCK)
            )
    );

    // Helper method for block registration - returns Block for chaining
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TestModpack.MOD_ID, name), block);
    }

    // Helper method for BlockItem registration
    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TestModpack.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    // Initialize block registration
    public static void registerModBlocks() {
        TestModpack.LOGGER.info("Registering Mod Blocks for " + TestModpack.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RAW_GARNET_BLOCK);
            entries.add(ModBlocks.GARNET_BLOCK);
        });
    }
}