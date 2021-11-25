package nucleus.common.member.type

import net.devtech.arrp.json.models.JModel
import net.minecraft.util.Identifier
import nucleus.common.extension.within
import nucleus.common.member.Member
import nucleus.common.registrar.Registrar

interface ModelMember<V, T : V> {
    val registrar: Registrar<Identifier, V>
    val datagenListeners: MutableList<Member<Identifier, V, T>.() -> Unit>
    val key: Identifier

    /** Folder in which models for this member type go, item or block. */
    val folder: String

    fun model(provider: () -> JModel) {
        datagenListeners.add {
            registrar.group.pack.addModel(provider(), key.within(folder))
        }
    }
}