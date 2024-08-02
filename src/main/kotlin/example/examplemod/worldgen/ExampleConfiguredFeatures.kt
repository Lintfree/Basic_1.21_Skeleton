package example.examplemod.worldgen

import example.examplemod.ExampleMod
import example.examplemod.block.ModBlocks
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.*
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest

object ExampleConfiguredFeatures {


	val OVERWORLD_EXAMPLE_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("example_ore")

	/*
	val NETHER_ALEXANDRITE_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("nether_alexandrite_ore")
	val END_ALEXANDRITE_ORE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("end_alexandrite_ore")
	val WALNUT_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("walnut")
	val SNAPDRAGON_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("snapdragon")
	val ALEXANDRITE_GEODE_KEY: ResourceKey<ConfiguredFeature<*, *>> = registerKey("alexandrite_geode")
*/

	fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>>) {
		val stoneReplaceabeles: RuleTest = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)

	/*
		val deepslateReplaceabeles: RuleTest = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
		val netherrackReplaceabeles: RuleTest = BlockMatchTest(Blocks.NETHERRACK)
		val endReplaceabeles: RuleTest = BlockMatchTest(Blocks.END_STONE)
*/
		val overworldExampleOres = listOf<TargetBlockState>(
			OreConfiguration.target(
				stoneReplaceabeles,
				ModBlocks.EXAMPLE_ORE.get().defaultBlockState()
			)
	)
					/*
			OreConfiguration.target(
				deepslateReplaceabeles,
				ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get().defaultBlockState()
			)
		)

		register<TreeConfiguration, Feature<TreeConfiguration>>(
			context, WALNUT_KEY, Feature.TREE, TreeConfigurationBuilder(
				BlockStateProvider.simple(ModBlocks.WALNUT_LOG.get()),
				WalnutTrunkPlacer(5, 4, 3),
				BlockStateProvider.simple(ModBlocks.WALNUT_LEAVES.get()),
				WalnutFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 3),
				TwoLayersFeatureSize(1, 0, 2)
			).dirt(BlockStateProvider.simple(Blocks.END_STONE)).build()
		)

		register(context, OVERWORLD_ALEXANDRITE_ORE_KEY, Feature.ORE, OreConfiguration(overworldAlexandriteOres, 9))
		register<OreConfiguration, Feature<OreConfiguration>>(
			context, NETHER_ALEXANDRITE_ORE_KEY, Feature.ORE, OreConfiguration(
				netherrackReplaceabeles,
				ModBlocks.NETHER_ALEXANDRITE_ORE.get().defaultBlockState(), 9
			)
		)
		register<OreConfiguration, Feature<OreConfiguration>>(
			context, END_ALEXANDRITE_ORE_KEY, Feature.ORE, OreConfiguration(
				endReplaceabeles,
				ModBlocks.END_STONE_ALEXANDRITE_ORE.get().defaultBlockState(), 9
			)
		)

		register<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
			context, SNAPDRAGON_KEY, Feature.FLOWER,
			RandomPatchConfiguration(
				32, 6, 2, PlacementUtils.onlyWhenEmpty<SimpleBlockConfiguration, Feature<SimpleBlockConfiguration>>(
					Feature.SIMPLE_BLOCK,
					SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.SNAPDRAGON.get()))
				)
			)
		)

		register<GeodeConfiguration, Feature<GeodeConfiguration>>(
			context, ALEXANDRITE_GEODE_KEY, Feature.GEODE,
			GeodeConfiguration(
				GeodeBlockSettings(
					BlockStateProvider.simple(Blocks.AIR),
					BlockStateProvider.simple(Blocks.DEEPSLATE),
					BlockStateProvider.simple(ModBlocks.ALEXANDRITE_ORE.get()),
					BlockStateProvider.simple(Blocks.DIRT),
					BlockStateProvider.simple(Blocks.EMERALD_BLOCK),
					List.of(ModBlocks.ALEXANDRITE_BLOCK.get().defaultBlockState()),
					BlockTags.FEATURES_CANNOT_REPLACE, BlockTags.GEODE_INVALID_BLOCKS
				),
				GeodeLayerSettings(1.7, 1.2, 2.5, 3.5),
				GeodeCrackSettings(0.25, 1.5, 1), 0.5, 0.1,
				true, UniformInt.of(3, 8),
				UniformInt.of(2, 6), UniformInt.of(1, 2),
				- 18, 18, 0.075, 1
			)
		)
	}
					 */
	}


	fun registerKey(name: String?): ResourceKey<ConfiguredFeature<*, *>> {
		return ResourceKey.create<ConfiguredFeature<*, *>>(
			Registries.CONFIGURED_FEATURE,
			ResourceLocation.fromNamespaceAndPath(ExampleMod.MOD_ID, name)
		)
	}

	fun <FC : FeatureConfiguration?, F : Feature<FC>?> register(
		context: BootstrapContext<ConfiguredFeature<*, *>>,
		key: ResourceKey<ConfiguredFeature<*, *>>, feature: F & Any, configuration: FC & Any
	) {
		context.register(key, ConfiguredFeature(feature, configuration))
	}
}