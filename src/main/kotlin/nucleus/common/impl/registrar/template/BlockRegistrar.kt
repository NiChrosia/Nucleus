package nucleus.common.impl.registrar.template

import net.minecraft.block.Block
import net.minecraft.util.registry.Registry
import nucleus.common.impl.registrar.MinecraftRegistrar

open class BlockRegistrar(namespace: String) : MinecraftRegistrar<Block>(Registry.BLOCK, namespace)