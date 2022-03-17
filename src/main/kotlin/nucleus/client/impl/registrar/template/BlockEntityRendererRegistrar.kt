package nucleus.client.impl.registrar.template

import net.minecraft.block.entity.BlockEntityType
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory
import nucleus.common.impl.registrar.DeferredRegistrar

open class BlockEntityRendererRegistrar : DeferredRegistrar<BlockEntityType<*>, BlockEntityRendererFactory<*>>({ BlockEntityRendererFactories.FACTORIES })