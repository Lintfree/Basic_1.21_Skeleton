package example.examplemod.worldgen

import example.examplemod.ExampleMod
import net.minecraft.core.Holder
import net.minecraft.core.HolderGetter
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.*

object ExamplePlacedFeatures {


	val EXAMPLE_ORE_PLACED_KEY: ResourceKey<PlacedFeature> = registerKey("alexandrite_ore_placed")
	/*
	val NETHER_ALEXANDRITE_ORE_PLACED_KEY: ResourceKey<PlacedFeature> =
		ModPlacedFeatures.registerKey("nether_alexandrite_ore_placed")
	val END_ALEXANDRITE_ORE_PLACED_KEY: ResourceKey<PlacedFeature> =
		ModPlacedFeatures.registerKey("end_alexandrite_ore_placed")
	val WALNUT_PLACED_KEY: ResourceKey<PlacedFeature> = ModPlacedFeatures.registerKey("walnut_placed")
	val SNAPDRAGON_PLACED_KEY: ResourceKey<PlacedFeature> = ModPlacedFeatures.registerKey("snapdragon_placed")
	val ALEXANDRITE_GEODE_PLACED_KEY: ResourceKey<PlacedFeature> =
		ModPlacedFeatures.registerKey("alexandrite_geode_placed")
*/

	fun bootstrap(context: BootstrapContext<PlacedFeature>) {
		val configuredFeatures: HolderGetter<ConfiguredFeature<*, *>> = context.lookup(Registries.CONFIGURED_FEATURE)



		ExamplePlacedFeatures.register(
			context, EXAMPLE_ORE_PLACED_KEY,
			configuredFeatures.getOrThrow(ExampleConfiguredFeatures.OVERWORLD_EXAMPLE_ORE_KEY),
			ExampleOrePlacement.commonOrePlacement(
				12,
				HeightRangePlacement.uniform(VerticalAnchor.absolute(- 64), VerticalAnchor.absolute(80))
			)
		)
	}

		/*
		ModPlacedFeatures.register(
			context,
			ModPlacedFeatures.NETHER_ALEXANDRITE_ORE_PLACED_KEY,
			configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_ALEXANDRITE_ORE_KEY),
			ModOrePlacement.commonOrePlacement(
				9,
				HeightRangePlacement.uniform(VerticalAnchor.absolute(- 64), VerticalAnchor.absolute(80))
			)
		)
		ModPlacedFeatures.register(
			context,
			ModPlacedFeatures.END_ALEXANDRITE_ORE_PLACED_KEY,
			configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ALEXANDRITE_ORE_KEY),
			ModOrePlacement.commonOrePlacement(
				7,
				HeightRangePlacement.uniform(VerticalAnchor.absolute(- 64), VerticalAnchor.absolute(80))
			)
		)

		ModPlacedFeatures.register(
			context,
			ModPlacedFeatures.WALNUT_PLACED_KEY,
			configuredFeatures.getOrThrow(ModConfiguredFeatures.WALNUT_KEY),
			VegetationPlacements.treePlacement(
				PlacementUtils.countExtra(3, 0.1f, 2),
				ModBlocks.WALNUT_SAPLING.get()
			)
		)

		ModPlacedFeatures.register(
			context,
			ModPlacedFeatures.SNAPDRAGON_PLACED_KEY,
			configuredFeatures.getOrThrow(ModConfiguredFeatures.SNAPDRAGON_KEY),
			java.util.List.of<PlacementModifier>(
				RarityFilter.onAverageOnceEvery(16),
				InSquarePlacement.spread(),
				PlacementUtils.HEIGHTMAP,
				BiomeFilter.biome()
			)
		)


		ModPlacedFeatures.register(
			context,
			ModPlacedFeatures.ALEXANDRITE_GEODE_PLACED_KEY,
			configuredFeatures.getOrThrow(ModConfiguredFeatures.ALEXANDRITE_GEODE_KEY),
			java.util.List.of<PlacementModifier>(
				RarityFilter.onAverageOnceEvery(50), InSquarePlacement.spread(),
				HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(6), VerticalAnchor.absolute(50)),
				BiomeFilter.biome()
			)
		)
	}
*/

	private fun registerKey(name: String): ResourceKey<PlacedFeature> {
		return ResourceKey.create<PlacedFeature>(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name))
	}

	private fun register(
		context: BootstrapContext<PlacedFeature>,
		key: ResourceKey<PlacedFeature>,
		configuration: Holder<ConfiguredFeature<*, *>>,
		modifiers: List<PlacementModifier>
	) {
		context.register(key, PlacedFeature(configuration, java.util.List.copyOf(modifiers)))
	}
}