package nucleus.common.member

import nucleus.common.division.RegistrarRoot
import nucleus.common.registrar.type.PublicationRegistrar

open class PublicationMember<K, V, T : V, R : RegistrarRoot<R>>(
    root: R,
    override val registrar: PublicationRegistrar<K, V, R>,
    key: K,
    provider: (K) -> T
) : Member<K, V, T, R>(root, registrar, key, provider) {
    open fun publish() {
        registrar.publish(key, value)
    }
}