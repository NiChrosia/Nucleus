package nucleus.common.api.registrar

interface Registrar<K, V> {
    fun <T : V> register(key: K, value: T): T

    fun noElementFound(key: K): IllegalArgumentException {
        return IllegalArgumentException("No such element found for the given key '$key.'")
    }

    operator fun get(key: K): V
}