package nucleus.common.registrar.type

import nucleus.common.division.RegistrarRoot
import nucleus.common.registrar.Registrar

open class BinaryRegistrar<K, V, R : RegistrarRoot<R>>(root: R) : Registrar<K, V, R>(root) {
    open val reversed = mutableMapOf<V, K>()

    override fun register(key: K, value: V): V {
        return super.register(key, value).also {
            reversed[value] = key
        }
    }

    open fun identify(value: V): K? {
        return reversed[value]
    }
}