package nucleus.client.registrar.type.content.world.block

import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import net.minecraft.util.Identifier
import nucleus.common.registrar.base.member.MemberRegistrar

open class BlockEntityRendererRegistrar(namespace: String) : MemberRegistrar<BlockEntityRendererEntry<*>>(namespace) {
    open fun <T : BlockEntity> entryOf(
        type: BlockEntityType<T>,
        factory: BlockEntityRendererFactory<in T>
    ): BlockEntityRendererEntry<T> {
        return BlockEntityRendererEntry(type, factory)
    }

    override fun publish(key: Identifier, value: BlockEntityRendererEntry<*>): BlockEntityRendererEntry<*> {
        return super.publish(key, value).also(BlockEntityRendererEntry<*>::publish)
    }
}