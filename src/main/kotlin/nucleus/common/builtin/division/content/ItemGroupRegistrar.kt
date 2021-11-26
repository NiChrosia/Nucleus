package nucleus.common.builtin.division.content

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.registrar.Registrar

open class ItemGroupRegistrar<R : ModRoot<R>>(root: R) : Registrar<Identifier, ItemGroup, R>(root) {
    open fun builderOf(id: Identifier): FabricItemGroupBuilder {
        return FabricItemGroupBuilder.create(id)
    }

    open fun groupOf(id: Identifier, icon: () -> ItemStack = ItemStack::EMPTY): ItemGroup {
        return builderOf(id).icon(icon).build()
    }
}