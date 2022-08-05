package net.juder.elementalswords.block;

import com.google.common.base.Supplier;

import net.juder.elementalswords.ElementalSwords;
import net.juder.elementalswords.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ElementalSwords.MOD_ID);

    public static final RegistryObject<Block> NATURE_WOOD = registerBlock("nature_wood", () -> new Block(BlockBehaviour.Properties.of(Material.WOOD).requiresCorrectToolForDrops().strength(5, 5)), CreativeModeTab.TAB_DECORATIONS);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> blockToReturn = BLOCKS.register(name, block);
        registerBlockItem(name, blockToReturn, tab);
        return blockToReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus bus) {
        BLOCKS.register(bus);
    }
}
