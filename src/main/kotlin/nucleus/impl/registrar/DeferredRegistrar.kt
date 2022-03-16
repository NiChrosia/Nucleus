package nucleus.impl.registrar

import net.minecraft.util.Identifier
import nucleus.api.registrar.ReversibleRegistrar
import net.minecraft.util.registry.Registry as MinecraftRegistry

open class DeferredRegistrar<T>(val minecraft: MinecraftRegistry<T>, val namespace: String) : ReversibleRegistrar<T> {
    override fun <V : T> register(key: Identifier, value: V): V {
        return MinecraftRegistry.register(minecraft, key, value)
    }

    override fun get(key: Identifier): T {
        return minecraft[key] ?: throw IllegalArgumentException("No such element found for the given key '$key.'")
    }

    override fun identify(value: T): Identifier {
        return minecraft.getId(value) ?: throw IllegalArgumentException("No such key found for given value '$value.'")
    }

    open fun <V : T> register(path: String, value: V): V {
        return register(Identifier(namespace, path), value)
    }
}