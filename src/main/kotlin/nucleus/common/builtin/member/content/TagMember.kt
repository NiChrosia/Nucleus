package nucleus.common.builtin.member.content

import net.minecraft.util.Identifier
import nucleus.common.builtin.division.ModRoot
import nucleus.common.builtin.division.content.Tag

interface TagMember<R : ModRoot<R>> {
    val root: R
    val key: Identifier

    fun tag(provider: () -> Tag<R>) {
        root.datagen.listeners.add {
            provider().values.add(key)
        }
    }
}