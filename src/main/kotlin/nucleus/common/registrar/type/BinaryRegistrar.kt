package nucleus.common.registrar.type

interface BinaryRegistrar<K, V> {
    val reversed: MutableMap<V, K>

    fun identify(value: V): K? {
        return reversed[value]
    }
}