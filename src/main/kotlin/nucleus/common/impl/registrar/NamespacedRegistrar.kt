package nucleus.common.impl.registrar

import net.minecraft.util.Identifier
import nucleus.common.api.registrar.Registrar
import nucleus.common.api.registrar.capability.Namespaced

open class NamespacedRegistrar<V>(override val namespace: String) : Registrar<Identifier, V>, Namespaced<V> {
    val content = hashMapOf<Identifier, V>()

    override fun <T : V> register(key: Identifier, value: T): T {
        content[key] = value

        return value
    }

    override fun get(key: Identifier): V {
        return content[key] ?: throw noElementFound(key)
    }
}