package nucleus.common.registrar.builtin.content

import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.member.type.ItemMember
import nucleus.common.registrar.type.VanillaRegistrar

open class ItemRegistrar(override val group: ContentGroup) : VanillaRegistrar<Item>(group, Registry.ITEM) {
    override fun <T : Item> member(key: Identifier, provider: (Identifier) -> T) = ItemMember(this, key, provider).also(members::add)
    override fun <T : Item> member(path: String, provider: (Identifier) -> T) = member(group.identify(path), provider)
}