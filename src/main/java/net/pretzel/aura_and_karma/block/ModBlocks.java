package net.pretzel.aura_and_karma.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.pretzel.aura_and_karma.AuraAndKarma;
import net.minecraft.item.Item;

public class ModBlocks {
    public static final Block AERIALITE_BLOCK = registerBlock("aerialite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block AERIALITE_ORE = registerBlock("aerialite_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(4, 8), FabricBlockSettings.copyOf(Blocks.STONE).strength(30f).resistance(6f)));

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
