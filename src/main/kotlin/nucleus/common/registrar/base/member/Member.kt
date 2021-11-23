package nucleus.common.registrar.base.member

import net.minecraft.util.Identifier

/** An extension of [Lazy] that contains an identifier and a content provider. */
open class Member<V>(val ID: Identifier, provider: () -> V) : Lazy<V> by lazy(provider) {
    open fun register(registrar: MemberRegistrar<V>) {
        registrar.register(ID, value)
    }
}