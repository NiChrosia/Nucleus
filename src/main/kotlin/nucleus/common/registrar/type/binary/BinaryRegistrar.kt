package nucleus.common.registrar.type.binary

import nucleus.common.registrar.Registrar

open class BinaryRegistrar<K, V> : Registrar<K, V>() {
    override val registry = BinaryRegistry<K, V>()

    open fun identify(value: V) = registry.identify(value)
    open fun identify(value: V, fallbackKey: K) = registry.identify(value, fallbackKey)
}