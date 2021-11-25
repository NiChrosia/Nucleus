package nucleus.common.member.type

import net.minecraft.util.Identifier
import nucleus.common.member.Member
import nucleus.common.registrar.Registrar
import java.util.*

interface LangMember<V, T : V> {
    val registrar: Registrar<Identifier, V>
    val registrationListeners: MutableList<Member<Identifier, V, T>.() -> Unit>
    val key: Identifier

    val category: String

    fun readableEnglish(): String {
        return key.path.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
    }

    fun lang(provider: () -> String) {
        registrationListeners.add {
            registrar.group.pack.english.entry("$category.${key.namespace}.${key.path}", provider())
        }
    }
}