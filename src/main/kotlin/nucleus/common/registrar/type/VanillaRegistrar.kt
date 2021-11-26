package nucleus.common.registrar.type

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.division.RegistrarRoot

open class VanillaRegistrar<V, R : RegistrarRoot<R>>(root: R, val registry: Registry<V>) : PublicationRegistrar<Identifier, V, R>(root) {
    override fun publish(key: Identifier, value: V) {
        Registry.register(registry, key, value)
    }
}