package nucleus.common.member.type

import net.minecraft.util.Identifier
import nucleus.common.member.Member
import nucleus.common.registrar.builtin.content.ContentGroup

interface TransitionalMember<V, T : V> {
    val group: ContentGroup
    val registrationListeners: MutableList<Member<Identifier, V, T>.() -> Unit>
    val key: Identifier

    fun old(old: Identifier) {
        registrationListeners.add {
            TransitionMappings[old] = key
        }
    }

    fun old(path: String) {
        old(group.identify(path))
    }
}