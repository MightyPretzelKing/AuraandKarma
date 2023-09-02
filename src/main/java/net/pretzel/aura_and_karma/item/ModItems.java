package net.pretzel.aura_and_karma.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.pretzel.aura_and_karma.AuraAndKarma;
import net.minecraft.item.Item;
import net.pretzel.aura_and_karma.block.ModBlocks;

public class ModItems {

    public static final Item SUNPLATE_INGOT = registerItem("sunplate_ingot", new Item(new FabricItemSettings()));
    public static final Item STARDUST = registerItem("stardust", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(SUNPLATE_INGOT);
        entries.add(STARDUST);
        entries.add(ModBlocks.SUNPLATE_BLOCK);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AuraAndKarma.MOD_ID, name), item);
    }

    public static void registerModItems() {
        AuraAndKarma.LOGGER.info("Registering Mod Items for " + AuraAndKarma.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
