package nucleus.common.registrar.type

import nucleus.common.division.RegistrarRoot
import nucleus.common.registrar.Registrar

/** An extension of [Registrar] that adds an `identify` method to allow getting the ID from a value, which is otherwise
 * anonymous. */
open class BinaryRegistrar<K, V, R : RegistrarRoot<R>>(root: R) : Registrar<K, V, R>(root) {
    /** The reversed map containing values mapped to keys. */
    open val reversed = mutableMapOf<V, K>()

    override fun register(key: K, value: V): V {
        return super.register(key, value).also {
            reversed[value] = key
        }
    }

    /** Return the matching key for this value, or null if not found. */
    open fun identify(value: V): K? {
        return reversed[value]
    }
}