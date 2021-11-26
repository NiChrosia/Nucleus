package nucleus.common.registrar.type

import nucleus.common.division.RegistrarRoot

abstract class PublicationRegistrar<K, V, R : RegistrarRoot<R>>(root: R) : BinaryRegistrar<K, V, R>(root) {
    init {
        root.publish.listeners.add {
            content.forEach { (key, value) ->
                publish(key, value)
            }
        }
    }

    abstract fun publish(key: K, value: V)
}