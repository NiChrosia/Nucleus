package nucleus.common.builtin.division.content

import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.member.content.ItemMember
import nucleus.common.registrar.type.VanillaRegistrar

open class ItemRegistrar<R : ModRoot<R>>(root: R) : VanillaRegistrar<Item, R>(root, Registry.ITEM) {
    override fun <T : Item> memberOf(key: Identifier, provider: (Identifier) -> T): ItemMember<T, R> {
        return ItemMember(root, this, key, provider)
    }
}