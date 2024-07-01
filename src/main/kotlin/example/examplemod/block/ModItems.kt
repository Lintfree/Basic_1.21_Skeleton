package example.examplemod.block

import example.examplemod.ExampleMod
import example.examplemod.block.ModBlocks.EXAMPLE_BLOCK
import example.examplemod.block.ModBlocks.EXAMPLE_ORE
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister

object ModItems {
	val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(ExampleMod.mod_id)

	/** If you get an "overload resolution ambiguity" error, include the arrow at the start of the closure.
	 *  Register items (not placeable in the world)
	 *  Register blocks (placeable in the world) as items. Take note how the block is registered as an item
	 */
	val EXAMPLE_ITEM: DeferredItem<Item> = ITEMS.register("example_item") { ->
		Item(Item.Properties().stacksTo(64))
	}

	val EXAMPLE_BLOCK_ITEM: DeferredItem<BlockItem> = ITEMS.register("example_block") { ->
		BlockItem(EXAMPLE_BLOCK.get(), Item.Properties().stacksTo(64))
	}

	val EXAMPLE_ORE_ITEM: DeferredItem<BlockItem> = ITEMS.register("example_ore") { ->
		BlockItem(EXAMPLE_ORE.get(), Item.Properties().stacksTo(64))
	}
}