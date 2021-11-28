package nucleus.common.registrar.type

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.division.RegistrarRoot

/** A subclass of [PublicationRegistrar] that publishes content to the given Minecraft [Registry], making use of the
 * phase system. */
open class VanillaRegistrar<V, R : RegistrarRoot<R>>(root: R, val registry: Registry<V>) : PublicationRegistrar<Identifier, V, R>(root) {
    override fun publish(key: Identifier, value: V) {
        Registry.register(registry, key, value)
    }
}