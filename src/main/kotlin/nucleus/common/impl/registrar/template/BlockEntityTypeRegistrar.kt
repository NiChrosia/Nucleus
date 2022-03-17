package nucleus.common.impl.registrar.template

import net.fabricmc.fabric.api.`object`.builder.v1.block.entity.FabricBlockEntityTypeBuilder
import net.minecraft.block.Block
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import nucleus.common.impl.registrar.MinecraftRegistrar

open class BlockEntityTypeRegistrar(namespace: String) : MinecraftRegistrar<BlockEntityType<out BlockEntity>>(Registry.BLOCK_ENTITY_TYPE, namespace) {
    fun <B, E> typeOf(block: B, factory: (BlockPos, BlockState) -> E): BlockEntityType<E> where B : Block, E : BlockEntity {
        val builder = FabricBlockEntityTypeBuilder.create(factory, block)

        return builder.build()
    }

    @Suppress("UNCHECKED_CAST") // nullable cast
    fun <B, E> typeOf(block: B): BlockEntityType<E> where B : Block, B : BlockEntityProvider, E : BlockEntity {
        val factory = { pos: BlockPos, state: BlockState ->
            val nullEntity = "Block '$block' cannot create a block entity using the given position and state."
            val entity = block.createBlockEntity(pos, state) ?: throw IllegalArgumentException(nullEntity)

            val invalidType = "Created entity is of invalid type."
            val casted = (entity as? E) ?: throw IllegalArgumentException(invalidType)

            casted
        }

        return typeOf(block, factory)
    }
}