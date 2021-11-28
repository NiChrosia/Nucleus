package nucleus.client.builtin.division.content

import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import net.minecraft.util.Identifier
import nucleus.client.builtin.division.ClientModRoot
import nucleus.common.registrar.type.PublicationRegistrar

open class BlockEntityRendererRegistrar<R : ClientModRoot<R>>(root: R) : PublicationRegistrar<Identifier, BlockEntityRendererEntry<*>, R>(root) {
    override fun publish(key: Identifier, value: BlockEntityRendererEntry<*>) {
        value.publish()
    }

    open fun <T : BlockEntity> entryOf(
        type: BlockEntityType<T>,
        factory: BlockEntityRendererFactory<in T>
    ): BlockEntityRendererEntry<T> {
        return BlockEntityRendererEntry(type, factory)
    }
}