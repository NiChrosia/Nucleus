package nucleus.common.registrar.type

import nucleus.common.division.RegistrarRoot
import nucleus.common.phase.Phase

/** An extension of [BinaryRegistrar] that allows publishing objects. This is mainly used to publish objects to
 * Minecraft registries, e.g. Registry.ITEM, BLOCK, etc. This is also the first registrar type that makes use of
 * [Phase]s. */
abstract class PublicationRegistrar<K, V, R : RegistrarRoot<R>>(root: R) : BinaryRegistrar<K, V, R>(root) {
    init {
        root.dispatcher.publish.listeners.add {
            content.forEach { (key, value) ->
                publish(key, value)
            }
        }
    }

    /** Publish the given key & value to external registries. */
    abstract fun publish(key: K, value: V)
}