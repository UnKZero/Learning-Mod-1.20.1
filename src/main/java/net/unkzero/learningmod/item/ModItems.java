package net.unkzero.learningmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.unkzero.learningmod.LearningMod;

public class ModItems {
    //Making An Items And Registering Them
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    // Creating An Entries Method
    private  static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries){
        entries.add(RUBY); // Adding the Ruby Item to the Entries
        entries.add(RAW_RUBY);
    }

    private static Item registerItem(String name, Item item){

        return Registry.register(Registries.ITEM, new Identifier(LearningMod.MOD_ID, name), item);
    }

    public static void  registerModItems(){
        LearningMod.LOGGER.info("Registering Mod Items For " + LearningMod.MOD_ID);// Just A Messaging to Registering Items using ModID
        //Adding the Entry Method to the Creative Menu Ingredients Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
