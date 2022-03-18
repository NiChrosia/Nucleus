package nucleus.common.impl.registrar

import nucleus.common.api.registrar.Registrar
import nucleus.common.api.registrar.capability.Reversible

open class SimpleReversibleRegistrar<K, V> : Registrar<K, V>, Reversible<K, V> {
    val content = mutableMapOf<K, V>()
    val reversed = mutableMapOf<V, K>()

    override fun <T : V> register(key: K, value: T): T {
        content[key] = value
        reversed[value] = key

        return value
    }

    override fun get(key: K): V {
        return content[key] ?: throw noElementFound(key)
    }

    override fun identify(value: V): K {
        return reversed[value] ?: throw noKeyFound(value)
    }
}