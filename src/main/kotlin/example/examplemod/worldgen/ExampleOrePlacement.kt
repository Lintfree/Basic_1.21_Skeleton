package example.examplemod.worldgen

import net.minecraft.world.level.levelgen.placement.*

object ExampleOrePlacement {
	fun orePlacement(p_195347_: PlacementModifier, p_195348_: PlacementModifier): List<PlacementModifier> {
		return java.util.List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome())
	}

	fun commonOrePlacement(pCount: Int, pHeightRange: PlacementModifier): List<PlacementModifier> {
		return orePlacement(CountPlacement.of(pCount), pHeightRange)
	}

	fun rareOrePlacement(pChance: Int, pHeightRange: PlacementModifier): List<PlacementModifier> {
		return orePlacement(RarityFilter.onAverageOnceEvery(pChance), pHeightRange)
	}
}
