package nucleus.common.registrar.base.identity

import net.minecraft.util.Identifier
import nucleus.common.registrar.base.binary.BinaryRegistrar

open class IdentifyingRegistrar<V>(val namespace: String) : BinaryRegistrar<Identifier, V>() {
    open fun register(key: String, value: V): V {
        return register(Identifier(namespace, key), value)
    }

    open fun publish(key: String, value: V): V {
        return publish(Identifier(namespace, key), value)
    }
}