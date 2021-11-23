package nucleus.common.registrar.type.vanilla

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.type.identity.IdentifyingRegistrar

open class VanillaRegistrar<V>(val vanillaRegistry: Registry<V>, namespace: String) : IdentifyingRegistrar<V>(namespace) {
    override fun publish(key: Identifier, value: V): V {
        return super.publish(key, value).also {
            Registry.register(vanillaRegistry, key, value)
        }
    }
}