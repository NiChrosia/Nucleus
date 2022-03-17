package nucleus.common.impl.registrar

import nucleus.common.api.registrar.Registrar

open class DeferredRegistrar<K, V>(val backend: () -> MutableMap<K, V>) : Registrar<K, V> {
    override fun get(key: K): V {
        val map = backend()

        return map[key] ?: throw noElementFound(key)
    }

    override fun <T : V> register(key: K, value: T): T {
        val map = backend()

        map[key] = value

        return value
    }
}