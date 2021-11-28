package nucleus.common.builtin.division.content

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.member.content.ItemGroupMember
import nucleus.common.registrar.Registrar

open class ItemGroupRegistrar<R : ModRoot<R>>(root: R) : Registrar<Identifier, ItemGroup, R>(root) {
    override fun <T : ItemGroup> memberOf(
        key: Identifier,
        provider: (Identifier) -> T
    ): ItemGroupMember<T, R> {
        return ItemGroupMember(root, this, key, provider)
    }

    open fun builderOf(id: Identifier): FabricItemGroupBuilder {
        return FabricItemGroupBuilder.create(id)
    }

    open fun groupOf(id: Identifier, icon: () -> ItemStack = ItemStack::EMPTY): ItemGroup {
        return builderOf(id).icon(icon).build()
    }
}