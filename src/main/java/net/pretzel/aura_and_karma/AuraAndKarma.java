package net.pretzel.aura_and_karma;

import net.fabricmc.api.ModInitializer;

import net.pretzel.aura_and_karma.item.ModItems;
import net.pretzel.aura_and_karma.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuraAndKarma implements ModInitializer {
	public static final String MOD_ID = "aura_and_karma";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}