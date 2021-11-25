package nucleus.common.registrar.type

interface Publishable<K, V> {
    fun publish(key: K, value: V)
}