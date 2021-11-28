package nucleus.client.builtin.division.content

import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory

open class BlockEntityRendererEntry<T : BlockEntity>(
    val type: BlockEntityType<T>,
    val factory: BlockEntityRendererFactory<in T>
) {
    open fun publish() {
        BlockEntityRendererRegistry.register(type, factory)
    }
}