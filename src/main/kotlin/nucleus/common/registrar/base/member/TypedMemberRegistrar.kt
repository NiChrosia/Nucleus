package nucleus.common.registrar.base.member

import net.minecraft.util.Identifier
import nucleus.common.member.Member

abstract class TypedMemberRegistrar<V, M : Member<V>>(namespace: String) : MemberRegistrar<V>(namespace) {
    abstract override val member: (Identifier, (Identifier) -> V) -> M

    override fun memberOf(ID: Identifier, provider: (Identifier) -> V): M {
        return member(ID, provider).also(members::add)
    }

    override fun memberOf(path: String, provider: (Identifier) -> V): M {
        return memberOf(identify(path), provider)
    }
}