package nucleus.common.registrar.type.content

import net.minecraft.block.Block
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.VanillaRegistrar

open class BlockRegistrar(namespace: String) : VanillaRegistrar<Block>(Registry.BLOCK, namespace)