package nucleus.common.registrar.base.member

import net.minecraft.util.Identifier
import nucleus.common.registrar.base.identity.IdentifyingRegistrar

open class MemberRegistrar<V>(namespace: String) : IdentifyingRegistrar<V>(namespace) {
    val members = mutableListOf<Member<V>>()

    open fun registerContent() {
        members.forEach {
            it.register(this)
        }
    }

    open fun memberOf(ID: Identifier, provider: () -> V): Member<V> {
        return Member(ID, provider).apply(members::add)
    }

    open fun memberOf(path: String, provider: () -> V): Member<V> {
        return memberOf(Identifier(namespace, path), provider)
    }
}