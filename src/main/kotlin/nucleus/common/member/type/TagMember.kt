package nucleus.common.member.type

import net.minecraft.util.Identifier
import nucleus.common.member.Member
import nucleus.common.registrar.Registrar
import nucleus.common.registrar.type.tag.TagEntry

interface TagMember<V, T : V> {
    val registrar: Registrar<Identifier, V>
    val registrationListeners: MutableList<Member<Identifier, V, T>.() -> Unit>
    val key: Identifier

    fun tag(tag: () -> TagEntry) {
        registrationListeners.add {
            tag().add(key)
        }
    }
}