package nucleus.common.registrar.type.identity

import net.minecraft.util.Identifier
import nucleus.common.registrar.type.binary.BinaryRegistrar

open class IdentifyingRegistrar<V>(val namespace: String) : BinaryRegistrar<Identifier, V>() {
    open fun register(key: String, value: V): V {
        return register(Identifier(namespace, key), value)
    }

    open fun publish(key: String, value: V): V {
        return publish(Identifier(namespace, key), value)
    }
}