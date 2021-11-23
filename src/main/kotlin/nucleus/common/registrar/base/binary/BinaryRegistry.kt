package nucleus.common.registrar.base.binary

import nucleus.common.registrar.Registry

open class BinaryRegistry<K, V> : Registry<K, V>() {
    val reversed = mutableMapOf<V, K>()

    override fun register(key: K, value: V): V {
        return super.register(key, value).also {
            reversed[value] = key
        }
    }

    open fun identify(value: V): K? {
        return reversed[value]
    }

    open fun identify(value: V, fallbackKey: K): K {
        return reversed[value] ?: fallbackKey.also {
            register(it, value)
        }
    }
}