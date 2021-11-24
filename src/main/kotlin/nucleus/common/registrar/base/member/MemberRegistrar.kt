package nucleus.common.registrar.base.member

import net.minecraft.util.Identifier
import nucleus.common.member.Member
import nucleus.common.registrar.base.identity.IdentifyingRegistrar

open class MemberRegistrar<V>(namespace: String) : IdentifyingRegistrar<V>(namespace) {
    protected open val member: (Identifier, (Identifier) -> V) -> Member<V> = ::Member
    val members = mutableListOf<Member<V>>()

    open fun registerContent() {
        members.forEach {
            it.register(this)
        }
    }

    open fun memberOf(ID: Identifier, provider: (Identifier) -> V): Member<V> {
        return member(ID, provider).apply(members::add)
    }

    open fun memberOf(path: String, provider: (Identifier) -> V): Member<V> {
        return memberOf(Identifier(namespace, path), provider)
    }
}