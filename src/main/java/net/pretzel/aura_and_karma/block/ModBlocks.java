package net.pretzel.aura_and_karma.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pretzel.aura_and_karma.AuraAndKarma;
import net.minecraft.item.Item;

public class ModBlocks {
    public static final Block SUNPLATE_BLOCK = registerBlock("sunplate_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(AuraAndKarma.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(AuraAndKarma.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        AuraAndKarma.LOGGER.info("Registering ModBlocks for " + AuraAndKarma.MOD_ID);
    }
}
