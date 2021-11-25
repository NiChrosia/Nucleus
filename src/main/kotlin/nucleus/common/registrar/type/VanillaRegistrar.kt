package nucleus.common.registrar.type

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.RegistrarGroup

open class VanillaRegistrar<V>(group: RegistrarGroup, val registry: Registry<V>) : IdRegistrar<V>(group), Publishable<Identifier, V>, BinaryRegistrar<Identifier, V> {
    override val reversed = mutableMapOf<V, Identifier>()

    override fun register(key: Identifier, value: V) {
        super.register(key, value)

        reversed[value] = key
    }

    override fun publish() {
        super.publish()

        content.forEach(this::publish)
    }

    override fun publish(key: Identifier, value: V) {
        Registry.register(registry, key, value)
    }
}