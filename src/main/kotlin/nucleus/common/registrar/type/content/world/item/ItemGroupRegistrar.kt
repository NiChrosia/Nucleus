package nucleus.common.registrar.type.content.world.item

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import nucleus.common.registrar.base.member.MemberRegistrar

open class ItemGroupRegistrar(namespace: String) : MemberRegistrar<ItemGroup>(namespace) {
    open fun builderOf(ID: Identifier): FabricItemGroupBuilder {
        return FabricItemGroupBuilder.create(ID)
    }

    open fun builderOf(path: String): FabricItemGroupBuilder {
        return builderOf(identify(path))
    }

    open fun groupOf(ID: Identifier, icon: () -> ItemStack = ItemStack::EMPTY): ItemGroup {
        return builderOf(ID).icon(icon).build()
    }

    open fun groupOf(path: String, icon: () -> ItemStack = ItemStack::EMPTY): ItemGroup {
        return groupOf(identify(path), icon)
    }
}