package net.pretzel.aura_and_karma;

import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.World;

public class PlayerData {
    public static float aura = 0;
    public static float karma = 0;

    public static void UpdatePlayerAura(float amount, World world, PlayerEntity player){
        aura += amount;

        // Send a packet to the client
        MinecraftServer server = world.getServer();

        PacketByteBuf data = PacketByteBufs.create();
        data.writeFloat(aura);

        ServerPlayerEntity playerEntity = server.getPlayerManager().getPlayer(player.getUuid());
        server.execute(() -> {
            ServerPlayNetworking.send(playerEntity, AuraAndKarma.AURA, data);
        });
    }

    public static void UpdatePlayerKarma(float amount, World world, PlayerEntity player){
        karma += amount;

        // Send a packet to the client
        MinecraftServer server = world.getServer();

        PacketByteBuf data = PacketByteBufs.create();
        data.writeFloat(karma);

        ServerPlayerEntity playerEntity = server.getPlayerManager().getPlayer(player.getUuid());
        server.execute(() -> {
            ServerPlayNetworking.send(playerEntity, AuraAndKarma.KARMA, data);
        });
    }
}
