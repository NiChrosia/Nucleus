package nucleus.common.impl.registrar

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.api.registrar.Registrar
import nucleus.common.api.registrar.capability.Namespaced
import nucleus.common.api.registrar.capability.Reversible

open class MinecraftRegistrar<V>(val minecraft: Registry<V>, override val namespace: String) : Registrar<Identifier, V>, Reversible<Identifier, V>, Namespaced<V> {
    override fun <T : V> register(key: Identifier, value: T): T {
        return Registry.register(minecraft, key, value)
    }

    override fun get(key: Identifier): V {
        return minecraft[key] ?: throw noElementFound(key)
    }

    override fun identify(value: V): Identifier {
        return minecraft.getId(value) ?: throw noKeyFound(value)
    }
}