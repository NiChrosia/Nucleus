package nucleus.common.registrar.type.content.world.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.VanillaRegistrar

open class BlockEntityRegistrar(namespace: String) : VanillaRegistrar<BlockEntityType<*>>(Registry.BLOCK_ENTITY_TYPE, namespace) {
    open fun <T : BlockEntity> typeOf(factory: (BlockPos, BlockState) -> T, vararg blocks: Block): BlockEntityType<T> {
        return BlockEntityType(factory, blocks.toSet(), null)
    }
}