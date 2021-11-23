package nucleus.client.registrar.type.content.world.block

import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import nucleus.client.registrar.type.content.ScreenEntry

/** An entry object with a similar purpose to [ScreenEntry], which is allowing dynamic registration of wildcard type
 * entries. */
open class BlockEntityRendererEntry<T : BlockEntity>(
    val type: BlockEntityType<T>,
    val factory: BlockEntityRendererFactory<in T>
) {
    open fun publish() {
        BlockEntityRendererRegistry.register(type, factory)
    }
}