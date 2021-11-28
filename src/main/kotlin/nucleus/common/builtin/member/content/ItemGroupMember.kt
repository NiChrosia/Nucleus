package nucleus.common.builtin.member.content

import net.minecraft.item.ItemGroup
import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.division.content.ItemGroupRegistrar
import nucleus.common.extension.capitalize
import nucleus.common.member.Member

open class ItemGroupMember<T : ItemGroup, R : ModRoot<R>>(
    root: R,
    registrar: ItemGroupRegistrar<R>,
    key: Identifier,
    provider: (Identifier) -> T
) : Member<Identifier, ItemGroup, T, R>(root, registrar, key, provider), LangMember<R> {
    override val langCategory = "itemGroup"

    override fun readableEnglish(): String {
        return key.namespace.capitalize()
    }
}