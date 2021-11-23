package nucleus.client.registrar.type.content

import net.minecraft.util.Identifier
import nucleus.common.registrar.base.identity.IdentifyingRegistrar

open class ScreenRegistrar(namespace: String) : IdentifyingRegistrar<ScreenEntry<*, *>>(namespace) {
    override fun publish(key: Identifier, value: ScreenEntry<*, *>): ScreenEntry<*, *> {
        return super.publish(key, value).also(ScreenEntry<*, *>::publish)
    }
}