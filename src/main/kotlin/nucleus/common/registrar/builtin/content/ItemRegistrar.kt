package nucleus.common.registrar.builtin.content

import net.minecraft.item.Item
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.type.vanilla.VanillaRegistrar

open class ItemRegistrar(namespace: String) : VanillaRegistrar<Item>(Registry.ITEM, namespace)