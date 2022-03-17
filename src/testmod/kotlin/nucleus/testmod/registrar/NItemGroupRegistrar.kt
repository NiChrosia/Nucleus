package nucleus.testmod.registrar

import net.minecraft.item.Items
import nucleus.common.impl.registrar.template.ItemGroupRegistrar

open class NItemGroupRegistrar(namespace: String) : ItemGroupRegistrar(namespace) {
    val sample = builderOf("nucleus")
        .icon(Items::IRON_PICKAXE)
        .build()
}