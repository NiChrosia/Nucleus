package nucleus.common.impl.registrar.template

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.Item
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import nucleus.common.impl.registrar.NamespacedRegistrar

open class ItemGroupRegistrar(namespace: String) : NamespacedRegistrar<ItemGroup>(namespace) {
    // purely cosmetic for the purpose of overloads
    fun builderOf(key: Identifier): FabricItemGroupBuilder {
        return FabricItemGroupBuilder.create(key)
    }

    fun builderOf(path: String): FabricItemGroupBuilder {
        val key = Identifier(namespace, path)

        return builderOf(key)
    }

    // kotlin-only, as java usage negates the purpose of chaining methods
    fun <I : Item> FabricItemGroupBuilder.icon(item: () -> I): FabricItemGroupBuilder {
        return icon { ItemStack(item()) }
    }
}