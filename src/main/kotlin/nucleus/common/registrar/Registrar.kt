package nucleus.common.registrar

import nucleus.common.division.RegistrarRoot
import nucleus.common.member.Member
import nucleus.common.registrar.type.BinaryRegistrar

/** The core of the registration system, containing a content map & root reference. */
open class Registrar<K, V, R : RegistrarRoot<R>>(val root: R) {
    open val content = mutableMapOf<K, V>()

    /** Register the given content to the registry. Extensible to allow adding features such as identifying values
     * ([BinaryRegistrar]) */
    open fun register(key: K, value: V): V {
        return value.also {
            content[key] = it
        }
    }

    /** Utility function to make member creation easier. Overridden by subclasses with unique members. */
    open fun <T : V> memberOf(key: K, provider: (K) -> T): Member<K, V, T, R> {
        return Member(root, this, key, provider)
    }
}