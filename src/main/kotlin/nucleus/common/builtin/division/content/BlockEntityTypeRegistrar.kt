package nucleus.common.builtin.division.content

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.math.BlockPos
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.type.VanillaRegistrar

open class BlockEntityTypeRegistrar<R : ModRoot<R>>(root: R) : VanillaRegistrar<BlockEntityType<*>, R>(root, Registry.BLOCK_ENTITY_TYPE) {
    open fun <T : BlockEntity> typeOf(factory: (BlockPos, BlockState) -> T, vararg blocks: Block): BlockEntityType<T> {
        return BlockEntityType(factory, blocks.toSet(), null)
    }
}