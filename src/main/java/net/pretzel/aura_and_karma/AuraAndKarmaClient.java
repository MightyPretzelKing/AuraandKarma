package net.pretzel.aura_and_karma;

import  net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.text.Text;

public class AuraAndKarmaClient implements ClientModInitializer {

    public static PlayerData playerData = new PlayerData();

    @Override
    public void onInitializeClient() {
        ClientPlayNetworking.registerGlobalReceiver(AuraAndKarma.AURA, (client, handler, buf, responseSender) -> {

            playerData.aura = buf.readFloat();

            client.execute(() -> {
                client.player.sendMessage(Text.literal("Player specific aura: " + playerData.aura));
            });
        });
        ClientPlayNetworking.registerGlobalReceiver(AuraAndKarma.KARMA, (client, handler, buf, responseSender) -> {

            playerData.karma = buf.readFloat();

            client.execute(() -> {
                client.player.sendMessage(Text.literal("Player specific karma: " + playerData.karma));
            });
        });

        ClientPlayNetworking.registerGlobalReceiver(AuraAndKarma.INITIAL_SYNC, (client, handler, buf, responseSender) -> {
            playerData.aura = buf.readFloat();
            playerData.karma = buf.readFloat();

            client.execute(() -> {
                client.player.sendMessage(Text.literal("Initial specific aura: " + playerData.aura));
                client.player.sendMessage(Text.literal("Initial specific karma: " + playerData.karma));
            });
        });
    }
}
