package nucleus.common.registrar.type.content.world.item

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier
import nucleus.common.datagen.lang.RegistrarPack
import nucleus.common.member.type.world.ItemGroupMember
import nucleus.common.registrar.base.datagen.PackRegistrar
import nucleus.common.registrar.base.member.TypedMemberRegistrar

open class ItemGroupRegistrar(namespace: String, override val pack: RegistrarPack) : TypedMemberRegistrar<ItemGroup, ItemGroupMember>(namespace), PackRegistrar {
    override val member: (Identifier, (Identifier) -> ItemGroup) -> ItemGroupMember = { ID, provider ->
        ItemGroupMember(pack, ID, provider)
    }

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

    open fun iconProviderOf(item: () -> Item = Items::AIR): () -> ItemStack {
        return item.let {{ ItemStack(item()) }}
    }
}