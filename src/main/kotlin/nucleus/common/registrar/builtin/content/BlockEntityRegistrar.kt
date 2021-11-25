package nucleus.common.registrar.builtin.content

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.type.VanillaRegistrar

open class BlockEntityRegistrar(override val group: ContentGroup) : VanillaRegistrar<BlockEntityType<*>>(group, Registry.BLOCK_ENTITY_TYPE) {
    open fun <T : BlockEntity> typeOf(factory: (BlockPos, BlockState) -> T, vararg blocks: Block): BlockEntityType<T> {
        return BlockEntityType(factory, blocks.toSet(), null)
    }
}