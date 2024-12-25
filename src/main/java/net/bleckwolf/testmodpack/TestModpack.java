// Package
package net.bleckwolf.testmodpack;

// Imports
import net.bleckwolf.testmodpack.item.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestModpack implements ModInitializer {
	// Constants should be uppercase by Java convention
	public static final String MOD_ID = "testmodpack";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Fixed method name to match ModItems class
		ModItems.registerModItems();

		LOGGER.info("TestModpack initialization completed!");
	}
}