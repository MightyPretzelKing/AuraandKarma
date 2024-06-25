package net.pretzel.aura_and_karma.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.pretzel.aura_and_karma.AuraAndKarma;
import net.pretzel.aura_and_karma.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup A_K_GROUP = Registry.register(Registries.ITEM_GROUP, new Identifier(AuraAndKarma.MOD_ID, "a_k"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.a_k"))
                    .icon(() -> new ItemStack(ModItems.AERIALITE_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.AERIALITE_INGOT);
                        entries.add(ModItems.RAW_AERIALTE);
                        entries.add(ModBlocks.AERIALITE_ORE);
                        entries.add(ModBlocks.AERIALITE_BLOCK);
                    }).build());
    public static void registerItemGroups(){
        AuraAndKarma.LOGGER.info("Registering Item Groups for" + AuraAndKarma.MOD_ID);
    }
}
