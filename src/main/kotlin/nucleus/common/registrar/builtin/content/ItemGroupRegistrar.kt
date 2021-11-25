package nucleus.common.registrar.builtin.content

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import nucleus.common.registrar.type.IdRegistrar

open class ItemGroupRegistrar(override val group: ContentGroup) : IdRegistrar<ItemGroup>(group) {
    open fun builderOf(id: Identifier): FabricItemGroupBuilder {
        return FabricItemGroupBuilder.create(id)
    }

    open fun builderOf(path: String): FabricItemGroupBuilder {
        return builderOf(group.identify(path))
    }

    open fun groupOf(id: Identifier, icon: () -> ItemStack = ItemStack::EMPTY): ItemGroup {
        return builderOf(id).icon(icon).build()
    }

    open fun groupOf(path: String, icon: () -> ItemStack = ItemStack::EMPTY): ItemGroup {
        return groupOf(group.identify(path), icon)
    }
}