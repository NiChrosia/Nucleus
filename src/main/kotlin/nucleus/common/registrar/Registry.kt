package nucleus.common.registrar

open class Registry<K, V> {
    val content = mutableMapOf<K, V>()

    open fun register(key: K, value: V): V {
        return value.also {
            content[key] = it
        }
    }
}