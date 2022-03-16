package sample.registrar

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.registry.Registry
import nucleus.impl.registrar.DeferredRegistrar
import sample.category.SampleNucleus

open class BlockEntityTypeRegistrar(namespace: String) : DeferredRegistrar<BlockEntityType<out BlockEntity>>(Registry.BLOCK_ENTITY_TYPE, namespace) {
    val sampleChest = register("sample_chest", FabricBlockEntityTypeBuilder.create(
        SampleNucleus.blocks.chest::createBlockEntity,
        SampleNucleus.blocks.chest
    ).build()!!)
}