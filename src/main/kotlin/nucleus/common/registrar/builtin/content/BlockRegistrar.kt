package nucleus.common.registrar.builtin.content

import net.minecraft.block.Block
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.type.vanilla.VanillaRegistrar

open class BlockRegistrar(namespace: String) : VanillaRegistrar<Block>(Registry.BLOCK, namespace)