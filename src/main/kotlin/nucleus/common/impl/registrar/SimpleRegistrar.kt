package nucleus.common.impl.registrar

import nucleus.common.api.registrar.Registrar

open class SimpleRegistrar<K, V> : Registrar<K, V> {
    val content = mutableMapOf<K, V>()

    override fun <T : V> register(key: K, value: T): T {
        content[key] = value

        return value
    }

    override fun get(key: K): V {
        return content[key] ?: throw noElementFound(key)
    }
}