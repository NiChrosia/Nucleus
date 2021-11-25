package nucleus.common.registrar.type

import net.minecraft.util.Identifier
import nucleus.common.member.Member
import nucleus.common.registrar.Registrar
import nucleus.common.registrar.RegistrarGroup

open class IdRegistrar<V>(group: RegistrarGroup) : Registrar<Identifier, V>(group) {
    open fun <T : V> member(path: String, provider: (Identifier) -> T): Member<Identifier, V, T> {
        return member(group.identify(path), provider)
    }
}