package nucleus.common.registrar.base.identity

import net.minecraft.util.Identifier
import nucleus.common.registrar.base.binary.BinaryRegistrar

open class IdentifyingRegistrar<V>(val namespace: String) : BinaryRegistrar<Identifier, V>() {
    open fun identify(path: String): Identifier {
        return Identifier(namespace, path)
    }

    open fun register(key: String, value: V): V {
        return register(identify(key), value)
    }

    open fun publish(key: String, value: V): V {
        return publish(identify(key), value)
    }
}