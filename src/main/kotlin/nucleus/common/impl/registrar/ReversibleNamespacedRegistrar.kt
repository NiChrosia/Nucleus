package nucleus.common.impl.registrar

import net.minecraft.util.Identifier
import nucleus.common.api.registrar.Registrar
import nucleus.common.api.registrar.capability.Namespaced
import nucleus.common.api.registrar.capability.Reversible

open class ReversibleNamespacedRegistrar<V>(override val namespace: String) : Registrar<Identifier, V>, Reversible<V>, Namespaced<V> {
    val content = hashMapOf<Identifier, V>()
    val reversed = hashMapOf<V, Identifier>()

    override fun <T : V> register(key: Identifier, value: T): T {
        content[key] = value
        reversed[value] = key

        return value
    }

    override fun get(key: Identifier): V {
        return content[key] ?: throw noElementFound(key)
    }

    override fun identify(value: V): Identifier {
        return reversed[value] ?: throw noKeyFound(value)
    }
}