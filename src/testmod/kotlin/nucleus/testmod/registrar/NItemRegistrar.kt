package nucleus.testmod.registrar

import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import nucleus.common.impl.registrar.template.ItemRegistrar
import nucleus.common.impl.registrar.template.capability.Grouped
import nucleus.testmod.Nucleus

open class NItemRegistrar(namespace: String) : ItemRegistrar(namespace), Grouped {
    override val group = Nucleus.itemGroups.sample

    val item = register("item", Item(groupedSettings()))
    val chest = register("chest", BlockItem(Nucleus.blocks.chest, groupedSettings()))
}