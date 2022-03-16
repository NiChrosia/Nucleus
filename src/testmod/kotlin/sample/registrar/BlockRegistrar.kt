package sample.registrar

import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.util.registry.Registry
import nucleus.impl.registrar.DeferredRegistrar
import sample.block.SampleChestBlock
import sample.category.SampleNucleus.blockEntityTypes

class BlockRegistrar(namespace: String) : DeferredRegistrar<Block>(Registry.BLOCK, namespace) {
    val block = register("block", Block(FabricBlockSettings.of(Material.STONE)))

    // explicitly typing blocks with entities is necessary to avoid infinite recursion (type -> block -> type...)
    val chest: SampleChestBlock = register("chest", SampleChestBlock(FabricBlockSettings.of(Material.WOOD)) { blockEntityTypes.sampleChest })
}