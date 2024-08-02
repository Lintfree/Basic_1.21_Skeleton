package example.examplemod.worldgen

import example.examplemod.ExampleMod
import net.minecraft.core.HolderGetter
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.common.world.BiomeModifiers
import net.neoforged.neoforge.registries.NeoForgeRegistries

object ExampleBiomeModifiers {


	private val ADD_EXAMPLE_ORE: ResourceKey<BiomeModifier?> = registerKey("add_example_ore")
	/*
	val ADD_NETHER_ALEXANDRITE_ORE: ResourceKey<BiomeModifier> = registerKey("add_nether_alexandrite_ore")
	val ADD_END_ALEXANDRITE_ORE: ResourceKey<BiomeModifier> = registerKey("add_end_alexandrite_ore")
	val ADD_SNAPDRAGON: ResourceKey<BiomeModifier> = registerKey("add_snapdragon")
	val ADD_TREE_WALNUT: ResourceKey<BiomeModifier> = registerKey("add_tree_walnut")
	val SPAWN_RHINO: ResourceKey<BiomeModifier> = registerKey("spawn_rhino")
	val ADD_ALEXANDRITE_GEODE: ResourceKey<BiomeModifier> = registerKey("add_alexandrite_geode")
*/
	fun bootstrap(context: BootstrapContext<BiomeModifier?>) {
		var placedFeatures: HolderGetter<PlacedFeature> = context.lookup(Registries.PLACED_FEATURE)
		var biomes: HolderGetter<Biome> = context.lookup(Registries.BIOME)


		with(context) {
			register(
				ADD_EXAMPLE_ORE, BiomeModifiers.AddFeaturesBiomeModifier(
					biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
					HolderSet.direct(placedFeatures.getOrThrow(ExamplePlacedFeatures.EXAMPLE_ORE_PLACED_KEY)),
					GenerationStep.Decoration.UNDERGROUND_ORES
				)
			)
		}
	}
/*
		context.register(
			ADD_NETHER_ALEXANDRITE_ORE, AddFeaturesBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_NETHER),
				HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.NETHER_ALEXANDRITE_ORE_PLACED_KEY)),
				GenerationStep.Decoration.UNDERGROUND_ORES
			)
		)

		context.register(
			ADD_END_ALEXANDRITE_ORE, AddFeaturesBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_END),
				HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.END_ALEXANDRITE_ORE_PLACED_KEY)),
				GenerationStep.Decoration.UNDERGROUND_ORES
			)
		)

		context.register(
			ADD_SNAPDRAGON, AddFeaturesBiomeModifier(
				biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
				HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.SNAPDRAGON_PLACED_KEY)),
				GenerationStep.Decoration.VEGETAL_DECORATION
			)
		)

		context.register(
			ADD_TREE_WALNUT, AddFeaturesBiomeModifier(
				biomes.getOrThrow(Tags.Biomes.IS_PLAINS),
				HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WALNUT_PLACED_KEY)),
				GenerationStep.Decoration.VEGETAL_DECORATION
			)
		)
		context.register(
			SPAWN_RHINO, AddSpawnsBiomeModifier(
				biomes.getOrThrow(Tags.Biomes.IS_DRY_OVERWORLD),
				List.of(SpawnerData(ModEntities.RHINO.get(), 20, 1, 3))
			)
		)

		context.register(
			ADD_ALEXANDRITE_GEODE, AddFeaturesBiomeModifier(
				biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
				HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.ALEXANDRITE_GEODE_PLACED_KEY)),
				GenerationStep.Decoration.LOCAL_MODIFICATIONS
			)
		)
	}
*/

	private fun registerKey(name: String): ResourceKey<BiomeModifier?> {
		return ResourceKey.create<BiomeModifier>(
			NeoForgeRegistries.Keys.BIOME_MODIFIERS,
			ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name)
		)
	}
}


