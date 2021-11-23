package nucleus.common.registrar.type.content

import net.minecraft.item.Item
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.base.vanilla.VanillaRegistrar

open class ItemRegistrar(namespace: String) : VanillaRegistrar<Item>(Registry.ITEM, namespace)