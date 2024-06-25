package net.pretzel.aura_and_karma;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.block.Blocks;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import net.pretzel.aura_and_karma.item.ModItemGroups;
import net.pretzel.aura_and_karma.item.ModItems;
import net.pretzel.aura_and_karma.block.ModBlocks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuraAndKarma implements ModInitializer {
	public static final String MOD_ID = "aura_and_karma";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static final Identifier AURA = new Identifier(MOD_ID, "aura");
	public static final Identifier KARMA = new Identifier(MOD_ID, "karma");
	public static final Identifier INITIAL_SYNC = new Identifier(MOD_ID, "initial_sync");

	@Override
	public void onInitialize() {

		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			PlayerData playerState = StateSaverAndLoader.getPlayerState(handler.getPlayer());
			PacketByteBuf data = PacketByteBufs.create();
			data.writeFloat(playerState.aura);
			server.execute(() -> {
				ServerPlayNetworking.send(handler.getPlayer(), INITIAL_SYNC, data);
			});
		});

		PlayerBlockBreakEvents.AFTER.register((world, player, pos, state, entity) -> {
			if (state.getBlock() == Blocks.GRASS_BLOCK || state.getBlock() == Blocks.DIRT) {

				StateSaverAndLoader.getPlayerState(player).UpdatePlayerAura(1, world, player);
			}
		});




		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}