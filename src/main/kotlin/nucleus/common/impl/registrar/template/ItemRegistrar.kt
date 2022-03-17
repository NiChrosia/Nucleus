package nucleus.common.impl.registrar.template

import net.minecraft.item.Item
import net.minecraft.util.registry.Registry
import nucleus.common.impl.registrar.MinecraftRegistrar

open class ItemRegistrar(namespace: String) : MinecraftRegistrar<Item>(Registry.ITEM, namespace)