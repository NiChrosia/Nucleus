package nucleus.impl.registrar

import net.minecraft.util.Identifier
import nucleus.api.registrar.ReversibleRegistrar

open class SimpleReversibleRegistrar<T>(val namespace: String) : ReversibleRegistrar<T> {
    val content = hashMapOf<Identifier, T>()
    val reversed = hashMapOf<T, Identifier>()

    override fun <V : T> register(key: Identifier, value: V): V {
        content[key] = value
        reversed[value] = key

        return value
    }

    override fun get(key: Identifier): T {
        return content[key] ?: throw IllegalArgumentException("No such element found for the given key '$key.'")
    }

    override fun identify(value: T): Identifier {
        return reversed[value] ?: throw IllegalArgumentException("No such key found for given value '$value.'")
    }

    open fun <V : T> register(path: String, value: V): V {
        return register(Identifier(namespace, path), value)
    }
}