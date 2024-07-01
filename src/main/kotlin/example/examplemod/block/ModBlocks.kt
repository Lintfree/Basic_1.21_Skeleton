package example.examplemod.block

import example.examplemod.ExampleMod
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister

// THIS LINE IS REQUIRED FOR USING PROPERTY DELEGATES
//import thedarkcolour.kotlinforforge.neoforge.forge.getValue

object ModBlocks {
    val REGISTER_BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(ExampleMod.mod_id)

    // If you get an "overload resolution ambiguity" error, include the arrow at the start of the closure.
    val EXAMPLE_BLOCK: DeferredBlock<Block> = REGISTER_BLOCKS.register("example_block") { ->
        Block(BlockBehaviour.Properties.of()
            .lightLevel { 15 }
            .strength(3.0f, 6.0f)
            .requiresCorrectToolForDrops())
    }

    val EXAMPLE_ORE: DeferredBlock<Block> = REGISTER_BLOCKS.register("example_ore") { ->
        Block(BlockBehaviour.Properties.of()
            .lightLevel { 15 }
            .strength(3.0f)
            .requiresCorrectToolForDrops())
            //.getExpDrop(10))
    }
}
