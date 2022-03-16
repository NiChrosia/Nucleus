package nucleus.impl.registrar

import net.minecraft.util.Identifier
import nucleus.api.registrar.Registrar

open class SimpleRegistrar<T>(val namespace: String) : Registrar<T> {
    val content = hashMapOf<Identifier, T>()

    override fun <V : T> register(key: Identifier, value: V): V {
        content[key] = value

        return value
    }

    override fun get(key: Identifier): T {
        return content[key] ?: throw IllegalArgumentException("No such element found for the given key '$key.'")
    }

    // annoying to implement for every API class, but there's no good way to do it with an external interface without
    // extension functions
    open fun <V : T> register(path: String, value: V): V {
        return register(Identifier(namespace, path), value)
    }
}