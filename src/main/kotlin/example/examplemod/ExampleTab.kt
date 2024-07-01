package example.examplemod

import example.examplemod.block.ModItems.EXAMPLE_BLOCK_ITEM
import example.examplemod.block.ModItems.EXAMPLE_ITEM
import example.examplemod.block.ModItems.EXAMPLE_ORE_ITEM
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.CreativeModeTabs
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister

object ExampleTab {
	val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> = DeferredRegister.create(
		Registries.CREATIVE_MODE_TAB,
		ExampleMod.mod_id
	)

	// Creates a creative tab with the id "examplemod:example_tab" for the example item, that is placed after the combat tab
	// If you get an "overload resolution ambiguity" error, include the arrow at the start of the closure.
	val ExampleTab: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_MODE_TABS.register("example_tab") { ->
		CreativeModeTab.builder()
			.title(Component.translatable("Example"))
			.withTabsBefore(CreativeModeTabs.COMBAT)
			.icon{ EXAMPLE_ITEM.get().defaultInstance }
			.displayItems { _: ItemDisplayParameters?, output: CreativeModeTab.Output ->
				output.accept(EXAMPLE_ITEM.get())
				output.accept(EXAMPLE_BLOCK_ITEM.get())
				output.accept(EXAMPLE_ORE_ITEM.get())
			}.build()
	}
}