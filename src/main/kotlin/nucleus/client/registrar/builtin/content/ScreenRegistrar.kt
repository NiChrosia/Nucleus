package nucleus.client.registrar.builtin.content

import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import nucleus.common.registrar.type.identity.IdentifyingRegistrar

open class ScreenRegistrar(namespace: String) : IdentifyingRegistrar<ScreenEntry<*, *>>(namespace) {
    override fun publish(key: Identifier, value: ScreenEntry<*, *>): ScreenEntry<*, *> {
        return super.publish(key, value).also(ScreenEntry<*, *>::publish)
    }
}